package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView name,email;
    Button log_out;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        log_out = findViewById(R.id.log_out);

        sharedPreferences = getSharedPreferences("mydata",MODE_PRIVATE);

        String user_name = sharedPreferences.getString("mydata_name",null);
        String user_email = sharedPreferences.getString("mydata_email",null);

        if(name!=null || email!=null) {
            name.setText(user_name);
            email.setText(user_email);
        }

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();

                Toast.makeText(HomeActivity.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();

            }
        });

    }
}