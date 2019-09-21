package id.co.hasaneljabir.moviereview.entity.db.tvShowFavorite;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TvShowFavoriteDao {
    @Insert
    public void addData(TvShowFavorite tvShowFavorite);

    @Query("SELECT * FROM tv_show_favorite")
    public List<TvShowFavorite> getFavoriteData();

    @Query("SELECT EXISTS (SELECT 1 FROM tv_show_favorite WHERE id=:id)")
    public int isFavorite(int id);

    @Delete
    public void delete(TvShowFavorite tvShowFavorite);


}
