package com.moringaschool.diete.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.moringaschool.diete.category.CategoryFragment;
import com.moringaschool.diete.models.Categories;

import java.util.List;

public class ViewPagerCategoryAdapter extends FragmentPagerAdapter {

    private List<Categories.Category> categories;

    public ViewPagerCategoryAdapter(FragmentManager fm, List<Categories.Category> categories) {
        super(fm);
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
//       args.putString("EXTRA_DATA_NAME", categories.get(i).getStrCategory());
//        args.putString("EXTRA_DATA_DESC", categories.get(i).getStrCategoryDescription());
//        args.putString("EXTRA_DATA_IMAGE", categories.get(i).getStrCategoryThumb());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getStrCategory();
    }
}

