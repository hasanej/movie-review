package id.co.hasaneljabir.moviereview.feature.movie;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.List;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.adapter.MovieFavAdapter;
import id.co.hasaneljabir.moviereview.entity.contentProvider.LoadFavoriteMovieCallback;
import id.co.hasaneljabir.moviereview.entity.db.movieFavorite.MovieFavorite;

import static id.co.hasaneljabir.moviereview.entity.contentProvider.DatabaseContract.FavoriteMovieColumns.CONTENT_URI;
import static id.co.hasaneljabir.moviereview.feature.HomeActivity.movieFavoriteDb;

public class MovieFavActivity extends AppCompatActivity {

    private RecyclerView rvMovieFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        setTitle(R.string.favorite_movie);

        rvMovieFav = findViewById(R.id.rv_fav);
        rvMovieFav.setLayoutManager(new LinearLayoutManager(this));

        getMovieFav();
    }

    private void getMovieFav() {
        List<MovieFavorite> movieFavorite = movieFavoriteDb.movieFavoriteDao().getFavoriteData();
        MovieFavAdapter movieFavAdapter = new MovieFavAdapter(movieFavorite);
        rvMovieFav.setAdapter(movieFavAdapter);
    }

    public static class DataObserver extends ContentObserver {
        final Context context;

        public DataObserver(Handler handler, Context context) {
            super(handler);
            this.context = context;
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            new LoadFavoriteMovieAsync(context, (LoadFavoriteMovieCallback) context).execute();
        }
    }

    private static class LoadFavoriteMovieAsync extends AsyncTask<Void, Void, Cursor> {

        private final WeakReference<Context> weakContext;

        private LoadFavoriteMovieAsync(Context context, LoadFavoriteMovieCallback callback) {
            weakContext = new WeakReference<>(context);
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Cursor doInBackground(Void... voids) {
            Context context = weakContext.get();
            return context.getContentResolver().query(CONTENT_URI, null, null, null, null);
        }

        @Override
        protected void onPostExecute(Cursor favoriteMovies) {
        }
    }
}
