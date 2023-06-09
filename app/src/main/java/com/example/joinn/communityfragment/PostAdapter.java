package com.example.joinn.communityfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joinn.R;

import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {

    private Context context;
    private int resource;
    private List<Post> postList;

    public PostAdapter(Context context, int resource, List<Post> postList) {
        super(context, resource, postList);
        this.context = context;
        this.resource = resource;
        this.postList = postList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        Post post = postList.get(position);

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView contentTextView = convertView.findViewById(R.id.contentTextView);
        TextView writerTextView = convertView.findViewById(R.id.writerTextView);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        titleTextView.setText(post.getTitle());
        contentTextView.setText(post.getContent());
        writerTextView.setText(post.getWriter());

        // 이미지를 Glide를 사용하여 로드하고 ImageView에 표시
        Glide.with(context).load(post.getImageUrl()).into(imageView);

        return convertView;
    }
}
