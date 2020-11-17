package com.moringaschool.diete.ui;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RecipeArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecipes;
    private String[] mCookTime;

    public RecipeArrayAdapter(Context mContext, int resource, String[] mRecipes, String[] mCookTime) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecipes = mRecipes;
        this.mCookTime = mCookTime;
    }

    @Override
    public Object getItem(int position) {
        String recipe = mRecipes[position];
        String cookTime = mCookTime[position];
        return String.format("%s \nCook time is: %s", recipe, cookTime);
    }

    @Override
    public int getCount() {
        return mRecipes.length;
    }
}
