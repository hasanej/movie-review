package id.co.hasaneljabir.moviereview.feature.movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.adapter.MovieFavAdapter;
import id.co.hasaneljabir.moviereview.entity.db.movieFavorite.MovieFavorite;

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
}
