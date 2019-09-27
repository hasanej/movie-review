package id.co.hasaneljabir.moviereview.entity.contentProvider;

import java.util.ArrayList;

public interface LoadFavoriteMovieCallback {
    void preExecute();

    void postExecute(ArrayList<FavoriteMovie> favoriteMovies);
}
