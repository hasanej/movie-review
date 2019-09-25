package id.co.hasaneljabir.moviereview.feature.tvShow;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.entity.db.tvShowFavorite.TvShowFavorite;
import id.co.hasaneljabir.moviereview.helper.Constant;
import id.co.hasaneljabir.moviereview.model.tvShow.TvShowItems;

import static id.co.hasaneljabir.moviereview.feature.HomeActivity.tvShowFavoriteDb;

public class TvShowDetailActivity extends AppCompatActivity {
    public static final String TV_SHOW = "tv_show";
    private int id;
    private String poster, title, rating, releaseDate, synopsis;
    private ImageView ivPoster;
    private TextView tvTitle, tvRating, tvReleaseDate, tvSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.header_tv_show_detail);
        setContentView(R.layout.activity_tv_show_detail);

        bindView();
        getData();
        setData();
    }

    private void bindView() {
        ivPoster = findViewById(R.id.iv_poster);
        tvTitle = findViewById(R.id.tv_title);
        tvRating = findViewById(R.id.tv_rating);
        tvReleaseDate = findViewById(R.id.tv_release_date);
        tvSynopsis = findViewById(R.id.tv_synopsis);
    }

    private void getData() {
        TvShowItems tvShow = getIntent().getParcelableExtra(TV_SHOW);
        id = tvShow.getId();
        poster = tvShow.getPosterPath();
        title = tvShow.getTitle();
        rating = tvShow.getVoteAverage();
        releaseDate = tvShow.getReleaseDate();
        synopsis = tvShow.getOverview();
    }

    private void setData() {
        Glide.with(this)
                .load(Constant.POSTER_BASE_URL_342 + poster)
                .into(ivPoster);
        tvTitle.setText(title);
        tvRating.setText(rating);
        tvReleaseDate.setText(releaseDate);
        tvSynopsis.setText(synopsis);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorite, menu);

        if (tvShowFavoriteDb.tvShowFavoriteDao().isFavorite(id) == 1) {
            menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorite_24dp));
            menu.getItem(0).setChecked(true);
        } else {
            menu.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorite_24dp));
            menu.getItem(0).setChecked(false);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TvShowFavorite tvShowFav = new TvShowFavorite();

        tvShowFav.setId(id);
        tvShowFav.setPosterPath(poster);
        tvShowFav.setTitle(title);
        tvShowFav.setVoteAverage(rating);
        tvShowFav.setReleaseDate(releaseDate);
        tvShowFav.setOverview(synopsis);

        if (item.getItemId() == R.id.favorite) {
            if (item.isChecked()) {
                item.setChecked(false);
                tvShowFavoriteDb.tvShowFavoriteDao().delete(tvShowFav);
                item.setIcon(R.drawable.ic_add_to_favorite_24dp);
                Toast.makeText(this, R.string.removed_from_favorite, Toast.LENGTH_SHORT).show();
            } else {
                item.setChecked(true);
                tvShowFavoriteDb.tvShowFavoriteDao().addData(tvShowFav);
                item.setIcon(R.drawable.ic_favorite_24dp);
                Toast.makeText(this, R.string.added_to_favorite, Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
