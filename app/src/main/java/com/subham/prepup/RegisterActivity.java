package com.subham.prepup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_fname;
    private EditText et_mname;
    private EditText et_lname;
    private EditText et_phnumber;
    private EditText et_email;
    private EditText et_password;
    private EditText et_cpassword;
    private EditText et_inst;
    private EditText et_role;
    private Button btn_login;
    private Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();  //For Hide the Action Bar

        et_fname = findViewById(R.id.et_fname);
        et_mname = findViewById(R.id.et_mname);
        et_lname = findViewById(R.id.et_lname);
        et_phnumber = findViewById(R.id.et_Phnumber);
        et_email = findViewById(R.id.et_Email);
        et_password = findViewById(R.id.et_password);
        et_cpassword = findViewById(R.id.et_Cpassword);
        et_inst = findViewById(R.id.et_Inst);
        et_role = findViewById(R.id.et_role);
        btn_login = findViewById(R.id.btn_login);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(et_fname.getText().toString())
                        || TextUtils.isEmpty(et_lname.getText().toString())
                        || TextUtils.isEmpty(et_phnumber.getText().toString())
                        || TextUtils.isEmpty(et_email.getText().toString())
                        || TextUtils.isEmpty(et_password.getText().toString())
                        || TextUtils.isEmpty(et_inst.getText().toString())
                        || TextUtils.isEmpty(et_role.getText().toString())
                ) {
                    String messege = "All Inputs Required";
                    Toast.makeText(RegisterActivity.this, messege,Toast.LENGTH_LONG).show();
                }else{
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setFname(et_fname.getText().toString());
                    registerRequest.setLname(et_mname.getText().toString());
                    registerRequest.setMname(et_lname.getText().toString());
                    registerRequest.setPhone(et_phnumber.getText().length());
                    registerRequest.setEmail(et_email.getText().toString());
                    registerRequest.setPassword(et_password.getText().toString());
                    registerRequest.setInstitute(et_inst.getText().toString());
                    registerRequest.setRole(et_role.getText().toString());
                    SignupUser(registerRequest);
                }
            }

            private void SignupUser(RegisterRequest registerRequest) {
                HashMap<String,Object> params = new HashMap<>();
                params.put("fname",registerRequest.getFname());
                params.put("mname",registerRequest.getMname());
                params.put("lname",registerRequest.getLname());
                params.put("phone",registerRequest.getPhone());
                params.put("email",registerRequest.getEmail());
                params.put("password",registerRequest.getPassword());
                params.put("inst",registerRequest.getInstitute());
                params.put("role",registerRequest.getRole());
                UserService userService = ApiClient.getRetrofit().create(UserService.class);
                Call<RegisterResponse> RegisterResponseCall = userService.SignupUser(params);
                RegisterResponseCall.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        RegisterResponse registerResponse = response.body();
                        if(response.isSuccessful()){
                            registerResponse = response.body();
                            if(registerResponse.status_code == 200){
                                startActivity(new Intent(RegisterActivity.this,StudentDeshbordActivity.class));
                            }else{
                                String messege = "Custom Error";
                                Toast.makeText(RegisterActivity.this,messege, Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            String messege = "An Error occurred please try again later ";
                            Toast.makeText(RegisterActivity.this, messege, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        String messege = t.getLocalizedMessage();
                        Toast.makeText(RegisterActivity.this, messege, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




    }
    public void  Login() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}