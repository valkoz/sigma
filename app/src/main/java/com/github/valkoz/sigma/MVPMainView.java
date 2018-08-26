package com.github.valkoz.sigma;

import com.github.valkoz.sigma.model.TransformedItem;

import java.util.List;

public interface MVPMainView {

    void showItems(List<TransformedItem> items);
    void showError(String error);
    void showLoading();
    void hideLoading();
}
