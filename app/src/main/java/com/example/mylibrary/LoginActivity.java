package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = findViewById(R.id.btn);
        EditText userEdt = findViewById(R.id.userName);
        EditText passEdt = findViewById(R.id.password);

        btn.setOnClickListener((v) -> {
            if(userEdt.getText().toString().equals("rosan@gmail.com") && passEdt.getText().toString().equals("252525") && passEdt.getText().length()>5){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();

            }
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://jobs.idealite.in:3306/mylibrary", "ashish", "pass123");
                Statement statement = connection.createStatement();
                statement.execute("SELECT * FROM users");
                Log.d("result","thgthg");

                Log.d("result", String.valueOf(statement.getResultSet()));
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}