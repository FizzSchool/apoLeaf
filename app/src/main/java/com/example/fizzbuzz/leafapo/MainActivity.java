package com.example.fizzbuzz.leafapo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fizzbuzz.leafapo.com.content.ApoPage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

    private GestureDetectorCompat mDetector;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private ArrayList<ApoPage> apoPages;
    private int currentPage = 0;

    // image view defination

    private ImageView imageView;
    private TextView textView;
    private LinearLayout textLayout;
    private RelativeLayout imgLayout;
    private boolean swipeDirection;

    // type face
    private Typeface typeface;

    //
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // set mDetector
        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
        mDetector.setIsLongpressEnabled(true);

        // set Data
        ApoData apoData = new ApoData();
        apoPages = apoData.getApoPages();

        // set font
        textView = (TextView) findViewById(R.id.textContent);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/font.ttf");
        textView.setTypeface(typeface);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.music_7orange);
        mediaPlayer.seekTo(30000);

        mediaPlayer.start();

        // set
        this.imageView = (ImageView) findViewById(R.id.apoImage);
        this.textLayout = (LinearLayout) findViewById(R.id.textLayout);
        this.imgLayout = (RelativeLayout) findViewById(R.id.imgLayout);
        textLayout.setBackgroundColor(Color.parseColor(apoPages.get(0).getBackgroundText()));
        imgLayout.setBackgroundColor(Color.parseColor(apoPages.get(0).getBackgroundImage()));
        textView.setTextColor(Color.parseColor(apoPages.get(0).getTextColor()));
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
        if ( this.handler != null ){
            this.handler.removeCallbacksAndMessages(null);
        }
        // get animation
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out_left_swipe);
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
                this.replace();
                MainActivity.this.textView.setVisibility(View.VISIBLE);

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
                MainActivity.this.imageView.startAnimation(fadeInSwipe);
            }

            public void replace(){

                // replace background for text content
                MainActivity.this.textLayout.setBackgroundColor(Color.parseColor(MainActivity.this.apoPages.get(MainActivity.this.currentPage).getBackgroundText()));
                // relplace background for image content
                MainActivity.this.imgLayout.setBackgroundColor(Color.parseColor(MainActivity.this.apoPages.get(MainActivity.this.currentPage).getBackgroundImage()));
                // replace text color
                MainActivity.this.textView.setTextColor(Color.parseColor(MainActivity.this.apoPages.get(MainActivity.this.currentPage).getTextColor()));
                // replace text

                // replace image
                int imageId = MainActivity.this.apoPages.get(MainActivity.this.currentPage).getImage();
                MainActivity.this.imageView.setImageResource(imageId);
            }

            public void switchPage(){
                if(MainActivity.this.swipeDirection == false) {
                    MainActivity.this.currentPage++;
                    // reset loop
                    if (MainActivity.this.currentPage == 5) {
                        MainActivity.this.currentPage = 0;
                    }
                } else {
                    MainActivity.this.currentPage--;

                    if (MainActivity.this.currentPage == -1) {
                        MainActivity.this.currentPage = 4;
                    }
                }
            }
        };

        this.textView.setVisibility(View.VISIBLE);
        this.imageView.setVisibility(View.VISIBLE);

        animation.setAnimationListener(animationListener);
        fadeOut.setAnimationListener(animationListener);

        this.textView.startAnimation(animation);
        this.imageView.startAnimation(animation);

        this.imgLayout.startAnimation(fadeOut);
        this.textLayout.startAnimation(fadeOut);
    }
}
