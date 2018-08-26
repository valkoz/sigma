package com.github.valkoz.sigma.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TransformedItem implements Parcelable {

    private String title;
    private String description;
    private String pubDate;
    private String creator;
    private String categories;


    public TransformedItem(String title, String description, String pubDate, String creator, String categories) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.creator = creator;
        this.categories = categories;
    }

    private TransformedItem(Parcel in) {
        title = in.readString();
        description = in.readString();
        pubDate = in.readString();
        creator = in.readString();
        categories = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(title);
        out.writeString(description);
        out.writeString(pubDate);
        out.writeString(creator);
        out.writeString(categories);
    }

    public static final Parcelable.Creator<TransformedItem> CREATOR = new Parcelable.Creator<TransformedItem>() {
        public TransformedItem createFromParcel(Parcel in) {
            return new TransformedItem(in);
        }

        public TransformedItem[] newArray(int size) {
            return new TransformedItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
