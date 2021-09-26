package com.example.learnforeignlanguage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.learnforeignlanguage.R;
import com.example.learnforeignlanguage.mode.Topic;

import java.util.List;

public class AdapterTheme extends BaseAdapter {
    List<Topic> list;
    Context context;

    public AdapterTheme(List<Topic> list, Context context) {
        this.list = list;
        this.context = context;
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
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listview_theme,viewGroup,false);
        TextView tv_theme = view.findViewById(R.id.tv_layout_listview_theme);

        tv_theme.setText(list.get(i).getTopic());
        return view;
    }
}
