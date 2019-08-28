package id.co.hasaneljabir.moviereview.feature.movieList;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.adapter.MovieAdapter;
import id.co.hasaneljabir.moviereview.feature.movieDetail.MovieDetailActivity;
import id.co.hasaneljabir.moviereview.model.Movie;

public class MovieListActivity extends AppCompatActivity {
    private TypedArray poster;
    private String[] title, rating, synopsis, releaseDate;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.header_movie_list);
        setContentView(R.layout.activity_movie_list);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(adapter);

        initData();
        getData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movie = new Movie();
                movie.setPoster(poster.getResourceId(i, -1));
                movie.setTitle(title[i]);
                movie.setRating(rating[i]);
                movie.setSynopsis(synopsis[i]);
                movie.setReleaseDate(releaseDate[i]);

                Intent movieDetail = new Intent(MovieListActivity.this, MovieDetailActivity.class);
                movieDetail.putExtra(MovieDetailActivity.MOVIE, movie);
                startActivity(movieDetail);
            }
        });
    }

    private void initData() {
        poster = getResources().obtainTypedArray(R.array.movie_poster);
        title = getResources().getStringArray(R.array.movie_title);
        rating = getResources().getStringArray(R.array.movie_rating);
        synopsis = getResources().getStringArray(R.array.movie_synopsis);
        releaseDate = getResources().getStringArray(R.array.movie_release_date);
    }

    private void getData() {
        movies = new ArrayList<>();

        for (int i = 0; i < title.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(poster.getResourceId(i, -1));
            movie.setTitle(title[i]);
            movie.setRating(rating[i]);
            movie.setSynopsis(synopsis[i]);
            movie.setReleaseDate(releaseDate[i]);
            movies.add(movie);
        }

        adapter.setMovie(movies);
    }
}
