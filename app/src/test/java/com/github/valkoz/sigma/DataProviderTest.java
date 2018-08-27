package com.github.valkoz.sigma;

import com.github.valkoz.sigma.model.TransformedItem;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DataProviderTest {

    @Test
    public void getData() {
        DataProvider dataProvider = new DataProvider();
        List<TransformedItem> data = dataProvider.getData();
        assertNotNull("API error", data);
        assertTrue("API error", !data.isEmpty());
    }

}