package id.co.hasaneljabir.moviereview.feature.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.adapter.MovieAdapter;
import id.co.hasaneljabir.moviereview.model.movie.Movie;
import id.co.hasaneljabir.moviereview.model.movie.MovieData;

public class MovieListFragment extends Fragment {
    private RecyclerView rvMovie;
    private ArrayList<Movie> movieList = new ArrayList<>();
    private MovieAdapter movieAdapter;

    public MovieListFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);

        movieList.addAll(MovieData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        movieAdapter = new MovieAdapter(movieList);
        rvMovie.setAdapter(movieAdapter);

        movieAdapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
            public void onItemClicked(Movie movie) {
                Intent movieDetail = new Intent(getContext(), MovieDetailActivity.class);
                movieDetail.putExtra(MovieDetailActivity.MOVIE, movie);
                startActivity(movieDetail);
            }
        });
    }
}
