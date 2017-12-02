package com.jetbrains;

public class System_ {

    ///METHOD FOR MULTIPLYING STRINGS
    String str_mult(String str, int times){
        String text = "";
        for (int i = 0; i <times; i++){
            text += str;
        }
        return text;
    }


    //JUST A EASY WAY OF CALLING PRINTLN
    void print(Object a){
        System.out.println(a);
    }

    //METHOD TO CARRY OUT THE INVERSION OF STRINGS:
    String inverter(String str){
        String text =  "";
        String[] str_arr = str.split("");

        for (int i = str_arr.length-1; i>=0; i--){
            text += str_arr[i];
        }

        return text;
    }
}
