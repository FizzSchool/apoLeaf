package com.example.fizzbuzz.leafapo.com.helper;

/**
 * Created by Fizz Buzz on 4/28/2017.
 */

public class Check {
    public static boolean checkQuery(String query, int bound){
        if ( Integer.parseInt(query)  <= bound && Integer.parseInt(query) > 1){
            return true;
        } else
            return false;
    }

    public static String normalize(String s){
        //s.replace((char) 12288, "");
        //s.re
        s = s.replaceAll((char) 12288+ "", "");
        s = s.replaceAll( "\\s", "");
        return s;
    }
}
