package id.co.hasaneljabir.moviereview.entity.tvShow;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {TvShowFavorite.class}, version = 1)
public abstract class TvShowFavoriteDb extends RoomDatabase {
    public abstract TvShowFavoriteDao tvShowFavoriteDao();
}
