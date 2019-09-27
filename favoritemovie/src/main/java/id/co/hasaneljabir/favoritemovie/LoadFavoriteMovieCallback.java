package id.co.hasaneljabir.favoritemovie;

import android.database.Cursor;

interface LoadFavoriteMovieCallback {
    void postExecute(Cursor notes);
}
