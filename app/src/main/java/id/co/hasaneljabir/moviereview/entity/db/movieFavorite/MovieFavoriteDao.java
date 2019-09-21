package id.co.hasaneljabir.moviereview.entity.db.movieFavorite;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MovieFavoriteDao {
    @Insert
    public void addData(MovieFavorite movieFavorite);

    @Query("SELECT * FROM movie_favorite")
    public List<MovieFavorite> getFavoriteData();

    @Query("SELECT EXISTS (SELECT 1 FROM movie_favorite WHERE id=:id)")
    public int isFavorite(int id);

    @Delete
    public void delete(MovieFavorite movieFavorite);


}
