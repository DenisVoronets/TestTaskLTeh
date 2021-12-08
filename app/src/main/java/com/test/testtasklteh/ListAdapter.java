package com.test.testtasklteh;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.testtasklteh.ListDataUtils.ListDataModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListDataModel> dataList;
    private Activity activity;

    public ListAdapter(List<ListDataModel> dataList, Activity activity ) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get()
                .load(Constans.BASE_URL_PHONE_MASK.concat(dataList.get(position).getImage()))
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .into(holder.imageView);
        holder.title.setText(dataList.get(position).getTitle());
        holder.description.setText(dataList.get(position).getDescription());
        holder.date.setText(dataList.get(position).getDate());


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView description;
        private TextView date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_pic);
            title = itemView.findViewById(R.id.textView_title);
            description = itemView.findViewById(R.id.textView_description);
            date = itemView.findViewById(R.id.textView_date);
            itemView. setOnClickListener(view -> {
                Intent intent = new Intent(activity, ItemRecyclerListActivity.class);
                intent.putExtra("title",title.getText());
                intent.putExtra("description",description.getText());
                intent.putExtra("date",date.getText());
                Constans.PIC_NAME = imageView.getDrawable();
                activity.startActivity(intent);
                activity.finish();
            });
        }
    }
}
