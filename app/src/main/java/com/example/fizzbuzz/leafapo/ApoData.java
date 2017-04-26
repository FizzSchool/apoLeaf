package com.example.fizzbuzz.leafapo;

import com.example.fizzbuzz.leafapo.com.content.ApoPage;

import java.util.ArrayList;

/**
 * Created by Fizz Buzz on 4/14/2017.
 */

public class ApoData {
    private ArrayList<ApoPage> apoPages;

    public ApoData(){
        ArrayList<String> apoContents;
        apoPages = new ArrayList<ApoPage>();

        // data
        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata2");
        apoContents.add("Yokkata3");
        apoContents.add("Yokkata");
        apoPages.add(new ApoPage(apoContents, "7!!", "I hate you", 0, "#000000", "#ffffff", "#ffffff"));


        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata5");

        apoPages.add(new ApoPage(apoContents, "Nandemonaiya", "I hate you", 1, "#ffffff", "#000000", "#000000"));


        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata9");

        apoPages.add(new ApoPage(apoContents, "River flow in you", "I hate you", 2, "#ffffff", "#1D1D1D", "#1D1D1D"));


        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata7");
        apoPages.add(new ApoPage(apoContents, "On rainy day", "I hate you", 3, "#000000", "#A8A8A8", "#A8A8A8"));


        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, "Just A Dream", "I hate you", 4, "#ffffff", "#1A1A1A", "#1A1A1A"));
    }

    public ArrayList<ApoPage> getApoPages() {
        return apoPages;
    }

    public void setApoPages(ArrayList<ApoPage> apoPages) {
        this.apoPages = apoPages;
    }
}
