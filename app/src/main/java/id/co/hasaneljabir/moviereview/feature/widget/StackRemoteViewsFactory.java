package id.co.hasaneljabir.moviereview.feature.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.bumptech.glide.Glide;

import java.util.List;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.entity.db.movieFavorite.MovieFavorite;
import id.co.hasaneljabir.moviereview.helper.Constant;

import static id.co.hasaneljabir.moviereview.feature.HomeActivity.movieFavoriteDb;

public class StackRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private List<MovieFavorite> movieFavorite;
    private final Context mContext;

    StackRemoteViewsFactory(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {
        movieFavorite = movieFavoriteDb.movieFavoriteDao().getFavoriteData();
    }

    @Override
    public void onDataSetChanged() {
        movieFavorite = movieFavoriteDb.movieFavoriteDao().getFavoriteData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return movieFavorite.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.item_widget);

        if (movieFavorite.size() > 0) {
            MovieFavorite movie = movieFavorite.get(position);

            try {
                Bitmap bitmap = Glide.with(mContext)
                        .asBitmap()
                        .load(Constant.POSTER_BASE_URL_342 + movie.getPosterPath())
                        .submit(512, 512)
                        .get();

                remoteViews.setImageViewBitmap(R.id.imageView, bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Bundle extras = new Bundle();
            extras.putString(FavoriteWidgetProvider.EXTRA_ITEM, movie.getTitle());
            Intent fillInIntent = new Intent();
            fillInIntent.putExtras(extras);
            remoteViews.setOnClickFillInIntent(R.id.imageView, fillInIntent);

            return remoteViews;
        } else {
            return null;
        }
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
