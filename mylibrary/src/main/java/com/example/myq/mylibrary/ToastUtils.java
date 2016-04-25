package com.example.myq.mylibrary;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by myq on 16-1-4.
 */
public class ToastUtils {
    private static Toast toast;

    public static void toastMsg(Context context, String msg) {
        Toast toast = getToast(context);
        toast.setText(msg);
        toast.show();
    }

    private static Toast getToast(Context context) {
        if (toast == null) {
            synchronized (ToastUtils.class) {
                if (toast == null) {
                    toast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
                }
            }
        }
        return toast;
    }
}
