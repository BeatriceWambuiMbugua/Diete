package com.moringaschool.diete.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

//import com.moringaschool.diete.models.Result;


public class RecipeArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecipes;

    public RecipeArrayAdapter(Context mContext, int resource, String[] mRecipes) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecipes = mRecipes;
    }

    @Override
    public Object getItem(int position) {
        String recipe = mRecipes[position];
        return String.format("%s \nCook time is: %s", recipe);
    }

    @Override
    public int getCount() {
        return mRecipes.length;
    }
}
