package com.dou361.ijkplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dou361.ijkplayer.bean.VideoijkBean;
import com.dou361.ijkplayer.utils.ResourceUtils;

import java.util.List;

public class StreamSelectAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<VideoijkBean> listVideos;

    public StreamSelectAdapter(Context context, List<VideoijkBean> list) {
        this.mContext = context;
        this.listVideos = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return listVideos.size();
    }

    public Object getItem(int position) {
        return listVideos.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = this.layoutInflater.inflate(ResourceUtils.getResourceIdByName(mContext, "layout", "simple_player_list_item"), (ViewGroup) null);
            holder = new ViewHolder();
            holder.streamName = (TextView) convertView.findViewById(ResourceUtils.getResourceIdByName(mContext, "id", "simple_player_stream_name"));
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        VideoijkBean mVideoijkBean = listVideos.get(position);
        String streamName = mVideoijkBean.getStream();
        holder.streamName.setText(streamName);
        if (mVideoijkBean.isSelect()) {
            holder.streamName.setTextColor(mContext.getResources().getColor(ResourceUtils.getResourceIdByName(mContext, "color", "simple_player_stream_name_playing")));
        } else {
            holder.streamName.setTextColor(mContext.getResources().getColor(ResourceUtils.getResourceIdByName(mContext, "color", "simple_player_stream_name_normal")));
        }
        return convertView;
    }

    class ViewHolder {
        public TextView streamName;

        ViewHolder() {
        }
    }
}