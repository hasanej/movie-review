package id.co.hasaneljabir.favoritemovie;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import static id.co.hasaneljabir.favoritemovie.DatabaseContract.FavoriteMovieColumns.CONTENT_URI;
import static id.co.hasaneljabir.favoritemovie.MappingHelper.mapCursorToArrayList;

public class FavoriteMovieActivity extends AppCompatActivity implements LoadFavoriteMovieCallback {

    private ConsumerAdapter consumerAdapter;
    private DataObserver myObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_movie);

        getSupportActionBar().setTitle("Consumer Favorite Movie App");
        RecyclerView rvFavoriteMovie = findViewById(R.id.rv_favorite_movie);
        consumerAdapter = new ConsumerAdapter(this);
        rvFavoriteMovie.setLayoutManager(new LinearLayoutManager(this));
        rvFavoriteMovie.setHasFixedSize(true);
        rvFavoriteMovie.setAdapter(consumerAdapter);
        HandlerThread handlerThread = new HandlerThread("DataObserver");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        myObserver = new DataObserver(handler, this);
        getContentResolver().registerContentObserver(CONTENT_URI, true, myObserver);
        new getData(this, this).execute();
    }

    @Override
    public void postExecute(Cursor favoriteMovie) {

        ArrayList<FavoriteMovieItem> listFavoriteMovie = mapCursorToArrayList(favoriteMovie);
        if (listFavoriteMovie.size() > 0) {
            consumerAdapter.setListFavoriteMovie(listFavoriteMovie);
        } else {
            Toast.makeText(this, "Tidak Ada data saat ini", Toast.LENGTH_SHORT).show();
            consumerAdapter.setListFavoriteMovie(new ArrayList<FavoriteMovieItem>());
        }
    }

    private static class getData extends AsyncTask<Void, Void, Cursor> {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadFavoriteMovieCallback> weakCallback;


        private getData(Context context, LoadFavoriteMovieCallback callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }

        @Override
        protected Cursor doInBackground(Void... voids) {
            return weakContext.get().getContentResolver().query(CONTENT_URI, null, null, null, null);
        }

        @Override
        protected void onPostExecute(Cursor data) {
            super.onPostExecute(data);
            weakCallback.get().postExecute(data);
        }

    }

    static class DataObserver extends ContentObserver {

        final Context context;

        DataObserver(Handler handler, Context context) {
            super(handler);
            this.context = context;
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            new getData(context, (FavoriteMovieActivity) context).execute();
        }
    }
}
