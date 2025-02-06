package com.example.registrationusingpreference;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.registrationusingpreference.databinding.ActivityLoginBinding;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {


    ActivityLoginBinding binding;
    MyPrefs myPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        myPrefs=new MyPrefs(LoginActivity.this);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validateFields())
                {
                    if(myPrefs.getEmail().equals(binding.etEmail.getText().toString()) && myPrefs.getPassword().equals(binding.etPassword.getText().toString()))
                    {
                        myPrefs.setUserExist(true);
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                }
            }
        });

        binding.tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

    public boolean validateFields(){

        ArrayList<Boolean> list=new ArrayList<>();


        if(Validation.isValidEmail(binding.etEmail.getText().toString()))
        {
            binding.layoutEmail.setError(null);
            list.add(true);
        }else{
            binding.layoutEmail.setError("Email is required");
            list.add(false);

        }
        if (Validation.isValidPassword(binding.etPassword.getText().toString())){
            binding.layoutPassword.setError(null);
            list.add(true);
        }else{
            binding.layoutPassword.setError("Password is required");
            list.add(false);
        }
        return !list.contains(false);
    }
}