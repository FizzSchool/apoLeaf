package com.example.fizzbuzz.leafapo;

import com.example.fizzbuzz.leafapo.com.content.ApoPage;

import java.util.ArrayList;

/**
 * Created by Fizz Buzz on 4/14/2017.
 */

public class ApoData {
    private ArrayList<ApoPage> apoPages;

    public ApoData(){
        apoPages = new ArrayList<ApoPage>();

        // data
        apoPages.add(new ApoPage(0, "#000000", "#ffffff", "#ffffff"));

        apoPages.add(new ApoPage(1, "#000000", "#ffffff", "#ffffff"));

        apoPages.add(new ApoPage(2, "#000000", "#ffffff", "#ffffff"));

        apoPages.add(new ApoPage(3, "#000000", "#ffffff", "#ffffff"));

        apoPages.add(new ApoPage(4, "#ffffff", "#000000", "#000000"));
    }

    public ArrayList<ApoPage> getApoPages() {
        return apoPages;
    }

    public void setApoPages(ArrayList<ApoPage> apoPages) {
        this.apoPages = apoPages;
    }
}
