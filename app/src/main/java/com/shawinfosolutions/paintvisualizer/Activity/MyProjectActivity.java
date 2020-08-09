package com.shawinfosolutions.paintvisualizer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.shawinfosolutions.paintvisualizer.Adapter.MyProjectAdapter;
import com.shawinfosolutions.paintvisualizer.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyProjectActivity extends AppCompatActivity {
    RecyclerView my_project_recycle;
    public Integer[] mThumbIds = {
            R.drawable.image, R.drawable.image,
            R.drawable.image, R.drawable.image,
            R.drawable.image, R.drawable.image,
            R.drawable.image, R.drawable.image,
            R.drawable.image, R.drawable.image
    };
    ImageView homeImg, productImg, projectImg, moreImg;
    public String[] ImageName={"Project Name","Project Name", "Project Name","Project Name", "Project Name","Project Name", "Project Name","Project Name", "Project Name","Project Name"};
    private ActionBar actionbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_project_activity);
        actionbar = getSupportActionBar();
        actionbar.setTitle("MY PROJECTS");
       // actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayShowHomeEnabled(true);
        my_project_recycle=findViewById(R.id.my_project_recycle);
        my_project_recycle.setLayoutManager(new LinearLayoutManager(this));

        MyProjectAdapter adapter = new MyProjectAdapter(MyProjectActivity.this,mThumbIds,ImageName);
        // Attach the adapter to the recyclerview to populate items
        my_project_recycle.setAdapter(adapter);
        productImg = findViewById(R.id.productImg);
        homeImg = findViewById(R.id.homeImg);
        moreImg = findViewById(R.id.moreImg);

        projectImg = findViewById(R.id.projectImg);


        homeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeImg.setImageResource(R.drawable.home_blue);
                productImg.setImageResource(R.drawable.product_wh);
                projectImg.setImageResource(R.drawable.project_wh);
                moreImg.setImageResource(R.drawable.more_wh);
                Intent intent=new Intent(MyProjectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        productImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeImg.setImageResource(R.drawable.home_wh);
                productImg.setImageResource(R.drawable.product_blue);
                projectImg.setImageResource(R.drawable.project_wh);
                moreImg.setImageResource(R.drawable.more_wh);
                Intent intent=new Intent(MyProjectActivity.this, OurProductActivity.class);
                startActivity(intent);
            }
        });
        projectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeImg.setImageResource(R.drawable.home_wh);
                productImg.setImageResource(R.drawable.product_wh);
                projectImg.setImageResource(R.drawable.project_blue);
                moreImg.setImageResource(R.drawable.more_wh);
                Intent intent=new Intent(MyProjectActivity.this, MyProjectActivity.class);
                startActivity(intent);
            }
        });
        moreImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeImg.setImageResource(R.drawable.home_wh);
                productImg.setImageResource(R.drawable.product_wh);
                projectImg.setImageResource(R.drawable.project_wh);
                moreImg.setImageResource(R.drawable.more_blue);

                Intent intent=new Intent(MyProjectActivity.this,MoreOptionActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
