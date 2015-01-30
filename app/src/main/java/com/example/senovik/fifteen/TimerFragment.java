package com.example.senovik.fifteen;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimerFragment extends Fragment {

    TextView mTimerTextView;
    long mStartTime = 0;

    Handler mTimerHandler = new Handler();
    Runnable mTimerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - mStartTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            mTimerTextView.setText(String.format("%d:%02d", minutes, seconds));

            mTimerHandler.postDelayed(this, 500);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_timer, container, false);

        mTimerTextView = (TextView) view.findViewById(R.id.timerTextView);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        mTimerHandler.removeCallbacks(mTimerRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        mTimerHandler.postDelayed(mTimerRunnable, 0);
    }

    public void start() {
        mStartTime = System.currentTimeMillis();
        mTimerHandler.postDelayed(mTimerRunnable, 0);
    }

    public CharSequence stop() {
        mTimerHandler.removeCallbacks(mTimerRunnable);
        return mTimerTextView.getText();
    }

}
