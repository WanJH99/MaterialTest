package com.example.materialtest;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

public class Register extends AppCompatActivity {

    private Button register_sure;

    private Button register_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //隐藏自带标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        register_sure = (Button) findViewById(R.id.register_btn_sure);
        register_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Register.this, HelloWorldActivity.class);
                //startActivity(intent);
                LitePal.getDatabase();
                EditText register_user_name = (EditText) findViewById(R.id.user_name);
                final String UserName = register_user_name.getText().toString();

                EditText register_user_password1 = (EditText) findViewById(R.id.user_password_first);
                final String UserPassword1 = register_user_password1.getText().toString();

                EditText register_user_password2 = (EditText) findViewById(R.id.user_password_second);
                final String UserPassword2 = register_user_password2.getText().toString();

                if (UserPassword1.equals(UserPassword2)==true){
                    User_Information user = new User_Information();
                    user.setUser_name(UserName);
                    user.setUser_password(UserPassword1);
                    user.save();
                    Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register_cancel = (Button) findViewById(R.id.register_btn_cancel);
        register_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });


    }
}
