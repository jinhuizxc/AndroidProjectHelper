package com.jinhui.androidprojecthelper.adapter;



import android.widget.ImageView;

import com.jinhui.androidprojecthelper.R;
import com.jinhui.androidprojecthelper.base.baseadapter.BaseQuickAdapter;
import com.jinhui.androidprojecthelper.base.baseadapter.BaseViewHolder;
import com.jinhui.androidprojecthelper.bean.FirstBean;
import com.jinhui.androidprojecthelper.utils.ImageLoaderUtils;

import java.util.List;


/**
 * 描述：
 * Created by qyh on 2016/12/30.
 */
public class FirstTabAdapter extends BaseQuickAdapter {
    
    public FirstTabAdapter(int layoutResId, List<FirstBean> listData) {
        super(layoutResId, listData);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item, int position) {
        FirstBean data=(FirstBean)item;
        ImageLoaderUtils.display(mContext,(ImageView) helper.getView(R.id.iv_item_picture)
                ,data.getUrl());
    }
}
