package com.msaggik.firstlessoncounter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.msaggik.firstlessoncounter.R;

public class MainActivity extends AppCompatActivity {

    private TextView counterTextView;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = (TextView) findViewById(R.id.counterTextView);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter");
            counterTextView.setText(String.valueOf(counter));
        }

        Button incrementButton = (Button) findViewById(R.id.incrementButton);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementCounter();
            }
        });

        Button decrementButton = (Button) findViewById(R.id.decrementButton);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementCounter();
            }
        });
    }

    private void incrementCounter() {
        counter++;
        counterTextView.setText(String.valueOf(counter));
    }

    private void decrementCounter() {
        counter--;
        counterTextView.setText(String.valueOf(counter));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }
}