package com.jetbrains;

public class System_controller {


    String g_bin = "";
    String g_bin_deci = "";


    //DECIMAL TO BINARY CONVERTER CODE
    String to_binary(double b){
        String integer = String.valueOf(b).split(".")[0];
        String decimal = String.valueOf(b).split(".")[1];
        int a = Integer.valueOf(integer);
        Double b = Double.valueOf(decimal);
        print(a);
        print(b);
        String binary="";
        String decimal_bi = g_bin_deci;
        regression(a);
        regression_decimal(b);

        print(g_bin);
        //FOR FOR INVERTING THE STRING
        for (int i = g_bin.length(); i>0; i--){
            binary += g_bin.split("")[i-1];
        }
        print(binary);
        print(decimal_bi);
        return binary;

    }
    int regression(int a){
        if (a==0){

            return 1;
        }else{
            g_bin += String.valueOf(a%2);
            return regression((int) Math.floor(a/2));
        }

    }
    double regression_decimal(Double a){
        if(a*2 != 1.0 && g_bin_deci.length() != 6){
            return 1;
        }else{
            g_bin_deci += String.valueOf(a*2);
            return regression_decimal(a*2);
        }
    }






    //JUST A EASY WAY OF CALLING PRINTLN
    void print(Object a){
        System.out.println(a);
    }


    ///THE METHOD FOR ADDING ZEROS IN A 8 OR 16 BITS STRINGS IS DONE
    String str_mult(String str, int times){
        String text = "";
        for (int i = 0; i <times; i++){
            text += str;
        }
        return text;
    }
}
