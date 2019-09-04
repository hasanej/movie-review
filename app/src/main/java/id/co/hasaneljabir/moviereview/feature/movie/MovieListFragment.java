package id.co.hasaneljabir.moviereview.feature.movie;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.adapter.MovieAdapter;
import id.co.hasaneljabir.moviereview.model.movie.MovieItems;
import id.co.hasaneljabir.moviereview.model.movie.MovieViewModel;

public class MovieListFragment extends Fragment {
    private ProgressBar progressBar;

    private ArrayList<MovieItems> movieList = new ArrayList<>();
    private MovieAdapter movieAdapter;

    public MovieListFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        RecyclerView rvMovie = view.findViewById(R.id.rv_movie);
        progressBar = view.findViewById(R.id.progress_bar);

        MovieViewModel movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getMovies().observe(this, getMovie);

        movieAdapter = new MovieAdapter(movieList);
        movieAdapter.notifyDataSetChanged();

        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMovie.setAdapter(movieAdapter);

        movieViewModel.setMovie();
        showLoading(true);

        movieAdapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
            public void onItemClicked(MovieItems movieItems) {
                Intent movieDetail = new Intent(getContext(), MovieDetailActivity.class);
                movieDetail.putExtra(MovieDetailActivity.MOVIE, movieItems);
                startActivity(movieDetail);
            }
        });
    }

    private Observer<ArrayList<MovieItems>> getMovie = new Observer<ArrayList<MovieItems>>() {
        @Override
        public void onChanged(ArrayList<MovieItems> movieItems) {
            showLoading(true);

            if (movieItems != null) {
                movieAdapter.setData(movieItems);
                showLoading(false);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
