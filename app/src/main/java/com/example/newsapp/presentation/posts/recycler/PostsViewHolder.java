package com.example.newsapp.presentation.posts.recycler;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.models.Post;

public class PostsViewHolder extends RecyclerView.ViewHolder  {

    private TextView textTitle;
    private ImageView image;

    public PostsViewHolder(@NonNull View itemView, final PostClickListener postClickListener) {
        super(itemView);
        textTitle = itemView.findViewById(R.id.tex_title);
        image=itemView.findViewById(R.id.image);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postClickListener.onPostClick(getAdapterPosition());
            }
        });
    }

    public void onBindViewHolder(Post post){
        textTitle.setText(post.getTitle());
        Glide.with(itemView).load(post.getImageUrl()).into(image);
    }

    public interface PostClickListener {

        void onPostClick(int position);

    }
}
