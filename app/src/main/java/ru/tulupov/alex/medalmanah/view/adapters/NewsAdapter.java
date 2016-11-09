package ru.tulupov.alex.medalmanah.view.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ru.tulupov.alex.medalmanah.App;
import ru.tulupov.alex.medalmanah.model.dao.News;
import ru.tulupov.alex.medalmanah.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    public static final int TYPE_NEWS = 0;
    public static final int TYPE_ARTICLES = 1;

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
        Resources resources = context.getResources();

        News news = newsList.get(position);

        holder.text.setText(news.getAnons());
        holder.title.setText(news.getTitle());
        holder.date.setText(news.getCreated());
        holder.rating.setText(String.valueOf(news.getRating()));
        holder.comments.setText(String.valueOf(news.getCommentCount()));
        holder.likes.setText(String.valueOf(news.getLike() - news.getDislike()));

        int type = news.getType();
        if (type >= 0 && type < 2) {
            String[] arr = resources.getStringArray(R.array.type_publications);
            holder.type.setText(arr[type]);
        } else {
            holder.type.setText("");
        }


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
