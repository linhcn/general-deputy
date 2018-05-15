package com.linhcn.generaldeputy.adapter;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.linhcn.generaldeputy.R;
import com.linhcn.generaldeputy.data.CONST;

/**
 * Created by linhcn on 9/20/16.
 */
public class GridViewAdapter extends BaseAdapter{
    private Context context;
    private Integer[] thumbIds;
    private int width,height;
    public GridViewAdapter(Context context,Integer[] thumbIds,int width,int height){
        this.width = width;
        this.height = height;
        this.context = context;
        this.thumbIds = thumbIds;
    }

    @Override
    public int getCount() {
        return thumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return thumbIds[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT,  (height*88)/800));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding((width*10/480), (width*10/800), (width*10/480),(width*10/800));
            if (thumbIds[position].equals(R.drawable.icon_pho)||thumbIds[position].equals(R.drawable.icon_pho2)){
                imageView.setPadding((width*17/480), (width*17/800), (width*17/480),(width*17/800));
            }
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(thumbIds[position]);
        return imageView;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }
}
