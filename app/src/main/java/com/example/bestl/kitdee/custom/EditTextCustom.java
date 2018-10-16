package com.example.bestl.kitdee.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by ChillSweet on 2/23/2016.
 */
public class EditTextCustom extends EditText {

    Context context;

    public EditTextCustom(Context context, AttributeSet attrs,
                          int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        this.setTypeface(Typeface.createFromAsset(
                getContext().getAssets(), "fonts/RSU_Regular.ttf"));
    }

    public EditTextCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.setTypeface(Typeface.createFromAsset(
                getContext().getAssets(), "fonts/RSU_Regular.ttf"));
    }

    public EditTextCustom(Context context) {
        super(context);
        this.context = context;
        this.setTypeface(Typeface.createFromAsset(
                getContext().getAssets(), "fonts/RSU_Regular.ttf"));
    }

    @Override
    public void setIncludeFontPadding(boolean includepad) {
        super.setIncludeFontPadding(includepad);
    }
}
