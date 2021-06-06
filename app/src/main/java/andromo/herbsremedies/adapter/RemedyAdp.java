package andromo.herbsremedies.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import andromo.herbsremedies.R;
import andromo.herbsremedies.RemedyDisplay;
import andromo.herbsremedies.model.RemedyModel;


public class RemedyAdp extends RecyclerView.Adapter<RemedyAdp.MyViewHolder> {

    private Context mContext;
    private List<RemedyModel> spllist;

    public RemedyAdp(Context mContext, List<RemedyModel> spllist) {
        this.mContext = mContext;
        this.spllist = spllist;
    }

    @Override
    public RemedyAdp.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cv, viewGroup, false);

        return new RemedyAdp.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RemedyAdp.MyViewHolder viewHolder, int i) {
        viewHolder.title.setText(spllist.get(i).getName());
        Picasso.with(mContext)
                .load(spllist.get(i).getPic())
                .placeholder(R.drawable.as)
                .into(viewHolder.cpic);

    }

    @Override
    public int getItemCount() {
        return spllist.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView cpic;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            cpic = (ImageView) view.findViewById(R.id.cpic);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        RemedyModel clickedDataItem = spllist.get(pos);
                        Intent intent = new Intent(mContext, RemedyDisplay.class);
                        intent.putExtra("txt",spllist.get(pos).getTxt());
                        intent.putExtra("url", spllist.get(pos).getUrl());
                        intent.putExtra("name", spllist.get(pos).getName());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}