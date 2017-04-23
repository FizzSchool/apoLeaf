package com.example.fizzbuzz.leafapo.com.base;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fizzbuzz.leafapo.ApoData;
import com.example.fizzbuzz.leafapo.R;
import com.example.fizzbuzz.leafapo.ScrollViewActivity;
import com.example.fizzbuzz.leafapo.com.content.ApoPage;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {


    // type face
    public Typeface typeface;

    public ArrayList<ApoPage> apoPages;

    public MediaPlayer mediaPlayer1;


    public Handler musicHandler;

    public Menu menuOpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.go, menu);

        this.menuOpt = menu;

        menu.findItem(R.id.action_favorite).getActionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuItem itemChoose = BaseActivity.this.menuOpt.findItem(R.id.action_favorite);
                BaseActivity.this.onOptionsItemSelected(itemChoose);
            }
        });

        SearchView searchView = (SearchView) findViewById(R.id.action_search2);
        searchView.clearFocus();

        /*LinearLayout.LayoutParams mg = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mg.setMargins(0, 0, -20, 0);*/

        return super.onCreateOptionsMenu(menu);

    }

    public void init(){

        // set Data
        ApoData apoData = new ApoData();
        apoPages = apoData.getApoPages();

        typeface = Typeface.createFromAsset(getAssets(), "fonts/font.ttf");

        this.setToolBar();


    }

    public void setToolBar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.search_edit_frame);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.setSearchView();
    }

    public void setSearchView(){
        SearchView searchView = (SearchView) findViewById(R.id.action_search2);
        searchView.setMaxWidth(500);

        EditText editText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        editText.setHintTextColor(Color.parseColor("#1B1B1B"));
        editText.setTypeface(this.typeface);
        editText.setTextSize(14);

        View searchplate = (View) searchView.findViewById(android.support.v7.appcompat.R.id.search_edit_frame);
        searchplate.setBackgroundColor(Color.parseColor("#ffffff"));

        // search view config for greater android version
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            // Do something for lollipop and above versions
            searchplate.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 8);
                    //outline.
                }
            });
            searchplate.setClipToOutline(true);
            searchplate.setElevation(10);
        }

        LinearLayout.LayoutParams mg = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mg.setMargins(0, 0, 10, 10);
        searchplate.setLayoutParams(mg);

        ImageView searchIView = (ImageView) searchView.findViewById(android.support.v7.appcompat.R.id.search_mag_icon);
        searchIView.setImageDrawable(getResources().getDrawable(R.drawable.ic_search));
        searchIView.setScaleX((float) 0.7);
        searchIView.setScaleY((float) 0.7);

        searchView.setIconifiedByDefault(false);
        searchView.clearFocus();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_favorite:
                this.showScrollView();
                return true;
            case R.id.action_settings_overr:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showScrollView(){
        Toast.makeText(this, "Test", 200).show();
        Intent intent = new Intent(this, ScrollViewActivity.class);
        stopAction();
        startActivity(intent);
    }

    private void stopAction(){
        if (this.musicHandler != null){
            this.mediaPlayer1.stop();
            this.musicHandler.removeCallbacksAndMessages(null);
            this.mediaPlayer1 = null;
        }
    }

}
