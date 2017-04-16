package com.example.fizzbuzz.leafapo.com.content;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.widget.ImageView;

import com.example.fizzbuzz.leafapo.MainActivity;
import com.example.fizzbuzz.leafapo.R;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by Fizz Buzz on 4/13/2017.
 */

public class ApoPage {
    private MediaPlayer mediaPlayer;

    private ArrayList<String> apoContents;

    private int image;

    private String backgroundText;

    private String backgroundImage;

    private String textColor;

    public ApoPage( ArrayList<String> apoContents, int imageID, String textColor, String backgroundText, String backgroundImage) {
        int value = getTest("me"+ imageID);
        this.setImage(value);
        this.setBackgroundText(backgroundText);
        this.setTextColor(textColor);
        this.setBackgroundImage(backgroundImage);
        this.setApoContents(apoContents);
    }

    public int getTest(String rs){
        try {
            return R.mipmap.class.getField(rs).getInt(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public ArrayList<String> getApoContents() {
        return apoContents;
    }

    public void setApoContents(ArrayList<String> apoContents) {
        this.apoContents = apoContents;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBackgroundText() {
        return backgroundText;
    }

    public void setBackgroundText(String backgroundText) {
        this.backgroundText = backgroundText;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
}
