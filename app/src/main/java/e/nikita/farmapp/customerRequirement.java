package e.nikita.farmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class customerRequirement extends AppCompatActivity {
    AutoCompleteTextView act;
    String[] commodity1=new String[]{"Rice","Wheat","Sunflower","Groundnuts","Apple","Sweet lime","onion","potato","chilly","Tomato","Orange","Grapes","Banana","Sugarcane","Cotton","Mango"};
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_requirement);
        act=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,commodity1);
        act.setAdapter(adapter);
        btn=(Button)findViewById(R.id.reg);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(act.getText().toString().length()!=0){
                Intent intent = new Intent(customerRequirement.this, customerListDisplay.class);
                Bundle bundle = getIntent().getExtras();
                bundle.putString("c", act.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }

                else {
                    act.setError("Please Enter the commodity");
                }
            }
        });

    }
}
