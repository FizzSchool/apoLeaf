package com.example.fizzbuzz.leafapo.com.helper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Fizz Buzz on 4/30/2017.
 */

public class Lyric {
    private String temp;

    private ArrayList<String> lyrics;

    private int duration;

    private int position;

    /*public static void main(String[] args){

        String s = "君のいない世界にも　何かの意味はきっとあって sdf";
        System.out.print(s.replaceAll((char) 12288+ "", ""));
    }*/
    public Lyric(String temp,  int position) {
        this.temp = temp;
        this.position = position;
        lyrics = seperateLyric();
    }

    private ArrayList<String> seperateLyric(){
        String[] tokens = this.temp.split("\\|");
        tokens[0] = Check.normalize(tokens[0]);
        return new ArrayList<String>(Arrays.asList(tokens));
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public ArrayList<String> getLyrics() {
        return lyrics;
    }

    public void setLyrics(ArrayList<String> lyrics) {
        this.lyrics = lyrics;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
