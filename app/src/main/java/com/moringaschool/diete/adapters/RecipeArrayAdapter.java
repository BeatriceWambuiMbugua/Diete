package com.moringaschool.diete.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.moringaschool.diete.models.Result;

import java.util.List;

public class RecipeArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecipes;
    private String[] mFats;

    public RecipeArrayAdapter(Context mContext, int resource, String[] mRecipes, String[] mFats) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecipes = mRecipes;
        this.mFats = mFats;
    }

    @Override
    public Object getItem(int position) {
        String recipe = mRecipes[position];
        String fat = mFats[position];
        return String.format("%s \nCook time is: %s", recipe, fat);
    }

    @Override
    public int getCount() {
        return mRecipes.length;
    }
}
