package id.co.hasaneljabir.moviereview.entity.db.movieFavorite;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MovieFavoriteDao {

    @Insert
    void addData(MovieFavorite movieFavorite);

    @Query("SELECT * FROM movie_favorite")
    List<MovieFavorite> getFavoriteData();

    @Query("SELECT EXISTS (SELECT 1 FROM movie_favorite WHERE id=:id)")
    int isFavorite(int id);

    @Delete
    void delete(MovieFavorite movieFavorite);
}