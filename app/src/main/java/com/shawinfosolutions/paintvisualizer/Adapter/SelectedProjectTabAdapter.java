package com.shawinfosolutions.paintvisualizer.Adapter;

import android.content.Context;

import com.shawinfosolutions.paintvisualizer.Fragments.AllColorExplorerFragment;
import com.shawinfosolutions.paintvisualizer.Fragments.ColorFragment;
import com.shawinfosolutions.paintvisualizer.Fragments.GalleryFragment;
import com.shawinfosolutions.paintvisualizer.Fragments.MyColorExplorerFragment;
import com.shawinfosolutions.paintvisualizer.Fragments.ProductsFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SelectedProjectTabAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public SelectedProjectTabAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                GalleryFragment decorFragment = new GalleryFragment();
                return decorFragment;
            case 1:
                ColorFragment autoFragment = new ColorFragment();
                return autoFragment;
  case 2:
                ProductsFragment prodFragment = new ProductsFragment();
                return prodFragment;

            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}