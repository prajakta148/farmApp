package e.nikita.farmapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Commodity> {
   private Activity context;
    private  List<Commodity>commodity1;
    public MyAdapter(Activity context,List<Commodity> commodity1)
    {
        super(context,R.layout.cardview,commodity1);
        this.context=context;
        this.commodity1=commodity1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.cardview,null,true);
        TextView c1,p1,m1,q1,city1;
            c1=(TextView)view.findViewById(R.id.c);
            q1=(TextView)view.findViewById(R.id.q);
            m1=(TextView)view.findViewById(R.id.m);
            p1=(TextView)view.findViewById(R.id.p);
            city1=(TextView)view.findViewById(R.id.city11);
            Commodity commodity=commodity1.get(position);
            c1.setText(commodity.getCommo());
            q1.setText(commodity.getQuantity());
            m1.setText(commodity.getMobile());
            p1.setText(commodity.getPrice());
            city1.setText(commodity.getCity());
            return  view;
    }
}
