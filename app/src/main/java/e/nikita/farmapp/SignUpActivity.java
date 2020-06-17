package e.nikita.farmapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    EditText username,password,mobile;
    TextView already;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        mobile = (EditText) findViewById(R.id.mobile);
        register = (Button) findViewById(R.id.register);
        already=(TextView)findViewById(R.id.loginalready);
        firebaseDatabase=FirebaseDatabase.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addUser();
            }
        });
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        databaseReference=firebaseDatabase.getReference("user");
    }
    void addUser()
    {
        if(username.getText().toString().trim().length()!=8)
        {
            username.setError("please enter valid username");
        }

        if(password.getText().toString().trim().length()!=8)
        {
            password.setError("please enter valid password");
        }
        if(mobile.getText().toString().trim().length()!=10)
        {
            mobile.setError("please Enter valid mobile number");
        }


        if(username.getText().toString().trim().length()==8 && mobile.getText().toString().trim().length()==10 && password.getText().toString().trim().length()==8)
        {
            String name=username.getText().toString();
            String pass=password.getText().toString();
            String mobil=mobile.getText().toString();


            User user=new User(name,pass,mobil);
            String uid=databaseReference.push().getKey();
            databaseReference.child(user.getUserName()).setValue(user);
            Toast.makeText(getApplicationContext(),"User Added",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
    }

