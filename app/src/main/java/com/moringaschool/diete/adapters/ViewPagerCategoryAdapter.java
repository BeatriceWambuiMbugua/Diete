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

public class ViewPagerCategoryAdapter extends FragmentStateAdapter {

   private List<Categories.Category> categories;

    public ViewPagerCategoryAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<Categories.Category> categories) {
        super(fragmentManager, lifecycle);
        this.categories = categories;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @NonNull
    @Override
    public Fragment createFragment(int i) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
//       args.putString("EXTRA_DATA_NAME", categories.get(i).getStrCategory());
//        args.putString("EXTRA_DATA_DESC", categories.get(i).getStrCategoryDescription());
//        args.putString("EXTRA_DATA_IMAGE", categories.get(i).getStrCategoryThumb());
        fragment.setArguments(args);
        return fragment;
    }

}