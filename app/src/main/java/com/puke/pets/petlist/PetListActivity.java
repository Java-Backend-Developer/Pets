package com.puke.pets.petlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import com.puke.pets.R;
import com.puke.pets.base.BaseActivity;
import com.puke.pets.base.SingleInstance;

/**
 * @author zijiao
 * @version 17/10/7
 */
public class PetListActivity extends BaseActivity {

    private SwipeRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petlist);
        setHeaderTitle("宠物列表页");
        mRefreshLayout = find(R.id.layout_refresh);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                SingleInstance.sHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.setRefreshing(false);
                        T("假装刷新完成");
                    }
                }, 1000);
            }
        });
    }


}
