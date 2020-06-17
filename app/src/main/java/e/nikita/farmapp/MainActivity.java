package e.nikita.farmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText username,password;
    TextView sign;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.un);
        password=(EditText)findViewById(R.id.pass);
        b1=(Button)findViewById(R.id.log);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("user");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    login();
            }
        });
        sign=(TextView)findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private  void login()
    {
        databaseReference.child(username.getText().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String u=username.getText().toString();
                String p=password.getText().toString();
                if(dataSnapshot.exists()) {
                    User user = dataSnapshot.getValue(User.class);
                    if (p.equals(user.getPassword())) {
                        Intent intent = new Intent(MainActivity.this, customerFarmer.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("username",username.getText().toString());
                        bundle.putString("password",password.getText().toString());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Enter valid password",Toast.LENGTH_LONG).show();
                    }
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}


