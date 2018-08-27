package com.github.valkoz.sigma;

import com.github.valkoz.sigma.model.TransformedItem;
import com.github.valkoz.sigma.model.rss.RSS;

import org.simpleframework.xml.core.Persister;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public class RssParser {

    public List<TransformedItem> parse(String responseBody) throws Exception {
        Reader xmlReader = new StringReader(responseBody);
        Persister serializer = new Persister();
        RSS rss = serializer.read(RSS.class, xmlReader, false);
        ItemTransformer transformer = new ItemTransformer();
        return transformer.transform(rss.getChannel().getItems());
    }

}
