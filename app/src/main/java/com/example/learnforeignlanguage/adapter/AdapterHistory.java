package com.example.learnforeignlanguage.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.learnforeignlanguage.R;
import com.example.learnforeignlanguage.dao.TopicDao;
import com.example.learnforeignlanguage.mode.History;
import com.example.learnforeignlanguage.mode.Topic;

import java.util.ArrayList;
import java.util.List;

public class AdapterHistory extends BaseAdapter {
    List<History> list ;
    Context context;
    TopicDao themeDao;
    String theme = "";

    public AdapterHistory(List<History> list, Context context) {
        this.list = list;
        this.context = context;
        themeDao = new TopicDao((Activity) context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_history,viewGroup,false);
        TextView tv_theme = view.findViewById(R.id.tv_gridView_historyTheme);
        TextView tv_time = view.findViewById(R.id.tv_gridView_historyDate);

        tv_theme.setText(themeDao.timKiem(list.get(i).getIdTopic()).get(0).getTopic());
        tv_time.setText(list.get(i).getTime());
        return view;
    }
}
