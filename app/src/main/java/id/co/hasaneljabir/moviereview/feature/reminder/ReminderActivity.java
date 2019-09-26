package id.co.hasaneljabir.moviereview.feature.reminder;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;
import id.co.hasaneljabir.moviereview.BuildConfig;
import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.sharedPreference.SharedPreference;

public class ReminderActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String API_KEY = BuildConfig.TMDB_API_KEY;

    private ReminderReceiver reminderReceiver;

    Switch switchDaily, switchNewRelease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        setTitle(R.string.reminder);

        reminderReceiver = new ReminderReceiver();

        switchDaily = findViewById(R.id.switch_daily);
        switchNewRelease = findViewById(R.id.switch_new_release);

        switchDaily.setOnClickListener(this);
        switchNewRelease.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switch_daily:
                if (switchDaily.isChecked()) {
                    Toast.makeText(this, getString(R.string.daily_enabled), Toast.LENGTH_SHORT).show();
                    reminderReceiver.setDailyReminder(this, "07:00",
                            "Go Check Movie Review App Today!");
                } else {
                    Toast.makeText(this, getString(R.string.daily_disabled), Toast.LENGTH_SHORT).show();
                    reminderReceiver.cancelDailyReminder(this);
                }

                break;
            case R.id.switch_new_release:
                if (switchNewRelease.isChecked()) {
                    Toast.makeText(this, getString(R.string.new_release_enabled), Toast.LENGTH_SHORT).show();
                    reminderReceiver.setNewReleaseReminder(this, "08:00",
                            ReminderReceiver.EXTRA_MESSAGE);
                } else {
                    Toast.makeText(this, getString(R.string.new_release_disabled), Toast.LENGTH_SHORT).show();
                    reminderReceiver.cancelNewReleaseReminder(this);
                }

                break;
        }
    }

    public static void getNewRelease(final Context context) {
        final SharedPreference sharedPreference = new SharedPreference(context);

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String currentDate = date.format(new Date());

        final AsyncHttpClient[] client = {new AsyncHttpClient()};
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&primary_release_date.gte="
                + currentDate + "&primary_release_date.lte=" + currentDate;

        client[0].get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject responseObject = new JSONObject(result);

                    String title = responseObject.getJSONArray("results").getJSONObject(0).getString("title");
                    sharedPreference.saveString(SharedPreference.MOVIE_TITLE, title);

                    Toast.makeText(context, sharedPreference.getNewReleaseMovieTitle(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    sharedPreference.saveString(SharedPreference.MOVIE_TITLE, "Error Response");
                    Log.d("movieNewReleaseErr", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                sharedPreference.saveString(SharedPreference.MOVIE_TITLE, "No Internet Connection");
                Log.d("movieNewReleaseNoConn", error.getMessage());
            }
        });
    }
}
