package com.example.animedxd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText usernameTxt, passwordTxt;
    private Button submitBtn;

    private String extractString(EditText e){
        return e.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        submitBtn = findViewById(R.id.submitBtn);
        usernameTxt = findViewById(R.id.usernameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);

        submitBtn.setOnClickListener(v -> {
            String usernameString = extractString(usernameTxt);
            String passwordString = extractString(passwordTxt);
            TextView errorTxt = findViewById(R.id.errorTxt);

            if(usernameString.isEmpty() && passwordString.isEmpty()){
                errorTxt.setText("Username And Password Cannot Be Empty");
                return;
            }
            if(usernameString.isEmpty()){
                errorTxt.setText("Username Cannot Be Empty");
                return;
            }
            if(passwordString.isEmpty()){
                errorTxt.setText("Password Cannot Be Empty");
                return;
            }
            if(usernameString.length() < 5 || usernameString.length() > 10){
                errorTxt.setText("The Letters In The Username Must Be A Minimum Of 5 And Maximum Of 10 Characters.");
                return;
            }

            // If all validations pass, clear any previous error
            errorTxt.setText("");

            // Redirect to Home
            Intent intent = new Intent(MainActivity.this, Home.class);
            intent.putExtra("USERNAME", usernameString); // Pass the username
            startActivity(intent);
            finish(); // Close the login screen
        });
    }
}