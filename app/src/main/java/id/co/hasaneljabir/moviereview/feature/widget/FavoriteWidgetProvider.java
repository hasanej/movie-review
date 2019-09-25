package id.co.hasaneljabir.moviereview.feature.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

import id.co.hasaneljabir.moviereview.R;

public class FavoriteWidgetProvider extends AppWidgetProvider {

    private static final String TOAST_ACTION = "id.co.hasaneljabir.moviereview.TOAST_ACTION";
    public static final String EXTRA_ITEM = "com.dicoding.picodiploma.EXTRA_ITEM";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        Intent intent = new Intent(context, StackWidgetService.class);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.favorite_widget);
        remoteViews.setRemoteAdapter(R.id.stack_view, intent);
        remoteViews.setEmptyView(R.id.stack_view, R.id.empty_view);

        Intent toastIntent = new Intent(context, FavoriteWidgetProvider.class);
        toastIntent.setAction(FavoriteWidgetProvider.TOAST_ACTION);
        toastIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
        PendingIntent toastPendingIntent = PendingIntent.getBroadcast(context, 0, toastIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setPendingIntentTemplate(R.id.stack_view, toastPendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction() != null) {
            if (intent.getAction().equals(TOAST_ACTION)) {
                String title = intent.getStringExtra(EXTRA_ITEM);
                Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
    }

    @Override
    public void onDisabled(Context context) {
    }

    public static void updateWidget(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, FavoriteWidgetProvider.class));
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.stack_view);
    }
}

