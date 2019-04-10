package com.example.app;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ReviewListViewHolder> {

    private List<String> data;
    //private List<String> data1;
    Context context;
    private LayoutInflater inflater;
    private ReviewListAdapter.ClickListener clickListener;

    //ReviewListAdapter(Context context, List<String> data, List<String> data1) {
    ReviewListAdapter(Context context, List<String> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        //this.data1 = data1;
    }

    @Override
    public ReviewListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_review_list_adapter, parent, false);
        return new ReviewListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewListViewHolder holder, int position) {

        holder.checkBox.setText(data.get(position));
        holder.checkBox.setChecked(false);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    class ReviewListViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBox;

        ReviewListViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    //clickListener.onItemClick(compoundButton.getText().toString(), data1.get(getLayoutPosition()), getLayoutPosition());
                    clickListener.onItemClick(data.get(getLayoutPosition()));
                }
            });
        }
    }

    interface ClickListener {
        void onItemClick(String name);
    }

}

