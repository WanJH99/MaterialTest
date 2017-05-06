package com.example.materialtest;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Login extends AppCompatActivity {

    private Button register;

    private Button login_back;

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //隐藏自带标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        login_back = (Button) findViewById(R.id.title_back);
        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText login_user_name = (EditText) findViewById(R.id.login_user_name);
                String LoginUserName = login_user_name.getText().toString();

                EditText login_user_password = (EditText) findViewById(R.id.login_user_password);
                String LoginUserPassword = login_user_password.getText().toString();

                List<User_Information> allUser = DataSupport.findAll(User_Information.class);

                for(User_Information user_information :allUser)
                {
                    if (user_information.getUser_name().equals(LoginUserName)&&user_information.getUser_password().equals(LoginUserPassword))
                    {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    }
                }

            }
        });

    }


}
