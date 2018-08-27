package com.github.valkoz.sigma;

import com.github.valkoz.sigma.model.TransformedItem;
import com.github.valkoz.sigma.model.rss.Category;
import com.github.valkoz.sigma.model.rss.Item;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ItemTransformerTest {

    @Test
    public void transform() {

        List<Category> categories = Arrays.asList(new Category("cat1"), new Category("cat2"));
        Item firstItem = new Item("title", "g", "l", "d", "p", "c", categories);
        Item secondItem = new Item("t", "g", "l", "d", "p", "c", categories);
        List<Item> items = Arrays.asList(firstItem, secondItem);

        ItemTransformer transformer = new ItemTransformer();
        List<TransformedItem> transformedItems = transformer.transform(items);

        assertNotNull(transformedItems);
        assertTrue(!transformedItems.isEmpty());
        assertEquals(transformedItems.size(), 2);

    }
}