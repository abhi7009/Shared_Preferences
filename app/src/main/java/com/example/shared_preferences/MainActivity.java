package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    Button register;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);

        sharedPreferences = getSharedPreferences("mydata", MODE_PRIVATE);

        String data = sharedPreferences.getString("mydata_name", null);
        if (data != null) {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name = name.getText().toString();
                String user_email = email.getText().toString();

                if (TextUtils.isEmpty(user_name)) {
                    Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(user_email)) {
                    Toast.makeText(MainActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                } else {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("mydata_name", user_name);
                    editor.putString("mydata_email", user_email);
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}