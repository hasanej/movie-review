package id.co.hasaneljabir.moviereview.model.tvShow;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import id.co.hasaneljabir.moviereview.BuildConfig;
import id.co.hasaneljabir.moviereview.R;

public class TvShowViewModel extends ViewModel {
    private static final String API_KEY = BuildConfig.TMDB_API_KEY;
    private MutableLiveData<ArrayList<TvShowItems>> listTvShow = new MutableLiveData<>();

    public void setTvShow(final Context context) {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<TvShowItems> listItems = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/discover/tv?api_key=" + API_KEY + "&language=en-US";

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("results");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject tvShow = list.getJSONObject(i);
                        TvShowItems tvShowItems = new TvShowItems(tvShow);
                        listItems.add(tvShowItems);
                    }

                    listTvShow.postValue(listItems);
                } catch (Exception e) {
                    Log.d("tvShowErr", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(context, context.getString(R.string.connection_error), Toast.LENGTH_LONG).show();
                Log.d("tvShowNoConn", error.getMessage());
            }
        });
    }

    public void searchTvShow(final Context context, String query) {
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<TvShowItems> listItems = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/search/tv?api_key=" + API_KEY + "&language=en-US&query=" + query;

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);
                    JSONArray list = responseObject.getJSONArray("results");

                    for (int i = 0; i < list.length(); i++) {
                        JSONObject tvShow = list.getJSONObject(i);
                        TvShowItems tvShowItems = new TvShowItems(tvShow);
                        listItems.add(tvShowItems);
                    }

                    listTvShow.postValue(listItems);
                } catch (Exception e) {
                    Log.d("searchTvShowErr", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(context, context.getString(R.string.connection_error), Toast.LENGTH_LONG).show();
                Log.d("searchTvShowNoConn", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<TvShowItems>> getTvShows() {
        return listTvShow;
    }
}
