package com.example.fizzbuzz.leafapo;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fizzbuzz.leafapo.com.base.BaseActivity;
import com.example.fizzbuzz.leafapo.com.content.ApoPage;

import java.util.ArrayList;
import java.util.LinkedList;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends BaseActivity
        implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

    private GestureDetectorCompat mDetector;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private int currentPage = 0;

    // image view defination

    private GifImageView gifImageView;
    private TextView textView;
    private LinearLayout textLayout;
    private RelativeLayout imgLayout;
    private boolean swipeDirection;
    private boolean hasSwipe;

    public int currentLyric = 0;

    //
    private LinkedList<Handler> handlers = new LinkedList<Handler>();
    // music player
    private MediaPlayer mediaPlayer2;

    private Typeface lyricTf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.lyricTf = Typeface.createFromAsset(getAssets(), "fonts/dining_m.ttf");

        // set mDetector
        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
        mDetector.setIsLongpressEnabled(true);



        TextView page = (TextView) findViewById(R.id.page);
        page.setTypeface(this.typeface);
        TextView pageNumber = (TextView) findViewById(R.id.pageNumber);
        pageNumber.setTypeface(this.typeface);

        // when it has intent request
        Intent intent = getIntent();
        int jump = intent.getIntExtra("jump", -999);
        if(jump != -999){

            // set font
            textView = (TextView) findViewById(R.id.textContent);
            textView.setTypeface(typeface);
            textView.setText("");

            TextView lyricView = (TextView) findViewById(R.id.subLrcTv);
            lyricView.setTypeface(typeface);
            lyricView.setTextSize(12);
            lyricView.setTextColor(Color.parseColor("#ffffff"));
            lyricView.setText("");



            // set
            this.gifImageView = (GifImageView) findViewById(R.id.apoImage);
            this.textLayout = (LinearLayout) findViewById(R.id.textLayout);
            this.imgLayout = (RelativeLayout) findViewById(R.id.imgLayout);

            textLayout.setBackgroundColor(Color.parseColor(apoPages.get(3).getBackgroundText()));
            imgLayout.setBackgroundColor(Color.parseColor(apoPages.get(3).getBackgroundImage()));
            textView.setTextColor(Color.parseColor(apoPages.get(3).getTextColor()));

            TextView lyric = (TextView) findViewById(R.id.lyric);
            lyric.setTypeface(lyricTf);

            this.swipeDirection = false;


            this.currentPage = jump - 2;
            this.onStartNewPage();
        } else {
            // set font
            textView = (TextView) findViewById(R.id.textContent);
            TextView lyricView = (TextView) findViewById(R.id.subLrcTv);

            textView.setTypeface(typeface);
            lyricView.setTypeface(typeface);
            lyricView.setTextSize(12);
            lyricView.setTextColor(Color.parseColor("#ffffff"));



            // set
            this.gifImageView = (GifImageView) findViewById(R.id.apoImage);
            this.textLayout = (LinearLayout) findViewById(R.id.textLayout);
            this.imgLayout = (RelativeLayout) findViewById(R.id.imgLayout);

            textLayout.setBackgroundColor(Color.parseColor(apoPages.get(3).getBackgroundText()));
            imgLayout.setBackgroundColor(Color.parseColor(apoPages.get(3).getBackgroundImage()));
            textView.setTextColor(Color.parseColor(apoPages.get(3).getTextColor()));

            TextView lyric = (TextView) findViewById(R.id.lyric);
            lyric.setTypeface(lyricTf);
            mediaPlayer1 = MediaPlayer.create(this, R.raw.nandemonai_ya);
            //mediaPlayer1.seekTo(30000);
            this.showLyric();
            fadeIn(3000);
        }
    }

    public void showLyric(){
        //empty lyric
        RelativeLayout japaneseLayout = (RelativeLayout) findViewById(R.id.japaneseLyric);
        japaneseLayout.removeAllViews();

        TextView subLyricTv = (TextView) findViewById(R.id.subLrcTv);
        subLyricTv.setText("");


        // if no lyric found
        if(MainActivity.this.apoPages.get(currentPage).getLyrics() == null){
            return;
        }

        this.lyricHandler = new Handler();

        class Lyric implements Runnable{
            @Override
            public synchronized void run() {
                MainActivity.this.lyricHandler.postDelayed(this, 1);
                int sizeLyrics = MainActivity.this.apoPages.get(MainActivity.this.currentPage).getLyrics().size();
                if(MainActivity.this.currentLyric >= sizeLyrics){
                    MainActivity.this.lyricHandler.removeCallbacksAndMessages(null);
                    return;
                }
                int currentPosition = MainActivity.this.mediaPlayer1.getCurrentPosition();
                int lyricPosition = MainActivity.this.apoPages.get(MainActivity.this.currentPage).getLyrics().get(MainActivity.this.currentLyric).getPosition();
                String currentLyric = MainActivity.this.apoPages.get(MainActivity.this.currentPage).getLyrics().get(MainActivity.this.currentLyric).getLyrics().get(0);
                String subLyric = "";
                int currentLyricSize = MainActivity.this.apoPages.get(MainActivity.this.currentPage).getLyrics().get(MainActivity.this.currentLyric).getLyrics().size();

                if ( 1 < currentLyricSize){
                    subLyric = MainActivity.this.apoPages.get(MainActivity.this.currentPage).getLyrics().get(MainActivity.this.currentLyric).getLyrics().get(1);
                }

                // show lyric at when meet position
                if (currentPosition <= lyricPosition + 20 && currentPosition >= lyricPosition - 20 ){
                    MainActivity.this.currentLyric ++;
                    RelativeLayout japaneseLayout = (RelativeLayout) findViewById(R.id.japaneseLyric);
                    japaneseLayout.removeAllViews();

                    for (int i=0; i< currentLyric.length(); i+= 5){

                        TextView newTv = new TextView(MainActivity.this);
                        newTv.setText( currentLyric.substring(i, Math.min(i+5, currentLyric.length())));
                        newTv.setTypeface(MainActivity.this.lyricTf, Typeface.BOLD);
                        newTv.setTextSize(25);
                        newTv.setTextColor(Color.parseColor("#ffffff"));

                        RelativeLayout.LayoutParams newTvWidth = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        newTvWidth.width = 70;
                        newTvWidth.setMargins(0, 5, 40* (i+1)/3, 0);
                        newTvWidth.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        newTv.setLayoutParams(newTvWidth);
                        japaneseLayout.addView(newTv);
                    }

                    TextView subLyricTv = (TextView) findViewById(R.id.subLrcTv);
                    subLyricTv.setText(subLyric);

                }
            }
        }

        MainActivity.this.lyricHandler.postDelayed(new Lyric(), 0);
    }


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
                this.hasSwipe = true;
                this.swipeDirection = false;
            }
            // left to right swipe
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                this.hasSwipe = true;
                this.swipeDirection = true;
            }
            onStartNewPage();
        } catch (Exception e) {

        }
        return false;
    }

    /**
     * swipe left or right event change
     */
    public void onStartNewPage() {
        if (this.lyricHandler != null){
            this.lyricHandler.removeCallbacksAndMessages(null);
        }
        if( this.musicHandler != null){
            this.musicHandler.removeCallbacksAndMessages(null);
        }

        if (MainActivity.this.lyricHandler != null){
            MainActivity.this.lyricHandler.removeCallbacksAndMessages(null);
        }

        if(this.mediaPlayer1 != null ){
            if (this.mediaFadeOut == false){
                fadeOut(2000);
                this.mediaFadeOut = true;
            } else {
                this.mediaPlayer1.stop();
                this.mediaPlayer1 = null;
                this.mediaFadeOut = false;
            }
        }
        // stop text  animation

        if (MainActivity.this.handlers.size() != 0){
            for (int i = 0; i < MainActivity.this.handlers.size(); i++) {
                MainActivity.this.handlers.get(i).removeCallbacksAndMessages(null);
            }
            MainActivity.this.handlers = new LinkedList<Handler>();
        }
        // detect left or right animation
        this.change();
    }

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

    public void change(){
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
                this.init();
                this.switchPage();
                this.checkDirectionAnim();
                this.replace();

                MainActivity.this.textLayout.setVisibility(View.VISIBLE);
                //MainActivity.this.textLayout.setPadding(0, 50, 0, 0);

                MainActivity.this.textLayout.startAnimation(fadeIn);

                MainActivity.this.imgLayout.setVisibility(View.VISIBLE);
                MainActivity.this.imgLayout.startAnimation(fadeIn);
                // show image after animation end
                imageDisplay();

                MainActivity.this.textLayout.removeAllViews();
                if (MainActivity.this.handlers.size() != 0){
                    for (int i = 0; i < MainActivity.this.handlers.size(); i++) {
                        MainActivity.this.handlers.get(i).removeCallbacksAndMessages(null);
                    }
                    MainActivity.this.handlers = new LinkedList<Handler>();
                }

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
                                newTextView.setTextSize(12);
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
                    Handler newContentHandler = new Handler();
                    MainActivity.this.handlers.add(newContentHandler);

                    displayApoContent ac =  new displayApoContent(i, MainActivity.this.handlers.getLast());
                    MainActivity.this.handlers.getLast().postDelayed(ac, i*3000);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}

            public void init(){
                MainActivity.this.currentLyric = 0;
            }
            /**
             * show image
             */
            public void imageDisplay(){
                MainActivity.this.gifImageView.startAnimation(fadeInSwipe);
            }

            public void replace(){
                if (MainActivity.this.musicHandler != null){
                    if (MainActivity.this.mediaPlayer1 != null){
                        MainActivity.this.mediaPlayer1.stop();
                        MainActivity.this.mediaPlayer1 = null;
                    }
                    MainActivity.this.musicHandler.removeCallbacksAndMessages(null);
                }

                MainActivity.this.mediaPlayer1 = MediaPlayer.create(MainActivity.this, MainActivity.this.apoPages.get(MainActivity.this.currentPage).getMediaPlayer());
                MainActivity.this.fadeIn(2000);
                // replace Lyric
                MainActivity.this.showLyric();
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

                //
                MainActivity.this.changeStatusBarColor(MainActivity.this.apoPages.get(MainActivity.this.currentPage).getBackgroundImage());
                //
                //MainActivity.this.setPageColor(MainActivity.this.apoPages.get(MainActivity.this.currentPage).getPageNoteLayoutColor(), "#ffffff");
                TextView pageNumber = (TextView) findViewById(R.id.pageNumber);
                pageNumber.setText((MainActivity.this.currentPage+1) + "");
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
                    if (MainActivity.this.currentPage == 26) {
                        MainActivity.this.currentPage = 0;
                    }
                } else if(MainActivity.this.swipeDirection == true){
                    MainActivity.this.currentPage--;

                    if (MainActivity.this.currentPage == -1) {
                        MainActivity.this.currentPage = 25;
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


    public void setPageColor(String pageLayoutColor, String numberColor){
        LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.getDrawable(this, R.drawable.background_page_note);
        GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.pageNoteColor);
        gradientDrawable.setColor(Color.parseColor(pageLayoutColor));
        //Toast.makeText(this, gradientDrawable.getColor().toString(), 5000).show();

        LinearLayout pageNoteLayout = (LinearLayout) findViewById(R.id.pageNoteLayout);
        pageNoteLayout.setBackground((Drawable) layerDrawable);

        //Toast.makeText(MainActivity.this, MainActivity.this.apoPages.get(MainActivity.this.currentPage).getBackgroundImage(), 3000).show();
        TextView page = (TextView) findViewById(R.id.page);
        page.setTextColor(Color.parseColor(numberColor));
        TextView pageNumber = (TextView) findViewById(R.id.pageNumber);
        pageNumber.setTextColor(Color.parseColor(numberColor));
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
