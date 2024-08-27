package com.example.homework_2_8;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText emailField, passwordField;
    private Button loginButton, signUpButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);

        // Инициализация SharedPreferences
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        loginButton.setOnClickListener(v -> {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();

            // Проверка на пустые поля
            if (email.isEmpty()) {
                emailField.setError("Email field is required");
                return;
            }
            if (password.isEmpty()) {
                passwordField.setError("Password field is required");
                return;
            }

            // Получение сохраненных данных пользователя
            String registeredEmail = sharedPreferences.getString("email", "");
            String registeredPassword = sharedPreferences.getString("password", "");

            // Проверка данных для входа
            if (email.equals(registeredEmail) && password.equals(registeredPassword)) {
                // Успешный вход, переходим к следующему активити
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            } else {
                // Ошибка входа
                Toast.makeText(MainActivity.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
            }
        });

        // Переход на экран регистрации
        signUpButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}