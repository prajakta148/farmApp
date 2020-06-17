package e.nikita.farmapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class customerListDisplay extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<Commodity> list;
    ListView listViewCommodity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list_display);
        databaseReference=FirebaseDatabase.getInstance().getReference("commodity");
        listViewCommodity=(ListView)findViewById(R.id.listViewDisplay);
        list=new ArrayList<>();

        Bundle bundle=getIntent().getExtras();
        String c1=bundle.getString("c");
        Query query=databaseReference.orderByChild("commo").equalTo(c1);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Commodity ct=dataSnapshot1.getValue(Commodity.class);

                    list.add(ct);


                }
                MyAdapter adapter=new MyAdapter(customerListDisplay.this,list);
                listViewCommodity.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
