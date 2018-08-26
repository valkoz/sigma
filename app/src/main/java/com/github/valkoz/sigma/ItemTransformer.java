package com.github.valkoz.sigma;

import android.text.Html;

import com.github.valkoz.sigma.model.TransformedItem;
import com.github.valkoz.sigma.model.rss.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemTransformer {

    public List<TransformedItem> transform(List<Item> items) {

        List<TransformedItem> transformedItems = new ArrayList<>();
        for (Item item : items) {

            String description = item.getDescription().replaceAll("(<(/)img>)|(<img.+?>)", "");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                description = Html.fromHtml(description, Html.FROM_HTML_MODE_LEGACY).toString().replaceAll("\n", "").trim();
            } else {
                description = Html.fromHtml(description).toString().replaceAll("\n", "").trim();
            }

            transformedItems.add(
                    new TransformedItem(item.getTitle(),
                            description,
                            item.getPubDate(),
                            item.getCreator(),
                            item.getCategories().toString()));
        }
        return transformedItems;
    }
}
