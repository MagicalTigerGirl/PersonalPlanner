package com.example.personalplanner.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.personalplanner.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_logo)
                .setCover(R.drawable.wallpaper)
                .setName(getResources().getString(R.string.aboutUsName))
                .setSubTitle(getResources().getString(R.string.aboutUsSubtitle))
                .setBrief(getResources().getString(R.string.aboutUsBrief))
                .setAppIcon(R.mipmap.ic_logo)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("")
                .addGitHubLink("https://github.com/MagicalTigerGirl")
                .addFacebookLink("")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        setContentView(view);
    }
}