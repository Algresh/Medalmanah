package ru.tulupov.alex.medalmanah;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> newsList;
    private Context context;

    public NewsAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News news = newsList.get(position);

        holder.text.setText(news.getAnons());
        holder.title.setText(news.getTitle());
        holder.date.setText(news.getCreated());
        holder.rating.setText(String.valueOf(news.getRating()));
        holder.comments.setText(String.valueOf(news.getCommentCount()));
        holder.likes.setText(" " + String.valueOf(news.getLike() - news.getDislike()));
        holder.type.setText("Новости");

//        holder.likes.d
        holder.buttonLike.setImageResource(R.drawable.thumb_up_outline);
        holder.buttonDislike.setImageResource(R.drawable.thumb_down_outline);

        Glide.with(context).load(App.DOMAIN + news.getPreview()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends  RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView date;
        TextView type;
        TextView text;
        TextView likes;
        TextView rating;
        TextView comments;
        ImageView buttonLike;
        ImageView buttonDislike;

        public NewsViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageItemNews);
            title = (TextView) itemView.findViewById(R.id.itemNewsTitle);
            text = (TextView) itemView.findViewById(R.id.itemNewsText);
            date = (TextView) itemView.findViewById(R.id.itemNewsDate);
            type = (TextView) itemView.findViewById(R.id.itemNewsType);
            likes = (TextView) itemView.findViewById(R.id.differLikesDislikes);
            rating = (TextView) itemView.findViewById(R.id.newsScore);
            comments = (TextView) itemView.findViewById(R.id.newsComments);

            buttonLike = (ImageView) itemView.findViewById(R.id.btnLikeNews);
            buttonDislike = (ImageView) itemView.findViewById(R.id.btnDislikeNews);
        }
    }

}
