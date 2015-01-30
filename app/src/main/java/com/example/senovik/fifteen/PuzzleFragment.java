package com.example.senovik.fifteen;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

@TargetApi(16)
public class PuzzleFragment extends Fragment implements OnClickListener {

    private int mNumberOfSwaps;
    private ViewHolder mViewHolder;

    public static class ViewHolder {

        public final Button[][] mButtons = new Button[4][4];

        public ViewHolder(View view) {
            mButtons[0][0] = (Button) view.findViewById(R.id.button1);
            mButtons[0][1] = (Button) view.findViewById(R.id.button2);
            mButtons[0][2] = (Button) view.findViewById(R.id.button3);
            mButtons[0][3] = (Button) view.findViewById(R.id.button4);
            mButtons[1][0] = (Button) view.findViewById(R.id.button5);
            mButtons[1][1] = (Button) view.findViewById(R.id.button6);
            mButtons[1][2] = (Button) view.findViewById(R.id.button7);
            mButtons[1][3] = (Button) view.findViewById(R.id.button8);
            mButtons[2][0] = (Button) view.findViewById(R.id.button9);
            mButtons[2][1] = (Button) view.findViewById(R.id.button10);
            mButtons[2][2] = (Button) view.findViewById(R.id.button11);
            mButtons[2][3] = (Button) view.findViewById(R.id.button12);
            mButtons[3][0] = (Button) view.findViewById(R.id.button13);
            mButtons[3][1] = (Button) view.findViewById(R.id.button14);
            mButtons[3][2] = (Button) view.findViewById(R.id.button15);
            mButtons[3][3] = (Button) view.findViewById(R.id.button16);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_puzzle, container, false);

        mViewHolder = new ViewHolder(view);
        view.setTag(mViewHolder);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mViewHolder.mButtons[i][j].setOnClickListener(this);
            }
        }


        startNewGame();

        return view;

    }

    @Override
    public void onClick(View v) {

        mNumberOfSwaps++;

        String empty = new String("");
        switch (v.getId()) {
            case R.id.button1:
                if (mViewHolder.mButtons[0][1].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[0][0], mViewHolder.mButtons[0][1]);
                else if (mViewHolder.mButtons[1][0].getText().equals(empty))
                    swapData(mViewHolder.mButtons[0][0], mViewHolder.mButtons[1][0]);
                break;
            case R.id.button2:
                if (mViewHolder.mButtons[0][0].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[0][1], mViewHolder.mButtons[0][0]);
                else if (mViewHolder.mButtons[0][2].getText().equals(empty))
                    swapData(mViewHolder.mButtons[0][1], mViewHolder.mButtons[0][2]);
                else if (mViewHolder.mButtons[1][1].getText().equals(empty))
                    swapData(mViewHolder.mButtons[0][1], mViewHolder.mButtons[1][1]);
                break;
            case R.id.button3:
                if (mViewHolder.mButtons[0][1].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[0][2], mViewHolder.mButtons[0][1]);
                else if (mViewHolder.mButtons[0][3].getText().equals(empty))
                    swapData(mViewHolder.mButtons[0][2], mViewHolder.mButtons[0][3]);
                else if (mViewHolder.mButtons[1][2].getText().equals(empty))
                    swapData(mViewHolder.mButtons[0][2], mViewHolder.mButtons[1][2]);
                break;
            case R.id.button4:
                if (mViewHolder.mButtons[0][2].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[0][3], mViewHolder.mButtons[0][2]);
                else if (mViewHolder.mButtons[1][3].getText().equals(empty))
                    swapData(mViewHolder.mButtons[0][3], mViewHolder.mButtons[1][3]);
                break;
            case R.id.button5:
                if (mViewHolder.mButtons[0][0].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[1][0], mViewHolder.mButtons[0][0]);
                else if (mViewHolder.mButtons[1][1].getText().equals(empty))
                    swapData(mViewHolder.mButtons[1][0], mViewHolder.mButtons[1][1]);
                else if (mViewHolder.mButtons[2][0].getText().equals(empty))
                    swapData(mViewHolder.mButtons[1][0], mViewHolder.mButtons[2][0]);
                break;
            case R.id.button6:
                if (mViewHolder.mButtons[0][1].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[1][1], mViewHolder.mButtons[0][1]);
                else if (mViewHolder.mButtons[1][0].getText().equals(empty))
                    swapData(mViewHolder.mButtons[1][1], mViewHolder.mButtons[1][0]);
                else if (mViewHolder.mButtons[1][2].getText().equals(empty))
                    swapData(mViewHolder.mButtons[1][1], mViewHolder.mButtons[1][2]);
                else if (mViewHolder.mButtons[2][1].getText().equals(empty))
                    swapData(mViewHolder.mButtons[1][1], mViewHolder.mButtons[2][1]);
                break;
            case R.id.button7:
                if (mViewHolder.mButtons[0][2].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[1][2], mViewHolder.mButtons[0][2]);
                else if (mViewHolder.mButtons[1][1].getText().equals(empty))
                    swapData(mViewHolder.mButtons[1][2], mViewHolder.mButtons[1][1]);
                else if (mViewHolder.mButtons[1][3].getText().equals(empty))
                    swapData(mViewHolder.mButtons[1][2], mViewHolder.mButtons[1][3]);
                else if (mViewHolder.mButtons[2][2].getText().equals(empty))
                    swapData(mViewHolder.mButtons[1][2], mViewHolder.mButtons[2][2]);
                break;
            case R.id.button8:
                if (mViewHolder.mButtons[0][3].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[1][3], mViewHolder.mButtons[0][3]);
                else if (mViewHolder.mButtons[1][2].getText().equals(empty))
                    swapData(mViewHolder.mButtons[1][3], mViewHolder.mButtons[1][2]);
                else if (mViewHolder.mButtons[2][3].getText().equals(empty))
                    swapData(mViewHolder.mButtons[1][3], mViewHolder.mButtons[2][3]);
                break;
            case R.id.button9:
                if (mViewHolder.mButtons[1][0].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][0], mViewHolder.mButtons[1][0]);
                else if (mViewHolder.mButtons[2][1].getText().equals(empty))
                    swapData(mViewHolder.mButtons[2][0], mViewHolder.mButtons[2][1]);
                else if (mViewHolder.mButtons[3][0].getText().equals(empty))
                    swapData(mViewHolder.mButtons[2][0], mViewHolder.mButtons[3][0]);
                break;
            case R.id.button10:
                if (mViewHolder.mButtons[1][1].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][1], mViewHolder.mButtons[1][1]);
                else if (mViewHolder.mButtons[2][0].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][1], mViewHolder.mButtons[2][0]);
                else if (mViewHolder.mButtons[2][2].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][1], mViewHolder.mButtons[2][2]);
                else if (mViewHolder.mButtons[3][1].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][1], mViewHolder.mButtons[3][1]);
                break;
            case R.id.button11:
                if (mViewHolder.mButtons[1][2].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][2], mViewHolder.mButtons[1][2]);
                else if (mViewHolder.mButtons[2][1].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][2], mViewHolder.mButtons[2][1]);
                else if (mViewHolder.mButtons[2][3].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][2], mViewHolder.mButtons[2][3]);
                else if (mViewHolder.mButtons[3][2].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][2], mViewHolder.mButtons[3][2]);
                break;
            case R.id.button12:
                if (mViewHolder.mButtons[1][3].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][3], mViewHolder.mButtons[1][3]);
                else if (mViewHolder.mButtons[2][2].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][3], mViewHolder.mButtons[2][2]);
                else if (mViewHolder.mButtons[3][3].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[2][3], mViewHolder.mButtons[3][3]);
                break;
            case R.id.button13:
                if (mViewHolder.mButtons[2][0].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[3][0], mViewHolder.mButtons[2][0]);
                else if (mViewHolder.mButtons[3][1].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[3][0], mViewHolder.mButtons[3][1]);
                break;
            case R.id.button14:
                if (mViewHolder.mButtons[2][1].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[3][1], mViewHolder.mButtons[2][1]);
                else if (mViewHolder.mButtons[3][0].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[3][1], mViewHolder.mButtons[3][0]);
                else if (mViewHolder.mButtons[3][2].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[3][1], mViewHolder.mButtons[3][2]);
                break;
            case R.id.button15:
                if (mViewHolder.mButtons[2][2].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[3][2], mViewHolder.mButtons[2][2]);
                else if (mViewHolder.mButtons[3][1].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[3][2], mViewHolder.mButtons[3][1]);
                else if (mViewHolder.mButtons[3][3].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[3][2], mViewHolder.mButtons[3][3]);
                break;
            case R.id.button16:
                if (mViewHolder.mButtons[2][3].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[3][3], mViewHolder.mButtons[2][3]);
                else if (mViewHolder.mButtons[3][2].getText().toString().equals(empty))
                    swapData(mViewHolder.mButtons[3][3], mViewHolder.mButtons[3][2]);
                break;
        }

        if (checkIfWin() == true) {
            ((MainActivity) getActivity()).showCongratulation(mNumberOfSwaps);
        }
    }


    private void swapData(Button b1, Button b2) {
        CharSequence tempText = b1.getText();
        b1.setText(b2.getText());
        b2.setText(tempText);

        Drawable tempBackground = b1.getBackground();
        setDrawable(b1, b2.getBackground());
        setDrawable(b2, tempBackground);
    }

    private boolean checkIfWin() {

        if (mViewHolder.mButtons[0][0].getText().toString().equals("1")
                && mViewHolder.mButtons[0][1].getText().toString().equals("2")
                && mViewHolder.mButtons[0][2].getText().toString().equals("3")
                && mViewHolder.mButtons[0][3].getText().toString().equals("4")
                && mViewHolder.mButtons[1][0].getText().toString().equals("5")
                && mViewHolder.mButtons[1][1].getText().toString().equals("6")
                && mViewHolder.mButtons[1][2].getText().toString().equals("7")
                && mViewHolder.mButtons[1][3].getText().toString().equals("8")
                && mViewHolder.mButtons[2][0].getText().toString().equals("9")
                && mViewHolder.mButtons[2][1].getText().toString().equals("10")
                && mViewHolder.mButtons[2][2].getText().toString().equals("11")
                && mViewHolder.mButtons[2][3].getText().toString().equals("12")
                && mViewHolder.mButtons[3][0].getText().toString().equals("13")
                && mViewHolder.mButtons[3][1].getText().toString().equals("14")
                && mViewHolder.mButtons[3][2].getText().toString().equals("15")) {
            return true;
        } else
            return false;

    }

    public void startNewGame() {

        ((MainActivity) getActivity()).startTimer();
        mNumberOfSwaps = 0;

        boolean debug = false;
        if (debug) {
            mViewHolder.mButtons[0][0].setText(String.valueOf(1));
            mViewHolder.mButtons[0][1].setText(String.valueOf(2));
            mViewHolder.mButtons[0][2].setText(String.valueOf(3));
            mViewHolder.mButtons[0][3].setText(String.valueOf(4));
            mViewHolder.mButtons[1][0].setText(String.valueOf(5));
            mViewHolder.mButtons[1][1].setText(String.valueOf(6));
            mViewHolder.mButtons[1][2].setText(String.valueOf(7));
            mViewHolder.mButtons[1][3].setText(String.valueOf(8));
            mViewHolder.mButtons[2][0].setText(String.valueOf(9));
            mViewHolder.mButtons[2][1].setText(String.valueOf(10));
            mViewHolder.mButtons[2][2].setText(String.valueOf(11));
            mViewHolder.mButtons[2][3].setText(String.valueOf(12));
            mViewHolder.mButtons[3][0].setText(String.valueOf(13));
            mViewHolder.mButtons[3][1].setText(String.valueOf(14));
            mViewHolder.mButtons[3][3].setText(String.valueOf(15));
        } else {
            randomPlace();
        }

    }

    private void randomPlace() {
        Random r = new Random();
        int[] array = new int[16];
        int high = 16;
        int next = 0;
        boolean consists;
        for (int i = 0; i < 16; i++) {
            consists = true;
            while (consists == true) {
                next = r.nextInt(high);
                consists = false;
                for (int j = 0; j < i; j++) {
                    if (array[j] == next)
                        consists = true;
                }
            }
            array[i] = next;
        }

        if (!isCombinationSolvable(array)) {
            if (array[0] != 0 && array[1] != 0) {
                int temp = array[0];
                array[0] = array[1];
                array[1] = temp;
            } else {
                int temp = array[2];
                array[2] = array[3];
                array[3] = temp;
            }
        }

        int[][] array2d = new int[4][4];
        for (int k = 0; k < 16; k++) {
            array2d[k / 4][k - 4 * (k / 4)] = array[k];
        }

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (array2d[i][j] == 0) {
                    mViewHolder.mButtons[i][j].setText("");
                    setDrawable(mViewHolder.mButtons[i][j], getResources().getDrawable(R.color.dark_dark_grey));
                } else {
                    mViewHolder.mButtons[i][j].setText(String.valueOf(array2d[i][j]));
                    setDrawable(mViewHolder.mButtons[i][j], getResources().getDrawable(R.drawable.button_effect));
                }
    }

    private boolean isCombinationSolvable(int[] array) {
        int[] n = new int[15];
        int e;
        for (int i = 1; i < 16; i++) {
            for (int j = indexOf(array, i); j < 16; j++) {
                if (array[j] < i && array[j] != 0)
                    n[i-1]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < 15; i++) {
            sum += n[i];
        }
        e = indexOf(array, 0) / 4 + 1;

        if (((sum + e) % 2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    private int indexOf(int[] array, int elem) {
        for (int i = 0; i < 16; i++) {
            if (array[i] == elem)
                return i;
        }
        return -1;
    }

    private void setDrawable(Button b, Drawable d) {
        int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            b.setBackgroundDrawable(d);
        } else {
            b.setBackground(d);
        }
    }
}
