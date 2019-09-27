package id.co.hasaneljabir.moviereview.entity.contentProvider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static id.co.hasaneljabir.moviereview.entity.contentProvider.DatabaseContract.FavoriteMovieColumns.OVERVIEW;
import static id.co.hasaneljabir.moviereview.entity.contentProvider.DatabaseContract.FavoriteMovieColumns.POSTER_PATH;
import static id.co.hasaneljabir.moviereview.entity.contentProvider.DatabaseContract.FavoriteMovieColumns.RELEASE_DATE;
import static id.co.hasaneljabir.moviereview.entity.contentProvider.DatabaseContract.FavoriteMovieColumns.TABLE_NAME;
import static id.co.hasaneljabir.moviereview.entity.contentProvider.DatabaseContract.FavoriteMovieColumns.TITLE;
import static id.co.hasaneljabir.moviereview.entity.contentProvider.DatabaseContract.FavoriteMovieColumns.VOTE_AVERAGE;


public class FavoriteMovieHelper {

    private static final String DATABASE_TABLE = TABLE_NAME;
    private final DatabaseHelper dataBaseHelper;
    private static FavoriteMovieHelper INSTANCE;

    private SQLiteDatabase database;

    private FavoriteMovieHelper(Context context) {
        dataBaseHelper = new DatabaseHelper(context);
    }

    public static FavoriteMovieHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FavoriteMovieHelper(context);
                }
            }
        }
        return INSTANCE;
    }


    public void open() throws SQLException {
        database = dataBaseHelper.getWritableDatabase();
    }

    public void close() {
        dataBaseHelper.close();

        if (database.isOpen())
            database.close();
    }

    public ArrayList<FavoriteMovie> query() {
        ArrayList<FavoriteMovie> arrayList = new ArrayList<>();
        Cursor cursor = database.query(DATABASE_TABLE
                , null
                , null
                , null
                , null
                , null, _ID + " DESC"
                , null);
        cursor.moveToFirst();
        FavoriteMovie favoriteMovie;
        if (cursor.getCount() > 0) {
            do {
                favoriteMovie = new FavoriteMovie();
                favoriteMovie.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                favoriteMovie.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(TITLE)));
                favoriteMovie.setReleaseDate(cursor.getString(cursor.getColumnIndexOrThrow(RELEASE_DATE)));
                favoriteMovie.setVoteAverage(cursor.getString(cursor.getColumnIndexOrThrow(VOTE_AVERAGE)));
                favoriteMovie.setOverview(cursor.getString(cursor.getColumnIndexOrThrow(OVERVIEW)));
                favoriteMovie.setPosterPath(cursor.getString(cursor.getColumnIndexOrThrow(POSTER_PATH)));

                arrayList.add(favoriteMovie);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insert(FavoriteMovie favoriteMovie) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(TITLE, favoriteMovie.getTitle());
        initialValues.put(RELEASE_DATE, favoriteMovie.getReleaseDate());
        initialValues.put(VOTE_AVERAGE, favoriteMovie.getVoteAverage());
        initialValues.put(OVERVIEW, favoriteMovie.getOverview());
        initialValues.put(POSTER_PATH, favoriteMovie.getPosterPath());
        return database.insert(DATABASE_TABLE, null, initialValues);
    }

    public int update(FavoriteMovie favoriteMovie) {
        ContentValues args = new ContentValues();
        args.put(TITLE, favoriteMovie.getTitle());
        args.put(RELEASE_DATE, favoriteMovie.getReleaseDate());
        args.put(VOTE_AVERAGE, favoriteMovie.getVoteAverage());
        args.put(OVERVIEW, favoriteMovie.getOverview());
        args.put(POSTER_PATH, favoriteMovie.getPosterPath());
        return database.update(DATABASE_TABLE, args, _ID + "= '" + favoriteMovie.getId() + "'", null);
    }

    public int delete(int id) {
        return database.delete(TABLE_NAME, _ID + " = '" + id + "'", null);
    }

    public Cursor queryByIdProvider(String id) {
        return database.query(DATABASE_TABLE, null
                , _ID + " = ?"
                , new String[]{id}
                , null
                , null
                , null
                , null);
    }

    public Cursor queryProvider() {
        return database.query(DATABASE_TABLE
                , null
                , null
                , null
                , null
                , null
                , _ID + " ASC");
    }

    public long insertProvider(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }

    public int updateProvider(String id, ContentValues values) {
        return database.update(DATABASE_TABLE, values, _ID + " = ?", new String[]{id});
    }

    public int deleteProvider(String id) {
        return database.delete(DATABASE_TABLE, _ID + " = ?", new String[]{id});
    }
}
