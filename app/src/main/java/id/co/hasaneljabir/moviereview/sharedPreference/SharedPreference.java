package id.co.hasaneljabir.moviereview.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {

    private static final String MOVIE_REVIEW = "MOVIE_REVIEW";

    public static final String MOVIE_TITLE = "movie_title";

    private final SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public SharedPreference(Context context) {
        preferences = context.getSharedPreferences(MOVIE_REVIEW, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void saveString(String keySP, String value) {
        editor.putString(keySP, value);
        editor.commit();
    }

    public void saveBoolean(String keySP, boolean value) {
        editor.putBoolean(keySP, value);
        editor.commit();
    }

    public String getNewReleaseMovieTitle() {
        return preferences.getString(MOVIE_TITLE, "");
    }
}
