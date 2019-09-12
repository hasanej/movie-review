package id.co.hasaneljabir.moviereview.feature.movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.model.movie.MovieItems;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String MOVIE = "movie";
    private String poster, title, rating, releaseDate, synopsis;
    private ImageView ivPoster;
    private TextView tvTitle, tvRating, tvReleaseDate, tvSynopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.header_movie_detail);
        setContentView(R.layout.activity_movie_detail);

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
        MovieItems movieItems = getIntent().getParcelableExtra(MOVIE);
        poster = movieItems.getPosterPath();
        title = movieItems.getTitle();
        rating = movieItems.getVoteAverage();
        releaseDate = movieItems.getReleaseDate();
        synopsis = movieItems.getOverview();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorite, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.favorite) {
            item.setChecked(!item.isChecked());

            if (item.isChecked()) {
                Toast.makeText(this, R.string.added_to_favorite, Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.ic_favorite_24dp);
            } else {
                Toast.makeText(this, R.string.removed_from_favorite, Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.ic_add_to_favorite_24dp);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
