package id.co.hasaneljabir.moviereview.feature.reminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import id.co.hasaneljabir.moviereview.R;

public class ReminderActivity extends AppCompatActivity {

    Switch switchDaily, switchNewRelease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        setTitle(R.string.reminder);

        switchDaily = findViewById(R.id.switch_daily);
        switchNewRelease = findViewById(R.id.switch_new_release);

        switchDaily.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (switchDaily.isChecked()) {
                    Toast.makeText(ReminderActivity.this, getString(R.string.daily_enabled), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReminderActivity.this, getString(R.string.daily_disabled), Toast.LENGTH_SHORT).show();
                }
            }
        });

        switchNewRelease.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (switchNewRelease.isChecked()) {
                    Toast.makeText(ReminderActivity.this, getString(R.string.new_release_enabled), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReminderActivity.this, getString(R.string.new_release_disabled), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
