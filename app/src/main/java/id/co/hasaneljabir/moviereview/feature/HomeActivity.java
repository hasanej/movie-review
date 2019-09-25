package id.co.hasaneljabir.moviereview.feature;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.entity.db.FavoriteDb;
import id.co.hasaneljabir.moviereview.feature.movie.MovieFavActivity;
import id.co.hasaneljabir.moviereview.feature.movie.MovieListFragment;
import id.co.hasaneljabir.moviereview.feature.reminder.ReminderActivity;
import id.co.hasaneljabir.moviereview.feature.tvShow.TvShowFavActivity;
import id.co.hasaneljabir.moviereview.feature.tvShow.TvShowListFragment;

public class HomeActivity extends AppCompatActivity {
    public static FavoriteDb movieFavoriteDb, tvShowFavoriteDb;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.navigation_movie:
                    fragment = new MovieListFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;
                case R.id.navigation_tv_show:
                    fragment = new TvShowListFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                            .commit();
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle(R.string.home);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            navigation.setSelectedItemId(R.id.navigation_movie);
        }

        movieFavoriteDb = Room.databaseBuilder(getApplicationContext(),
                FavoriteDb.class, "movie_fav").allowMainThreadQueries().build();

        tvShowFavoriteDb = Room.databaseBuilder(getApplicationContext(),
                FavoriteDb.class, "tv_show_fav").allowMainThreadQueries().build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_fav_movie:
                Intent movieFav = new Intent(this, MovieFavActivity.class);
                startActivity(movieFav);
                break;
            case R.id.action_fav_tv_show:
                Intent tvShowFav = new Intent(this, TvShowFavActivity.class);
                startActivity(tvShowFav);
                break;
            case R.id.action_language_setting:
                Intent changeLanguage = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(changeLanguage);
                break;
            case R.id.action_reminder_setting:
                Intent reminder = new Intent(this, ReminderActivity.class);
                startActivity(reminder);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
