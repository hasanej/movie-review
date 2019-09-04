package id.co.hasaneljabir.moviereview.feature.tvShow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.model.tvShow.TvShowItems;

public class TvShowDetailActivity extends AppCompatActivity {
    public static final String TV_SHOW = "tv_show";
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
        poster = tvShow.getPosterPath();
        title = tvShow.getTitle();
        rating = tvShow.getVoteAverage();
        releaseDate = tvShow.getReleaseDate();
        synopsis = tvShow.getOverview();
    }

    private void setData() {
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w342" + poster)
                .into(ivPoster);
        tvTitle.setText(title);
        tvRating.setText(rating);
        tvReleaseDate.setText(releaseDate);
        tvSynopsis.setText(synopsis);
    }
}
