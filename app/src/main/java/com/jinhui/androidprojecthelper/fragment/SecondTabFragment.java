package com.jinhui.androidprojecthelper.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import com.jinhui.androidprojecthelper.R;
import com.jinhui.androidprojecthelper.base.BaseFragment;
import com.jinhui.androidprojecthelper.base.BaseFragmentAdapter;
import com.jinhui.androidprojecthelper.bean.SecondChannelTabBean;
import com.jinhui.androidprojecthelper.db.SecondChannelManager;
import com.jinhui.androidprojecthelper.view.CustomViewPager;

/**
 * 描述：Viewpager切换示例，详细功能不写了
 * Created by qyh on 2016/12/10.
 */
public class SecondTabFragment extends BaseFragment {

    @BindView(R.id.tabs)
    public TabLayout tabs;
    @BindView(R.id.view_pager)
    public CustomViewPager viewPager;
    private BaseFragmentAdapter baseFragmentAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_second;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        ArrayList<String> tabName = new ArrayList<>();
        ArrayList<Fragment> fragments = new ArrayList<>();
        List<SecondChannelTabBean> tabDatas = SecondChannelManager.loadTab();
        for (int i = 0; i < tabDatas.size(); i++) {
            tabName.add(tabDatas.get(i).getName());
            fragments.add(createListFragments(tabDatas.get(i)));
        }

        baseFragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), fragments, tabName);
        viewPager.setAdapter(baseFragmentAdapter);
        tabs.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
    }

    private SecondListFragment createListFragments(SecondChannelTabBean data) {
        SecondListFragment fragment = new SecondListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", data.getId());
        fragment.setArguments(bundle);
        return fragment;
    }
}
