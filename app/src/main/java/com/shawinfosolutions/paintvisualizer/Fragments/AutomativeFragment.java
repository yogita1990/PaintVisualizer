package com.shawinfosolutions.paintvisualizer.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shawinfosolutions.paintvisualizer.R;

import androidx.fragment.app.Fragment;

public class AutomativeFragment
        extends Fragment {


    public AutomativeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}