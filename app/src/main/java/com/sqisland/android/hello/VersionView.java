package com.sqisland.android.hello;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by navee on 14/04/2017.
 */

public class VersionView extends TextView {
    public VersionView(Context context) {
        super(context);
        setVersion();
    }

    public VersionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setVersion();
    }

    public VersionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setVersion();
    }

    public VersionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setVersion();
    }
    private void setVersion()
    {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        setText(packageInfo.versionName);
    }

}
