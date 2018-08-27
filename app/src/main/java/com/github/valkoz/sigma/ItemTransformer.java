package com.github.valkoz.sigma;

import com.github.valkoz.sigma.model.TransformedItem;
import com.github.valkoz.sigma.model.rss.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemTransformer {

    public List<TransformedItem> transform(List<Item> items) {

        List<TransformedItem> transformedItems = new ArrayList<>();
        for (Item item : items) {
            String description = item.getDescription().replaceAll("<[^\\P{Graph}>]+(?: [^>]*)?>", "");
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
