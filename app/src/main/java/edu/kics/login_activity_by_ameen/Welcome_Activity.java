package edu.kics.login_activity_by_ameen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Welcome_Activity extends AppCompatActivity {

    EditText et_mail,et_password;
    FloatingActionButton btn_movetonext;
    boolean isEmailValid, isPasswordValid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);
        getSupportActionBar().hide();

        et_mail=findViewById(R.id.et_mail);
        et_password=findViewById(R.id.et_password);
        btn_movetonext=findViewById(R.id.btn_movetonext);

        btn_movetonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetValidation();
            }
        });

    }
    public void SetValidation() {
        // Check for a valid email address.
        if (et_mail.getText().toString().isEmpty())
        {
            et_mail.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(et_mail.getText().toString()).matches())
        {
            et_mail.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        }
        else
            {
            isEmailValid = true;
        }

        // Check for a valid password.
        if (et_password.getText().toString().isEmpty())
        {
           et_password.setError(getResources().getString(R.string.password_error));
           isPasswordValid = false;
        }
        else if (et_password.getText().length() < 6)
        {
            et_password.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else  {
            isPasswordValid = true;
        }

        if (isEmailValid && isPasswordValid)
        {
            Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Welcome_Activity.this,SignupActivity.class);
            startActivity(intent);
        }

    }

}
