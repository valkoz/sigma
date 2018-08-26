package com.github.valkoz.sigma.model.rss;

import org.simpleframework.xml.Text;

class Category {

    @Text private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
