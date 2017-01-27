package com.pawan.fragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    public DataTransferHelper dataTransferHelper;

    public void setDataTransferHelper(DataTransferHelper dataTransferHelper) {
        this.dataTransferHelper = dataTransferHelper;
    }

    public DataTransferHelper getDataTransferHelper() {
        return dataTransferHelper;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.first_frame_layout, new FirstFragment())
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.second_frame_layout, new SecondFragment())
                .commit();
    }
}
