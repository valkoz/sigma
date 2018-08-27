package com.github.valkoz.sigma.model.rss;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.List;

@Root(name = "channel", strict = false)
public class Channel {

    @Path("title") @Text(required=false)private String title;
    @Path("link") @Text(required=false) private String link;
    @Element(name = "description", required = false)
    private String description;
    @Element(name = "language", required = false)
    private String language;
    @Element(name = "managingEditor", required = false)
    private String managingEditor;
    @Element(name = "generator", required = false)
    private String generator;
    @Element(name = "pubDate", required = false)
    private String pubDate;
    @Element(name = "image", required = false)
    private String image;
    @ElementList(name = "item", inline = true) private List<Item> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getManagingEditor() {
        return managingEditor;
    }

    public void setManagingEditor(String managingEditor) {
        this.managingEditor = managingEditor;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", managingEditor='" + managingEditor + '\'' +
                ", generator='" + generator + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", image='" + image + '\'' +
                ", items=" + items +
                '}';
    }
}
