package com.example.clarinet.scannertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sabi on 2018-03-07.
 */

public class ItemofBilllistAdapter extends BaseAdapter {

    ArrayList<ItemofBilllist> list;
    Context context;
    int layout;
    LayoutInflater inf;

    public ItemofBilllistAdapter(Context context, int layout, ArrayList<ItemofBilllist> item) {
        this.context = context;
        this.layout = layout;
        this.list = item;
        inf = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return list.size() ;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return list.get(position) ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.bill_item_list, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView name = (TextView) convertView.findViewById(R.id.name) ;
        TextView price = (TextView) convertView.findViewById(R.id.price) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득

       ItemofBilllist list1 = list.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        name.setText(list1.Name);
        price.setText(list1.Price);

        return convertView;
    }
}
