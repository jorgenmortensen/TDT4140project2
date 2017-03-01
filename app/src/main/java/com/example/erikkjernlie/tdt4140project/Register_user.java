package com.example.erikkjernlie.tdt4140project;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register_user extends AppCompatActivity {

    private EditText enterEmailAddress;
    private EditText enterPassword;
    private Button logInBtn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(Register_user.this);

        enterEmailAddress = (EditText) findViewById(R.id.enterEmailAddress);
        enterPassword = (EditText) findViewById(R.id.enterPassword);

        logInBtn = (Button) findViewById(R.id.logInBtn);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    public void registerUser() {
        String email = enterEmailAddress.getText().toString().trim();
        String password = enterPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //Write email again
            Toast.makeText(Register_user.this, "Write email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            //Write password again
            Toast.makeText(Register_user.this, "Write password!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Register_user.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //Successfull user registration
                    Toast.makeText(Register_user.this, "It worked, yaay", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                } else {
                    //Must try again
                    Toast.makeText(Register_user.this, "It didnt work", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });


    }
}