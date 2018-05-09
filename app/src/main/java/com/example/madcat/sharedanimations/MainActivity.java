package com.example.madcat.sharedanimations;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout listLayout;

    private ImageView mainPhoto;
    private TextView mainName;
    private TextView mainDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLayout = (RelativeLayout) findViewById(R.id.listLayout);
        mainPhoto = (ImageView) findViewById(R.id.profile_image);
        mainName = (TextView) findViewById(R.id.profile_name);
        mainDesc = (TextView) findViewById(R.id.profile_desc);

        listLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharedIntent = new Intent(MainActivity.this, SecondActivity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(mainPhoto, "imageTransition");
                pairs[1] = new Pair<View, String>(mainName, "nameTransition");
                pairs[2] = new Pair<View, String>(mainDesc, "descTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(sharedIntent, options.toBundle());
            }
        });

    }
}
