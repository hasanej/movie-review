package id.co.hasaneljabir.favoritemovie;

import android.database.Cursor;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static id.co.hasaneljabir.favoritemovie.DatabaseContract.FavoriteMovieColumns.OVERVIEW;
import static id.co.hasaneljabir.favoritemovie.DatabaseContract.FavoriteMovieColumns.POSTER_PATH;
import static id.co.hasaneljabir.favoritemovie.DatabaseContract.FavoriteMovieColumns.RELEASE_DATE;
import static id.co.hasaneljabir.favoritemovie.DatabaseContract.FavoriteMovieColumns.TITLE;
import static id.co.hasaneljabir.favoritemovie.DatabaseContract.FavoriteMovieColumns.VOTE_AVERAGE;

public class MappingHelper {

    public static ArrayList<FavoriteMovieItem> mapCursorToArrayList(Cursor notesCursor) {
        ArrayList<FavoriteMovieItem> favoriteMovieList = new ArrayList<>();
        while (notesCursor.moveToNext()) {
            int id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(_ID));
            String title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(TITLE));
            String releaseDate = notesCursor.getString(notesCursor.getColumnIndexOrThrow(RELEASE_DATE));
            String voteAverage = notesCursor.getString(notesCursor.getColumnIndexOrThrow(VOTE_AVERAGE));
            String overview = notesCursor.getString(notesCursor.getColumnIndexOrThrow(OVERVIEW));
            String posterPath = notesCursor.getString(notesCursor.getColumnIndexOrThrow(POSTER_PATH));
            favoriteMovieList.add(new FavoriteMovieItem(id, title, releaseDate, voteAverage, overview, posterPath));
        }
        return favoriteMovieList;
    }
}
