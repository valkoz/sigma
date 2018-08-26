package com.github.valkoz.sigma.model.rss;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.List;

@Root(name = "item", strict = false)
public class Item {

    @Path("title") @Text(required=false) private String title;
    @Element(name = "guid", required = false) private String guid;
    @Path("link") @Text(required=false) private String link;
    @Element(name = "description", required = false) private String description;
    @Element(name = "pubDate", required = false) private String pubDate;
    @Namespace(prefix = "dc") @Element(name = "creator", required = false) private String creator;
    @ElementList(name="category", inline=true) private List<Category> categories;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", guid='" + guid + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", creator='" + creator + '\'' +
                ", categories=" + categories +
                '}';
    }

}
