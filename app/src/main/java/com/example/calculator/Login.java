package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    private MyDatabase myDatabase;
    private SQLiteDatabase writableDatabase;
    private TextInputEditText username;
    private TextInputLayout passwordTextInput;
    private TextInputEditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        passwordTextInput = findViewById(R.id.password_text_input);
        passwordEditText = findViewById(R.id.password_edit_text);
        myDatabase = new MyDatabase(Login.this);
        writableDatabase = myDatabase.getWritableDatabase();
        MaterialButton nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!isPasswordValid(passwordEditText.getText())){
                    passwordTextInput.setError("密码应该至少包括8个字符");
                } else {
                    passwordTextInput.setError(null);
                }
                if(login(username.getText().toString(),passwordEditText.getText().toString())){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"请检查用户名或者密码",Toast.LENGTH_SHORT).show();
                }
            }
        });
        MaterialButton signin = findViewById(R.id.cancel_button);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sql = "select * from user where 姓名=?";
                Cursor cursor = writableDatabase.rawQuery(sql, new String[]{username.getText().toString()});
                if(cursor.getCount()==0){
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("姓名",username.getText().toString());
                        contentValues.put("密码",passwordEditText.getText().toString());
                        writableDatabase.insert("user",null,contentValues);
                        Toast.makeText(getApplicationContext(),"成功注册。",Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"操作异常，请检查输入。",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"已存在，请检查。",Toast.LENGTH_SHORT).show();
                }
            }
        });
        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (isPasswordValid(passwordEditText.getText())) {
                    passwordTextInput.setError(null); //Clear the error
                }
                return false;
            }
        });
    }

    public boolean login(String username,String password) {//验证此账号密码是否正确

        String sql = "select * from user where 姓名=? and 密码=?";//将登录时填的账号和密码在数据库里面进行查询，如果存在该数据，则返回true，否则返回false

        Cursor cursor = writableDatabase.rawQuery(sql, new String[] {username, password});

        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }

    private boolean isPasswordValid(@Nullable Editable text) {
        return text != null && text.length() >= 8;
    }
}
