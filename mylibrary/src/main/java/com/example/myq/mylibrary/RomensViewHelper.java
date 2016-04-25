package com.example.myq.mylibrary;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * View操作类
 */
public class RomensViewHelper {
    public enum OperatorMethod {SET_TEXT, SET_IMAGE, SET_ON_CLICK_LISTENER}

    public static void operateView(View parentView, OperatorMethod operatorMethod, int childId, Object operatorEvent) {
        if (operatorMethod == OperatorMethod.SET_IMAGE) {
            if (operatorEvent instanceof Integer) {
                getImageView(parentView, childId).setImageResource((Integer) operatorEvent);
            } else if (operatorEvent instanceof Bitmap) {
                getImageView(parentView, childId).setImageBitmap((Bitmap) operatorEvent);
            } else if (operatorEvent instanceof Drawable) {
                getImageView(parentView, childId).setImageDrawable((Drawable) operatorEvent);
            }
        } else if (operatorMethod == OperatorMethod.SET_TEXT) {
            if (operatorEvent instanceof Integer) {
                getTextView(parentView, childId).setText((int) operatorEvent);
            } else {
                getTextView(parentView, childId).setText((CharSequence) operatorEvent);
            }
        } else if (operatorMethod == OperatorMethod.SET_ON_CLICK_LISTENER) {
            getChildView(parentView, childId).setOnClickListener((View.OnClickListener) operatorEvent);
        }
    }

    public static ImageView getImageView(View parentView, int childId) {
        return (ImageView) parentView.findViewById(childId);
    }

    public static TextView getTextView(View parentView, int childId) {
        return (TextView) parentView.findViewById(childId);
    }

    public static View getChildView(View parentView, int childId) {
        return parentView.findViewById(childId);
    }
}
