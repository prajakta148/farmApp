package e.nikita.farmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class farmer_next extends AppCompatActivity {
    Button n,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_next);
        n=(Button)findViewById(R.id.newC);
        r=(Button)findViewById(R.id.require);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(farmer_next.this,NewCommodity.class);
                Bundle bundle = getIntent().getExtras();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(farmer_next.this,FarmerRequirement.class);
                Bundle bundle = getIntent().getExtras();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
