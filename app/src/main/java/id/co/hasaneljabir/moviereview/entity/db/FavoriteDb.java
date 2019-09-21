package id.co.hasaneljabir.moviereview.entity.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import id.co.hasaneljabir.moviereview.entity.db.movieFavorite.MovieFavorite;
import id.co.hasaneljabir.moviereview.entity.db.movieFavorite.MovieFavoriteDao;
import id.co.hasaneljabir.moviereview.entity.db.tvShowFavorite.TvShowFavorite;
import id.co.hasaneljabir.moviereview.entity.db.tvShowFavorite.TvShowFavoriteDao;

@Database(entities = {MovieFavorite.class, TvShowFavorite.class}, version = 1)
public abstract class FavoriteDb extends RoomDatabase {
    public abstract MovieFavoriteDao movieFavoriteDao();

    public abstract TvShowFavoriteDao tvShowFavoriteDao();
}
