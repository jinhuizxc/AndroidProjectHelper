package com.jinhui.androidprojecthelper.db;

import com.jinhui.androidprojecthelper.R;
import com.jinhui.androidprojecthelper.base.BaseApplication;
import com.jinhui.androidprojecthelper.bean.SecondChannelTabBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * 描述：
 * Created by qyh on 2017/1/12.
 */
public class SecondChannelManager {

    public static List<SecondChannelTabBean> loadTab(){
        List<String> name = Arrays.asList(BaseApplication.getAppContext().getResources().getStringArray(R.array.second_fragment_name));
        List<String> id = Arrays.asList(BaseApplication.getAppContext().getResources().getStringArray(R.array.second_fragment_id));
        ArrayList<SecondChannelTabBean> list = new ArrayList<>();
        for(int i=0;i<name.size();i++){
            SecondChannelTabBean secondChannelTabBean = new SecondChannelTabBean(name.get(i),id.get(i));
            list.add(secondChannelTabBean);
        }
        return list;
    }
}
