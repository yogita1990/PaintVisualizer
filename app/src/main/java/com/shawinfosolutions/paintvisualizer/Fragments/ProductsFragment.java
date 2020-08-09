package com.shawinfosolutions.paintvisualizer.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.shawinfosolutions.paintvisualizer.Adapter.DecorativeAdapter;
import com.shawinfosolutions.paintvisualizer.R;

import androidx.fragment.app.Fragment;

public class ProductsFragment extends Fragment {

    private GridView gridView;
    Context thiscontext;
    public Integer[] mThumbIds = {
            R.drawable.duco, R.drawable.paint_bucket,
            R.drawable.paint_bucket, R.drawable.paint_bucket,
            R.drawable.paint_bucket, R.drawable.paint_bucket,
            R.drawable.paint_bucket, R.drawable.paint_bucket,
            R.drawable.paint_bucket, R.drawable.paint_bucket
    };
    public String[] ImageName={"Duco Body Filler","Silk Viney Emulsion", "Autocolor","Economy Vesto Plastic",
            "Varnish Remover","Polyfillo", "Silk Viney Emulsion","Polyfillo", "Varnish Remover","Duco Body Filler"};
    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_decorative, container, false);
        thiscontext=container.getContext();

        gridView=root.findViewById(R.id.grid_view);

        DecorativeAdapter adapter = new DecorativeAdapter(getActivity(),mThumbIds,ImageName);
        gridView.setAdapter(adapter);
        return root;

    }

}
