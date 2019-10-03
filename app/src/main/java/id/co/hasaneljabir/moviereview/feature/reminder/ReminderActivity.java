package id.co.hasaneljabir.moviereview.feature.reminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import id.co.hasaneljabir.moviereview.R;
import id.co.hasaneljabir.moviereview.sharedPreference.SharedPreference;

public class ReminderActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreference sharedPreference;

    private ReminderReceiver reminderReceiver;

    private Switch switchDaily, switchNewRelease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        setTitle(R.string.reminder);

        sharedPreference = new SharedPreference(this);

        reminderReceiver = new ReminderReceiver();

        switchDaily = findViewById(R.id.switch_daily);
        switchNewRelease = findViewById(R.id.switch_new_release);

        switchDaily.setOnClickListener(this);
        switchNewRelease.setOnClickListener(this);

        checkReminderStatus();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switch_daily:
                if (switchDaily.isChecked()) {
                    sharedPreference.saveBoolean(SharedPreference.STATUS_DAILY_REMINDER, true);
                    reminderReceiver.setDailyReminder(this, "07:00",
                            "Go Check Movie Review App Today!");
                    Toast.makeText(this, getString(R.string.daily_enabled), Toast.LENGTH_SHORT).show();
                } else {
                    sharedPreference.saveBoolean(SharedPreference.STATUS_DAILY_REMINDER, false);
                    reminderReceiver.cancelDailyReminder(this);
                    Toast.makeText(this, getString(R.string.daily_disabled), Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.switch_new_release:
                if (switchNewRelease.isChecked()) {
                    sharedPreference.saveBoolean(SharedPreference.STATUS_NEW_RELEASE_REMINDER, true);
                    reminderReceiver.setNewReleaseReminder(this, "08:00",
                            ReminderReceiver.EXTRA_MESSAGE);
                    Toast.makeText(this, getString(R.string.new_release_enabled), Toast.LENGTH_SHORT).show();
                } else {
                    sharedPreference.saveBoolean(SharedPreference.STATUS_NEW_RELEASE_REMINDER, false);
                    reminderReceiver.cancelNewReleaseReminder(this);
                    Toast.makeText(this, getString(R.string.new_release_disabled), Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    private void checkReminderStatus() {
        if (sharedPreference.getStatusDailyReminder()) {
            switchDaily.setChecked(true);
        } else {
            switchDaily.setChecked(false);
        }

        if (sharedPreference.getStatusNewReleaseReminder()) {
            switchNewRelease.setChecked(true);
        } else {
            switchNewRelease.setChecked(false);
        }
    }
}
