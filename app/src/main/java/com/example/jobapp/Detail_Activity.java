package com.example.jobapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Detail_Activity extends AppCompatActivity {

    private Button bookmarkButton; // Declare the button here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Initialize the button after setContentView
        bookmarkButton = findViewById(R.id.bookmar);

        TextView titleTv = findViewById(R.id.mTitle);
        TextView locationTv = findViewById(R.id.mLocation);
        TextView salaryTv = findViewById(R.id.mSalary);
        TextView phoneTv = findViewById(R.id.mPhone);

        // Ensure bundle is not null and contains the required data
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String title = bundle.getString("title", "No Title");
            String location = bundle.getString("Place", "No Location");
            String salary = bundle.getString("Salary", "No Salary");
            String phone = bundle.getString("whatsapp_no", "No Phone");

            titleTv.setText(title);
            locationTv.setText(location);
            salaryTv.setText(salary);
            phoneTv.setText(phone);
        } else {
            // Handle case where bundle is null, if necessary
            titleTv.setText("No Title");
            locationTv.setText("No Location");
            salaryTv.setText("No Salary");
            phoneTv.setText("No Phone");
        }

        // Set onClickListener after initializing the button
        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Detail_Activity.this, "Bookmarked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
