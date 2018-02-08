package com.example.application.pragdemo;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    Adapter adapter;
    ArrayList<String> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        list.add("hello");
        list.add("hi");
        list.add("hey");
        list.add("helo");
        list.add("heylo");
        list.add("hell");
        list.add("he");
        list.add("hhhh");
        list.add("jdsjso");
        rv = findViewById(R.id.rv);
        adapter = new Adapter(this,list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);


        adapter.setOnClickListener(new Adapter.OnClickListener() {
            @Override
            public void itemClicked(View view, int position) {
                animateIntent(view);
            }
        });
    }


    public void animateIntent(View view) {

        // Ordinary Intent for launching a new activity
        Intent intent = new Intent(this, CollapseActivity.class);

        // Get the transition name from the string
        String transitionName = getString(R.string.transition_string);

        // Define the view that the animation will start from

        ActivityOptionsCompat options =

                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                       view,
                        transitionName// The String
                );
        //Start the Intent
        ActivityCompat.startActivity(this, intent, options.toBundle());

    }
}
