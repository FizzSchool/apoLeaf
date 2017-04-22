package com.example.fizzbuzz.leafapo;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fizzbuzz.leafapo.com.content.ApoPage;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

    private GestureDetectorCompat mDetector;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private ArrayList<ApoPage> apoPages;
    private int currentPage = 0;

    // image view defination

    private GifImageView gifImageView;
    private TextView textView;
    private LinearLayout textLayout;
    private RelativeLayout imgLayout;
    private boolean swipeDirection;

    // type face
    private Typeface typeface;

    //
    private Handler handler;
    private Handler musicHandler;
    // music player
    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // set font

        textView = (TextView) findViewById(R.id.textContent);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/font.ttf");


        Toolbar myToolbar = (Toolbar) findViewById(R.id.search_edit_frame);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.setSearchView();

        // set mDetector
        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
        mDetector.setIsLongpressEnabled(true);

        // set Data
        ApoData apoData = new ApoData();
        apoPages = apoData.getApoPages();

        textView.setTypeface(typeface);

        mediaPlayer1 = MediaPlayer.create(this, R.raw.music0);
        mediaPlayer1.seekTo(30000);
        fadeIn( 2000);
        //mediaPlayer.start();

        // set
        this.gifImageView = (GifImageView) findViewById(R.id.apoImage);
        this.textLayout = (LinearLayout) findViewById(R.id.textLayout);
        this.imgLayout = (RelativeLayout) findViewById(R.id.imgLayout);
        textLayout.setBackgroundColor(Color.parseColor(apoPages.get(0).getBackgroundText()));
        imgLayout.setBackgroundColor(Color.parseColor(apoPages.get(0).getBackgroundImage()));
        textView.setTextColor(Color.parseColor(apoPages.get(0).getTextColor()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.go, menu);
        return super.onCreateOptionsMenu(menu);
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

        //searchplate.setClipToOutline(false);
        searchView.setIconifiedByDefault(false);
        searchView.clearFocus();

        searchplate.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 8);
            }
        });

        LinearLayout.LayoutParams mg = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mg.setMargins(0, 0, 10, 10);
        searchplate.setLayoutParams(mg);
        searchplate.setClipToOutline(true);

        searchplate.setElevation(10);


        ImageView searchIView = (ImageView) searchView.findViewById(android.support.v7.appcompat.R.id.search_mag_icon);
        searchIView.setImageDrawable(getResources().getDrawable(R.drawable.ic_search));
        searchIView.setScaleX((float) 0.7);
        searchIView.setScaleY((float) 0.7);

    }



    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.group_item1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        //Toast.makeText(getApplicationContext(), "Single Tap", 200).show();
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Toast.makeText(getApplicationContext(), "Doule Tap", 200).show();
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {

        // Toast.makeText(getApplicationContext(), "On down", 200).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH){
                return false;
            }
            // right to left swipe
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                this.swipeDirection = false;
            }
            // left to right swipe
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                this.swipeDirection = true;
            }


            onSwipe();
        } catch (Exception e) {

        }
        return false;
    }

    /**
     * swipe left or right event change
     */
    public void onSwipe() {
        if(this.mediaPlayer1 != null){
            fadeOut( 2000);
        }
        //this.mediaPlayer2 = MediaPlayer.create(this, )
        //fadeIn(this.);
        if ( this.handler != null ){
            this.handler.removeCallbacksAndMessages(null);
        }
        // get animation
        // detect left or right animation

        Animation animation;
        if( this.swipeDirection ==  false){
            animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out_left_swipe);
        } else {
            animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out_right_swipe);
        }

        Animation fadeOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);

        Animation.AnimationListener animationListener = new Animation.AnimationListener() {
            private Animation fadeInSwipe = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in_left_swipe);
            private Animation fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);


            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                this.switchPage();
                this.checkDirectionAnim();
                this.replace();
                //MainActivity.this.textView.setVisibility(View.VISIBLE);

                MainActivity.this.textLayout.setVisibility(View.VISIBLE);
                MainActivity.this.textLayout.setPadding(0, 50, 0, 0);

                MainActivity.this.textLayout.startAnimation(fadeIn);

                MainActivity.this.imgLayout.setVisibility(View.VISIBLE);
                MainActivity.this.imgLayout.startAnimation(fadeIn);
                // show image after animation end
                imageDisplay();

                MainActivity.this.textLayout.removeAllViews();
                for(int i=0; i< MainActivity.this.apoPages.get(MainActivity.this.currentPage).getApoContents().size(); i++) {

                    class displayApoContent implements Runnable {
                        Handler handler;
                        int currentLine;
                        displayApoContent(int currentL, Handler ipHandler){
                            currentLine  = currentL;
                            handler = ipHandler;
                        }
                        @Override
                        public synchronized void run() {
                            TextView newTextView = new TextView(MainActivity.this);
                            if (findViewById(99+ currentLine) != null ){
                                handler.removeCallbacks(this);
                                return;
                            } else {
                                newTextView.setText(MainActivity.this.apoPages.get(MainActivity.this.currentPage).getApoContents().get(currentLine));
                                newTextView.setId(99 + currentLine);
                                newTextView.setTypeface(MainActivity.this.typeface);
                                newTextView.setTextColor(Color.parseColor(MainActivity.this.apoPages.get(MainActivity.this.currentPage).getTextColor()));

                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                params.setMargins(100, 10, 100, 0);
                                newTextView.setLayoutParams(params);

                                MainActivity.this.textLayout.addView(newTextView);
                                TextView foundView = (TextView) findViewById(99+ currentLine);

                                // animation
                                Animation fadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in_left_swipe);
                                foundView.setVisibility(View.VISIBLE);
                                foundView.startAnimation(fadeIn);
                            }

                            handler.removeCallbacks(this);
                            return;
                        }
                    }

                    MainActivity.this.handler = new Handler();
                    displayApoContent ac =  new displayApoContent(i, MainActivity.this.handler);
                    MainActivity.this.handler.postDelayed(ac, i*3000);

                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}

            /**
             * show image
             */
            public void imageDisplay(){
                MainActivity.this.gifImageView.startAnimation(fadeInSwipe);
            }

            public void replace(){
                if (MainActivity.this.musicHandler != null){
                    MainActivity.this.mediaPlayer1.stop();
                    MainActivity.this.musicHandler.removeCallbacksAndMessages(null);
                    MainActivity.this.mediaPlayer1 = null;
                }

                MainActivity.this.mediaPlayer1 = MediaPlayer.create(MainActivity.this, MainActivity.this.apoPages.get(MainActivity.this.currentPage).getMediaPlayer());
                MainActivity.this.fadeIn(2000);
                // replace background for text content
                MainActivity.this.textLayout.setBackgroundColor(Color.parseColor(MainActivity.this.apoPages.get(MainActivity.this.currentPage).getBackgroundText()));
                // relplace background for image content
                MainActivity.this.imgLayout.setBackgroundColor(Color.parseColor(MainActivity.this.apoPages.get(MainActivity.this.currentPage).getBackgroundImage()));
                // replace text color
                //MainActivity.this.textView.setTextColor(Color.parseColor(MainActivity.this.apoPages.get(MainActivity.this.currentPage).getTextColor()));
                // replace text

                // replace image
                int imageId = MainActivity.this.apoPages.get(MainActivity.this.currentPage).getImage();
                MainActivity.this.gifImageView.setImageResource(imageId);
            }

            public void checkDirectionAnim(){
                if(MainActivity.this.swipeDirection == false) {
                    this.fadeInSwipe = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in_left_swipe);
                } else {
                    this.fadeInSwipe = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in_right_swipe);
                }
            }

            public void switchPage(){
                if(MainActivity.this.swipeDirection == false) {
                    MainActivity.this.currentPage++;
                    // reset loop
                    if (MainActivity.this.currentPage == 5) {
                        MainActivity.this.currentPage = 0;
                    }
                } else if(MainActivity.this.swipeDirection == true){
                    MainActivity.this.currentPage--;

                    if (MainActivity.this.currentPage == -1) {
                        MainActivity.this.currentPage = 4;
                    }

                }

                Toast.makeText(MainActivity.this.getApplicationContext(), ""+MainActivity.this.currentPage , 200).show();
            }
        };

        //this.textView.setVisibility(View.VISIBLE);
        this.gifImageView.setVisibility(View.VISIBLE);

        animation.setAnimationListener(animationListener);
        fadeOut.setAnimationListener(animationListener);

        //this.textView.startAnimation(animation);
        this.gifImageView.startAnimation(animation);

        this.imgLayout.startAnimation(fadeOut);
        this.textLayout.startAnimation(fadeOut);
    }

    /*private static void crossFade() {
        fadeOut(currentPlayer, 2000);
        fadeIn(auxPlayer, 2000);
        currentPlayer = auxPlayer;
        auxPlayer = null;
    }*/

    public void fadeOut(int duration) {

        final float deviceVolume = 1;
        musicHandler = new Handler();
        class MusicFadeOut implements Runnable{

            private float time;
            private float duration;
            private float volume = 0.0f;
            private Handler h;

            MusicFadeOut(Handler handler, int duration){
                h = handler;
                time = duration;
                this.duration = duration;
            }
            @Override
            public void run() {
                if (!MainActivity.this.mediaPlayer1.isPlaying())
                    MainActivity.this.mediaPlayer1.start();
                // can call h again after work!
                time -= 100;
                volume = (deviceVolume * time) / this.duration;
                MainActivity.this.mediaPlayer1.setVolume(volume, volume);
                if (time > 0)
                    h.postDelayed(this, 100);
                else {
                    MainActivity.this.mediaPlayer1.stop();
                    MainActivity.this.mediaPlayer1.release();
                    MainActivity.this.mediaPlayer1 = null;
                    h.removeCallbacksAndMessages(null);
                }

            }
        }

        musicHandler.postDelayed(new MusicFadeOut(musicHandler, duration), 100); // 1 second delay (takes millis)


    }

    public  void fadeIn( int duration) {
        final float deviceVolume = 1;
        musicHandler = new Handler();

        class FadeInMusic implements Runnable {
            private float time = 0.0f;
            private float volume = 0.0f;
            private Handler h;
            private float duration;
            FadeInMusic(Handler handler, float duration){
                h = handler;
                this.duration = duration;
            }
            @Override
            public void run() {
                if (!MainActivity.this.mediaPlayer1.isPlaying())
                    MainActivity.this.mediaPlayer1.start();
                // can call h again after work!
                time += 100;
                volume = (deviceVolume * time) / duration;
                MainActivity.this.mediaPlayer1.setVolume(volume, volume);
                if (time < duration)
                    h.postDelayed(this, 100);

                if (time == duration){
                    h.removeCallbacksAndMessages(null);
                }
            }
        }

        musicHandler.postDelayed(new FadeInMusic(musicHandler, duration), 100); // 1 second delay (takes millis)

    }
    /*public static float getDeviceVolume() {
        int volumeLevel = AudioManager.S.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        return (float) volumeLevel / maxVolume;
    }*/
}
