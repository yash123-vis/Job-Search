package com.example.jobapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobHolder> {

    private Context context;
    private List<Job> jobList;

    public JobAdapter(Context context, List<Job> jobs) {
        this.context = context;
        this.jobList = jobs;
    }

    @NonNull
    @Override
    public JobHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new JobHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobHolder holder, int position) {
        Job job = jobList.get(position);

        holder.title.setText(job.getTitle());
        holder.location.setText(job.getLocation());
        holder.salary.setText(job.getSalary());
        holder.phone.setText(job.getPhone());

        holder.constraintLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, Detail_Activity.class);
            intent.putExtra("title", job.getTitle());
            intent.putExtra("Place", job.getLocation());
            intent.putExtra("Salary", job.getSalary());
            intent.putExtra("whatsapp_no", job.getPhone());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public class JobHolder extends RecyclerView.ViewHolder {

        TextView title, location, salary, phone;
        ConstraintLayout constraintLayout;

        public JobHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.job_title);
            location = itemView.findViewById(R.id.job_location);
            salary = itemView.findViewById(R.id.job_salary);
            phone = itemView.findViewById(R.id.job_phone);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
