package com.example.bestl.kitdee.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ChillSweet on 2/23/2016.
 */
public class TextViewCustom extends TextView {

    Context context;

    public TextViewCustom(Context context, AttributeSet attrs,
                          int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        setTypeface(attrs);
    }

    public TextViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setTypeface(attrs);
    }

    public TextViewCustom(Context context) {
        super(context);
        this.context = context;
        setTypefaceDefault();
    }

    private void setTypefaceDefault() {
        String fontPath = "fonts/RSU_Regular.ttf";
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), fontPath));
    }

    private void setTypeface(AttributeSet attrs) {
        if (isInEditMode() && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        int attrTextStyle = Typeface.NORMAL;
        if (attrs != null) {
            int[] attributes = new int[]{android.R.attr.textStyle};
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, attributes);
            attrTextStyle = typedArray.getInt(0, 0);
            typedArray.recycle();
        }

        String fontPath = "fonts/RSU_Regular.ttf";
        Typeface typeface = getTypeface();
        if (typeface != null) {
            if ((typeface.getStyle() & Typeface.BOLD_ITALIC) == Typeface.BOLD_ITALIC ||
                    (attrTextStyle & Typeface.BOLD_ITALIC) == Typeface.BOLD_ITALIC) {
                fontPath = "fonts/RSU_BOLD.ttf";
            }
//            else if ((typeface.getStyle() & Typeface.ITALIC) == Typeface.ITALIC ||
//                    (attrTextStyle & Typeface.ITALIC) == Typeface.ITALIC) {
//                fontPath = "fonts/Kanit-Italic.ttf";
//            }
            else if ((typeface.getStyle() & Typeface.BOLD) == Typeface.BOLD ||
                    (attrTextStyle & Typeface.BOLD) == Typeface.BOLD) {
                fontPath = "fonts/RSU_BOLD.ttf";
            }
        }
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), fontPath));
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
//            setLineSpacing(getPixelFromDp(getContext(), -5), 1);
//        }
//        setIncludeFontPadding(false);
    }

//    public float getPixelFromDp(Context context, float dp) {
//        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
//        return dp * (metrics.densityDpi / 160f);
//    }


    @Override
    public void setIncludeFontPadding(boolean includepad) {
        super.setIncludeFontPadding(includepad);
    }
}
