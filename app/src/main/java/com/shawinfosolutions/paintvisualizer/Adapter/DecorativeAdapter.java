package com.shawinfosolutions.paintvisualizer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shawinfosolutions.paintvisualizer.Activity.OurProductInDetailsActivity;
import com.shawinfosolutions.paintvisualizer.R;

public class DecorativeAdapter extends BaseAdapter {
    private Context mContext;
  private   Integer[] mThumbIds;
  private String[] imageName;

    // Constructor
    public DecorativeAdapter(Context mContext, Integer[] mThumbIds, String[] imageName) {
        this.mContext = mContext;
        this.mThumbIds=mThumbIds;
        this.imageName=imageName;
    }

    @Override
    public int getCount() {
        return mThumbIds.length; //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds.length; //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.decorative_items, parent, false);
        }

        // get current item to be displayed
      //  Item currentItem = (Item) getItem(position);

        // get the TextView for item name and item description
        TextView ColorNameTxt = (TextView)
                convertView.findViewById(R.id.ColorNameTxt);
        ImageView ItemImg = (ImageView)
                convertView.findViewById(R.id.ItemImg);

        //sets the text for item name and item description from the current item object
        ColorNameTxt.setText(imageName[position]);
      //  ItemImg.setText(mThumbIds.getItemDescription());
        Glide.with(mContext)
                .load(mThumbIds[position])
                .into(ItemImg);

       LinearLayout productLayout=(LinearLayout) convertView.findViewById(R.id.productLayout);
        productLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, OurProductInDetailsActivity.class);
                mContext.startActivity(intent);

            }
        });
        // returns the view for the current row
        return convertView;
    }

}