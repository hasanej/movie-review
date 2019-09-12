package id.co.hasaneljabir.moviereview.entity.movie;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {MovieFavorite.class}, version = 1)
public abstract class MovieFavoriteDb extends RoomDatabase {
    public abstract MovieFavoriteDao movieFavoriteDao();
}
