package id.co.hasaneljabir.moviereview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.model.Movie;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovie(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie, view);
        return view;
    }

    private class ViewHolder {
        private TextView tvTitle, tvReleaseDate, tvSynopsis;
        private ImageView ivPoster;

        ViewHolder(View view) {
            tvTitle = view.findViewById(R.id.tv_title);
            tvReleaseDate = view.findViewById(R.id.tv_release_date);
            tvSynopsis = view.findViewById(R.id.tv_synopsis);
            ivPoster = view.findViewById(R.id.iv_poster);
        }

        void bind(Movie movie, View view) {
            tvTitle.setText(movie.getTitle());
            tvReleaseDate.setText(movie.getReleaseDate());
            tvSynopsis.setText(movie.getSynopsis());

            Glide.with(view.getContext())
                    .load(movie.getPoster())
                    .into(ivPoster);
        }
    }
}
