package e.nikita.farmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customerFarmer extends AppCompatActivity {
    Button f,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_farmer);
        f=(Button)findViewById(R.id.farmer);
        c=(Button)findViewById(R.id.customer);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(customerFarmer.this,farmer_next.class);
                Bundle bundle = getIntent().getExtras();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(customerFarmer.this,Customer_next.class);
                Bundle bundle = getIntent().getExtras();
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
