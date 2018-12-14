package com.a247software.javatraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mTopicList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTopicList = findViewById(R.id.rv_topics);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mTopicList.setLayoutManager(layoutManager);
        mTopicList.setHasFixedSize(true);

    }


    // END
}
