package com.github.valkoz.sigma;

import com.github.valkoz.sigma.model.TransformedItem;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RssParserTest {

    private String parseOk =
            "<rss xmlns:dc=\"http://purl.org/dc/elements/1.1/\" version=\"2.0\">" +
                    "<channel>" +
                    "<item>" +
                    "<title><![CDATA[Книга о «Параграфе» на Хабре.]]></title>" +
                    "<description><![CDATA[Поучительная история]]></description>" +
                    "<pubDate>Mon, 27 Aug 2018 06:11:00 GMT</pubDate>" +
                    "<dc:creator>kotinmax</dc:creator>" +
                    "<category><![CDATA[ Управление проектами ]]></category>" +
                    "</item>" +
                    "</channel>" +
                    "</rss>";

    private String parseFail =
            "<rss xmlns:dc=\"http://purl.org/dc/elements/1.1/\" version=\"2.0\">" +
                    "<channel>" +
                    "<item>" +
                    "<title><![CDATA[Книга о «Параграфе» на Хабре.]]></title>" +
                    "<description><![CDATA[Поучительная история]]></description>" +
                    "<dc:creator>kotinmax</dc:creator>" +
                    "<category><![CDATA[ Управление проектами ]]></category>" +
                    "</item>" +
                    "</channel>" +
                    "</rss>";

    @Test
    public void parseOk() throws Exception {
        RssParser parser = new RssParser();
        List<TransformedItem> items = parser.parse(parseOk);
        assertNotNull(items);
        assertTrue(!items.isEmpty());
        assertEquals(items.size(), 1);
    }

    @Test(expected = Exception.class)
    public void parseFail() throws Exception {
        RssParser parser = new RssParser();
        List<TransformedItem> items = parser.parse(parseFail);
    }

}