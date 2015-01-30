package com.example.senovik.fifteen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
//            case R.id.action_records:
//                Intent intentR = new Intent(this, RecordsActivity.class);
//                startActivity(intentR);
//                break;
            case R.id.action_new_game:
                new AlertDialog.Builder(this)
                        .setTitle(getResources().getString(R.string.confirmation_alert_title))
                        .setMessage(getResources().getString(R.string.confirmation_alert_message))
                        .setPositiveButton(getResources().getString(R.string.confirmation_ok_string),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        PuzzleFragment fragment = (PuzzleFragment) getSupportFragmentManager()
                                                .findFragmentById(R.id.puzzle_fragment);
                                        fragment.startNewGame();
                                    }
                                })
                        .setNegativeButton(getResources().getString(R.string.confirmation_cancel_string),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //TODO
                                    }
                                })
                        .show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startTimer() {
        TimerFragment fragment = (TimerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.timer_fragment);
        fragment.start();
    }

    public CharSequence stopTimer() {
        TimerFragment fragment = (TimerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.timer_fragment);
        return fragment.stop();
    }

    public void showCongratulation(int numberOfSwaps) {
        new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.congratulation_alert_title))
                .setMessage(getResources().getString(R.string.congratulation_alert_message_part_1) +
                        " " + stopTimer() + " seconds "
                        + getResources().getString(R.string.congratulation_alert_message_part_2) +
                        " " + numberOfSwaps +
                        " " + getResources().getString(R.string.congratulation_alert_message_part_3))
                .setPositiveButton(getResources().getString(R.string.congratulation_ok_string),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                PuzzleFragment fragment = (PuzzleFragment) getSupportFragmentManager()
                                        .findFragmentById(R.id.puzzle_fragment);
                                fragment.startNewGame();
                            }
                        })
                .setCancelable(false)
                .show();
    }

}
