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
}
