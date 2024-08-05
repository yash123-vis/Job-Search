package com.example.jobapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JobSearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Job> jobList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_job__search, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        requestQueue = VolleySingleton.getmInstance(getContext()).getRequestQueue();
        jobList = new ArrayList<>();
        fetchJobs();

        return view;
    }

    private void fetchJobs() {
        String url = "https://testapi.getlokalapp.com/common/jobs?page=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Log the entire response for debugging
                            Log.d("API_RESPONSE", response.toString());

                            // Access the 'results' key instead of 'data'
                            if (response.has("results")) {
                                JSONArray resultsArray = response.getJSONArray("results");

                                for (int i = 0; i < resultsArray.length(); i++) {
                                    JSONObject jobObject = resultsArray.getJSONObject(i);

                                    // Debug: Log the keys in the jobObject
                                    Iterator<String> keys = jobObject.keys();
                                    while (keys.hasNext()) {
                                        String key = keys.next();
                                        Log.d("JOB_OBJECT_KEYS", key + ": " + jobObject.optString(key, "Key not found"));
                                    }

                                    // Extract job details using optString for safer access
                                    String title = jobObject.optString("title", "Title not available");
                                    JSONObject primaryDetails = jobObject.optJSONObject("primary_details");
                                    String location = (primaryDetails != null) ? primaryDetails.optString("Place", "Location not available") : "Location not available";
                                    String salary = (primaryDetails != null) ? primaryDetails.optString("Salary", "Salary not available") : "Salary not available";
                                    String phone = jobObject.optString("whatsapp_no", "Not available");

                                    // Create a Job object and add it to the list
                                    Job job = new Job(title, location, salary, phone);
                                    jobList.add(job);
                                }

                                // Notify the adapter of data changes
                                JobAdapter adapter = new JobAdapter(getContext(), jobList);
                                recyclerView.setAdapter(adapter);
                            } else {
                                Log.e("API_ERROR", "'results' key not found in response");
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }
}
