package com.puke.pets.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.puke.pets.R;

/**
 * @author zijiao
 * @version 17/10/6
 */
public class BaseActivity extends Activity {

    protected TextView mTitle;
    protected ImageView mLeft;
    protected ImageView mRight;
    protected FrameLayout mContentLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (addHeaderLayout()) {
            super.setContentView(R.layout.layout_base);
            mTitle = find(R.id.header_title);
            mLeft = find(R.id.header_left);
            mRight = find(R.id.header_right);
            mContentLayout = find(R.id.layout_content);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (addHeaderLayout()) {
            LayoutInflater.from(this).inflate(layoutResID, mContentLayout);
        } else {
            super.setContentView(layoutResID);
        }
    }

    protected void setLeftImage(@DrawableRes int drawableRes) {
        if (mLeft != null) {
            mLeft.setImageResource(drawableRes);
        }
    }

    protected void semRightImage(@DrawableRes int drawableRes) {
        if (mRight != null) {
            mRight.setImageResource(drawableRes);
        }
    }

    protected void setHeaderTitle(@StringRes int stringRes) {
        if (mTitle != null) {
            mTitle.setText(stringRes);
        }
    }

    protected void setHeaderTitle(String title) {
        if (mTitle != null) {
            mTitle.setText(title);
        }
    }

    public void onLeftClick(View view) {
        finish();
    }

    public void onRightClick(View view) {
        T("Overwrite onRightClick method, please.");
    }

    protected boolean addHeaderLayout() {
        return true;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T find(@IdRes int id) {
        return (T) findViewById(id);
    }

    public static String getStr(TextView textView) {
        return textView == null ? null : textView.getText().toString().trim();
    }

    public void T(Object obj) {
        Toast.makeText(this, String.valueOf(obj), Toast.LENGTH_SHORT).show();
    }

}
