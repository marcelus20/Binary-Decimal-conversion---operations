package com.jetbrains;

public class Decimal_to_Binary extends System_ {


    String g_bin = "";
    String g_bin_deci = "";


    //DECIMAL TO BINARY CONVERTER CODE
    String to_binary(double ab){
        int a = inT(ab);
        double b = douB(ab);
        String binary="";
        String decimal_bi;
        regression(a);
        regression_decimal(b);

        //FOR FOR INVERTING THE STRING
        for (int i = g_bin.length(); i>0; i--){
            binary += g_bin.split("")[i-1];
        }
        decimal_bi = g_bin_deci;
        binary += "."+decimal_bi;


        return binary;

    }

    //THIS FUNCTION CONVERTS ONLY INTEGER NUMBERS
    int regression(int a){
        if (a==0){

            return 1;
        }else{
            g_bin += String.valueOf(a%2);
            return regression((int) Math.floor(a/2));
        }

    }

    //CONVERTS ONLY DECIMAL < 1 NUMBERS (DECIMAL PLACES)
    Object regression_decimal(double a){
        if(g_bin_deci.length() == 6){
            return "";
        }else{
            double result = a*2;
            g_bin_deci += String.valueOf(inT(result));
            double remainder = result-(inT(result));
            return regression_decimal(remainder);
        }

    }


    //RETRIEVES ONLY THE INTEGER PART OF THE NUMBER
    int inT(double i){
        return (int)(i);
    }

    //RETRIEVES ONLY THE DECIMAL PLACES OF A NUMBER
    double douB(double d){
        return d - inT(d);
    }

    ///PRINTING NUMBER IN N BITS
    void print_n_bits(String binary, int n){
        int size = binary.split("[.]")[0].length();
        if(n<size){
            n = size;
        }
        binary = str_mult("0",n-size)+binary;
        print(binary);
    }
}

