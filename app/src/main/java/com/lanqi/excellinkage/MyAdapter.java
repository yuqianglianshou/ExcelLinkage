package com.lanqi.excellinkage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * author: lq
 * time  : 2018/8/16
 * desc  :
 */

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private MyHorizontalScrollView headSrcrollView;//所有 item 中的HorizontalScrollView滚动与此一致,实现同步滚动
    private List<DataBean> mList = new ArrayList<>();

    public MyAdapter(Context mContext, MyHorizontalScrollView headSrcrollView) {
        this.mContext = mContext;
        this.headSrcrollView = headSrcrollView;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.lv_item, null);
            synchronized (mContext) {
                holder = new ViewHolder();

                holder.scrollView = convertView
                        .findViewById(R.id.horizontalScrollView);
                holder.name = convertView
                        .findViewById(R.id.tv_name);
                holder.tv1 = convertView
                        .findViewById(R.id.tv_a);
                holder.tv2 = convertView
                        .findViewById(R.id.tv_b);
                holder.tv3 = convertView
                        .findViewById(R.id.tv_c);
                holder.tv4 = convertView
                        .findViewById(R.id.tv_d);
                holder.tv5 = convertView
                        .findViewById(R.id.tv_e);
                holder.tv6 = convertView
                        .findViewById(R.id.tv_f);
                headSrcrollView.AddOnScrollChangedListener(new OnScrollChangedListenerImp(
                        holder.scrollView));

                convertView.setTag(holder);
            }
        }
        DataBean bean = mList.get(position);

        holder.name.setText(bean.getName());
        holder.tv1.setText(bean.getData1());
        holder.tv2.setText(bean.getData2());
        holder.tv3.setText(bean.getData3());
        holder.tv4.setText(bean.getData4());
        holder.tv5.setText(bean.getData5());
        holder.tv6.setText(bean.getData6());

        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv5;
        TextView tv6;
        MyHorizontalScrollView scrollView;
    }

    class OnScrollChangedListenerImp implements MyHorizontalScrollView.OnScrollChangedListener {
        MyHorizontalScrollView mScrollViewArg;

        public OnScrollChangedListenerImp(MyHorizontalScrollView scrollViewar) {
            mScrollViewArg = scrollViewar;
        }

        @Override
        public void onScrollChanged(int l, int t, int oldl, int oldt) {
            mScrollViewArg.smoothScrollTo(l, t);
        }
    }

    public void setData(List<DataBean> list) {
        mList.clear();
        mList = list;
        notifyDataSetChanged();
    }
}
