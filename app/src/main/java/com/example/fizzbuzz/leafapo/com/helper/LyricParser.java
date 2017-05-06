package com.example.fizzbuzz.leafapo.com.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Fizz Buzz on 4/30/2017.
 */

public class LyricParser{
    private Context context;

    /*public static void main(String[] args){
        System.out.print(System.getProperty("user.dir"));
        System.out.print(LyricParser.getLyricAndTime());
    }*/

    public LyricParser(Context context){
        this.context = context;
    }

    public ArrayList<Lyric> getLyricAndTime(int id){

        InputStream xmlInputStream = this.context.getResources().openRawResource(id);
        //FileInputStream xmlSource = new FileInputStream(xmlInputStream);
        System.out.print(xmlInputStream.toString());
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder;
        try {
            documentBuilder = fac.newDocumentBuilder();

            Document doc = documentBuilder.parse(xmlInputStream);
            doc.getDocumentURI();
            ArrayList<Lyric> lyrics = new ArrayList<Lyric>();
            for (int i = 0; i< doc.getElementsByTagName("TextSample").getLength(); i++){

                Element ele = (Element) doc.getElementsByTagName("TextSample").item(i);
                int position = splitTime(ele.getAttribute("sampleTime"));
                String temp = ele.getTextContent();

                Lyric lyric = new Lyric(temp, position);
                lyrics.add(lyric);
            }

            return lyrics;
        } catch (Exception e) {
            // This will catch any exception, because they are all descended from Exception
        }

        return null;
    }

    private int splitTime(String time){

        String[] tokens = time.split(":|\\.");
        ArrayList<String> timeSplited = new ArrayList<String>(Arrays.asList(tokens));

        int hourValue     =  Integer.parseInt(timeSplited.get(0)) * 1000 * 60 * 60;

        int minuteValue   =  Integer.parseInt(timeSplited.get(1)) * 1000 * 60;

        int secondValue   =  Integer.parseInt(timeSplited.get(2)) * 1000;

        int mlSecondValue =  Integer.parseInt(timeSplited.get(3));

        return hourValue + minuteValue + secondValue + mlSecondValue;
    }
}
