package e.nikita.farmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Customer_next extends AppCompatActivity {
    Button n,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_next);
        n=(Button)findViewById(R.id.newC);
        r=(Button)findViewById(R.id.require);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Customer_next.this,Customer_newCommodity.class);
                Bundle bundle = getIntent().getExtras();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Customer_next.this,customerRequirement.class);
                Bundle bundle = getIntent().getExtras();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
