package e.nikita.farmapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleAd extends RecyclerView.Adapter<RecycleAd.Viewh>{
    Context context;
    ArrayList<Commodity>commodity;
    public RecycleAd(Context c,ArrayList<Commodity> commodity1)
    {
        context=c;
        commodity=commodity1;
    }
    @NonNull
    @Override
    public Viewh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewh(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewh holder, int position) {
        String comm,quan,mobi,pri;
        holder.c1.setText(commodity.get(position).getCommo());
        holder.m1.setText(commodity.get(position).getMobile());
        holder.p1.setText(commodity.get(position).getPrice());
        holder.q1.setText(commodity.get(position).getQuantity());

        holder.city1.setText(commodity.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return commodity.size();
    }

    public  class Viewh extends RecyclerView.ViewHolder{
        TextView c1,p1,m1,q1,city1;
        public Viewh(View itemView) {
            super(itemView);
            c1=(TextView)itemView.findViewById(R.id.c);
            q1=(TextView)itemView.findViewById(R.id.q);
            m1=(TextView)itemView.findViewById(R.id.m);
            p1=(TextView)itemView.findViewById(R.id.p);
            city1=(TextView)itemView.findViewById(R.id.city11);
        }
    }
}
