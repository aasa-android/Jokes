package com.free.hindi.jokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;


public class IndexActivity extends ActionBarActivity {

    ImageView mBoysGirls, mFriends, mRajini, mRelation;
    private StartAppAd startAppAd = new StartAppAd(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "102735663", "203061851", true);
        setContentView(com.free.hindi.jokes.R.layout.activity_index);
        StartAppAd.showSlider(this);

        AdView mAdView = (AdView) findViewById(com.free.hindi.jokes.R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mBoysGirls = (ImageView) findViewById(R.id.boysgirls);
        mFriends = (ImageView) findViewById(R.id.friends);
        mRajini = (ImageView) findViewById(R.id.rajini);
        mRelation = (ImageView) findViewById(R.id.relation);

        mBoysGirls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, JokesListActivity.class);
                intent.putExtra("image", "boysgirls");
                startActivity(intent);
            }
        });
        mFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, JokesListActivity.class);
                intent.putExtra("image", "friends");
                startActivity(intent);
            }
        });
        mRajini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, JokesListActivity.class);
                intent.putExtra("image", "rajini");
                startActivity(intent);
            }
        });
        mRelation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IndexActivity.this, JokesListActivity.class);
                intent.putExtra("image", "relationship");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        startAppAd.onBackPressed();
        super.onBackPressed();
    }

    @Override
    public void onResume() {
        super.onResume();
        startAppAd.onResume();
    }


}
