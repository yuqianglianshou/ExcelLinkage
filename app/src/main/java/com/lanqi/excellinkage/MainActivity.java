package com.lanqi.excellinkage;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * 一个长得像Excel表格的
 * lq
 */
public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private ListView mListView;
    private MyAdapter myAdapter;
    private RelativeLayout mFirstLine;
    private MyHorizontalScrollView mMyHorizontalScrollView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mFirstLine = findViewById(R.id.first_line);
        mFirstLine.setBackgroundColor(Color.parseColor("#b2d235"));
        mFirstLine.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());
        mMyHorizontalScrollView = findViewById(R.id.horizontalScrollView);

        mListView = findViewById(R.id.lv_contents);
        mListView.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());

        myAdapter = new MyAdapter(this, mMyHorizontalScrollView);
        mListView.setAdapter(myAdapter);
        myAdapter.setData(getData());

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "他强由他强，" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    class ListViewAndHeadViewTouchLinstener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            //当在列头 和 listView控件上touch时，将这个touch的事件分发给 ScrollView
            mMyHorizontalScrollView.onTouchEvent(arg1);
            return false;
        }
    }

    private List<DataBean> getData() {
        List list = new ArrayList<DataBean>();
        for (int i = 0; i < 120; i++) {
            list.add(new DataBean("name " + i, "A_ " + i, "B_ " + i, "C_ " + i, "D_ " + i, "E_ " + i, "F_ " + i, "G_ " + i));

        }
        return list;
    }

}
