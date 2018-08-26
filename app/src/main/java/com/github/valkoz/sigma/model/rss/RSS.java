package com.github.valkoz.sigma.model.rss;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss")
public class RSS {

    @Element(name="channel") private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "RSS{" +
                "channel=" + channel +
                '}';
    }
}
