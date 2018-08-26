package com.github.valkoz.sigma;

import android.os.Bundle;

public interface MVPMainPresenter {

    void onCreate(MVPMainView mvpView);
    void onDestroy();

    void noInternetAccess();
    void loadData();
    void restoreData(Bundle viewState, String key);

}
