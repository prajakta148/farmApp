package e.nikita.farmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Customer_newCommodity extends AppCompatActivity {
    String[] commodity1=new String[]{"Rice","Wheat","Sunflower","Groundnuts","Apple","Sweet lime","onion","potato","chilly","Tomato","Orange","Grapes","Banana","Sugarcane","Cotton","Mango"};
    String[] city1=new String[]{"Pune","Jalgaon","Nashik","Yavatmal","Baramati","Nanded","Jamner","Malegaon","Akola","Pahur","Amalner","Dhule","Shendurni","Sangli-Miraj-kupwad","Kolhapur","Solapur","Satara"};
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText c,cc,q,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_new_commodity);
        AutoCompleteTextView act = (AutoCompleteTextView) findViewById(R.id.commodity);
        AutoCompleteTextView act1 = (AutoCompleteTextView) findViewById(R.id.city);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,commodity1);
        act.setAdapter(adapter);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,city1);
        act1.setAdapter(adapter1);
        c=(EditText)findViewById(R.id.commodity);
        cc=(EditText)findViewById(R.id.city);
        q=(EditText)findViewById(R.id.quantity);
        p=(EditText)findViewById(R.id.price);
       firebaseDatabase=FirebaseDatabase.getInstance();
        Button b=(Button)findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCommodity();
            }
        });
     databaseReference=firebaseDatabase.getReference("customerCommodity");
    }
    String price,quan,city,comm;
    private void addCommodity()
    {

        price=p.getText().toString();
        quan=q.getText().toString();
        city=cc.getText().toString();
        comm=c.getText().toString();
        Bundle bundle = getIntent().getExtras();
        final String un=bundle.getString("username");

        if(price.length()==0)
        {
            p.setError("Please Enter Price");
        }
        if(quan.length()==0)
        {
            q.setError("Please Enter quantity");
        }
        if(city.length()==0)
        {
            cc.setError("Please Enter City");
        }
        if(comm.length()==0)
        {
            c.setError("Please Enter Commodity");
        }


        if(price.length()!=0 && quan.length()!=0 && city.length()!=0 && comm.length()!=0) {
            DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference("user");
            databaseReference1.child(un).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    String mobile = user.getMobile();
                    Ccommodity com = new Ccommodity(city, comm, price, quan, mobile);
                    String uid = databaseReference.push().getKey();
                    databaseReference.child(uid).setValue(com);
                    Toast.makeText(getApplicationContext(),"Commodity Added",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
