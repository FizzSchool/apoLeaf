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
        apoPages.add(new ApoPage(apoContents, 0, "#000000", "#ffffff", "#ffffff"));


        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata5");
        apoPages.add(new ApoPage(apoContents, 1, "#000000", "#ffffff", "#ffffff"));


        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata9");
        apoPages.add(new ApoPage(apoContents, 2, "#000000", "#ffffff", "#ffffff"));


        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata7");
        apoPages.add(new ApoPage(apoContents, 3, "#000000", "#ffffff", "#ffffff"));


        apoContents = new ArrayList<String>();
        apoContents.add("Komenazai");
        apoContents.add("Yokkata");
        apoContents.add("Yokkata18");
        apoPages.add(new ApoPage(apoContents, 4, "#ffffff", "#000000", "#000000"));
    }

    public ArrayList<ApoPage> getApoPages() {
        return apoPages;
    }

    public void setApoPages(ArrayList<ApoPage> apoPages) {
        this.apoPages = apoPages;
    }
}
