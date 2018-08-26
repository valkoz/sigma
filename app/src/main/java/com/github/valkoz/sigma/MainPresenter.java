package com.github.valkoz.sigma;

import android.os.AsyncTask;
import android.os.Bundle;

import com.github.valkoz.sigma.model.TransformedItem;

import java.util.List;

public class MainPresenter implements MVPMainPresenter {

    private static final String ERROR_MESSAGE = "No Internet access";
    private MVPMainView view;
    private LoadTask task;

    @Override
    public void onCreate(MVPMainView mvpView) {
        view = mvpView;
    }

    @Override
    public void loadData() {
        view.showLoading();
        if (task == null || task.getStatus() != AsyncTask.Status.RUNNING) {
            task = new LoadTask(view);
            task.execute();
        }
    }

    @Override
    public void restoreData(Bundle state, String key) {
        view.showItems(state.getParcelableArrayList(key));
    }

    @Override
    public void onDestroy() {
        view = null;
        if (task != null && task.getStatus() == AsyncTask.Status.RUNNING) {
            task.cancel(true);
        }
    }

    @Override
    public void noInternetAccess() {
        view.hideLoading();
        view.showError(ERROR_MESSAGE);
    }

    public static class LoadTask extends AsyncTask<String, Void, List<TransformedItem>> {

        private MVPMainView view;
        private DataProvider dataProvider;

        public LoadTask(MVPMainView mainView) {
            view = mainView;
            dataProvider = new DataProvider();
        }

        @Override
        protected List<TransformedItem> doInBackground(String... uri) {
            return dataProvider.getData();
        }

        @Override
        protected void onPostExecute(List<TransformedItem> result) {
            super.onPostExecute(result);
            if (view != null && result != null) {
                view.hideLoading();
                view.showItems(result);
            }

        }
    }
}
