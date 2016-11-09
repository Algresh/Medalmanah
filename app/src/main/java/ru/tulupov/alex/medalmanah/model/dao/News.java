package ru.tulupov.alex.medalmanah.model.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("id")
    @Expose
    protected int id;

    @SerializedName("title")
    @Expose
    protected String title;

    @SerializedName("anons")
    @Expose
    protected String anons;

    @SerializedName("preview")
    @Expose
    protected String preview;

    @SerializedName("created")
    @Expose
    protected String created;

    @SerializedName("slug")
    @Expose
    protected String slug;

    @SerializedName("category")
    @Expose
    protected String category;

    @SerializedName("type")
    @Expose
    protected int type;

    @SerializedName("like")
    @Expose
    protected int like;

    @SerializedName("dislike")
    @Expose
    protected int dislike;

    @SerializedName("commentCount")
    @Expose
    protected int commentCount;

    @SerializedName("rating")
    @Expose
    protected int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
