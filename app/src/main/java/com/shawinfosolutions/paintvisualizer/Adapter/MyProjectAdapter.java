package com.shawinfosolutions.paintvisualizer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shawinfosolutions.paintvisualizer.Activity.SelectedProjectActivity;
import com.shawinfosolutions.paintvisualizer.Model.ColorData;
import com.shawinfosolutions.paintvisualizer.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class  MyProjectAdapter extends
        RecyclerView.Adapter<MyProjectAdapter.ViewHolder> {
    private final LayoutInflater mInflater;
    private Context mContext;
     private Integer[] mThumbIds;
    private String[] imageName;
    // ... constructor and member variables

    public MyProjectAdapter(Context context, Integer[] mThumbIds, String[] imageName) {
        this.mContext = context;
        this.mThumbIds=mThumbIds;
        this.imageName=imageName;
        this.mInflater = LayoutInflater.from(context);
    }
    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public MyProjectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.my_project_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MyProjectAdapter.ViewHolder holder, int position) {
        // Get the data model based on position

        // Set item views based on your views and data model
        holder.ProjectName.setText(imageName[position]);


//        TextView textView = holder.nameTextView;
//        textView.setText(contact.getName());
        Glide.with(mContext)
                .load(mThumbIds[position])
                .into(holder.projectImg);


        holder.projectLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, SelectedProjectActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return imageName.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView projectImg;
        TextView ProjectName;
        LinearLayout projectLayout;

        ViewHolder(View itemView) {
            super(itemView);
            projectImg = itemView.findViewById(R.id.projectImg);
            ProjectName=itemView.findViewById(R.id.ProjectName);
            projectLayout=itemView.findViewById(R.id.projectLayout);
        }

    }
}
