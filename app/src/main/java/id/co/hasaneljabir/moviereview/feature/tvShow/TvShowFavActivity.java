package id.co.hasaneljabir.moviereview.feature.tvShow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.adapter.TvShowFavAdapter;
import id.co.hasaneljabir.moviereview.entity.db.tvShowFavorite.TvShowFavorite;

import static id.co.hasaneljabir.moviereview.feature.HomeActivity.tvShowFavoriteDb;

public class TvShowFavActivity extends AppCompatActivity {
    private RecyclerView tvTvShowFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        setTitle(R.string.favorite_tv_show);

        tvTvShowFav = findViewById(R.id.rv_fav);
        tvTvShowFav.setLayoutManager(new LinearLayoutManager(this));

        getTvShowFav();
    }

    private void getTvShowFav() {
        List<TvShowFavorite> tvShowFavorite = tvShowFavoriteDb.tvShowFavoriteDao().getFavoriteData();

        TvShowFavAdapter tvShowFavAdapter = new TvShowFavAdapter(tvShowFavorite);
        tvTvShowFav.setAdapter(tvShowFavAdapter);
    }
}
