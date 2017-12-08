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


    //JUST AN EASY WAY OF CALLING PRINTLN
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

    String two_compl_retriever(String binary){

        String text;
        String[] binary_arr = binary.split("");

        text = "";
        for (int i = 0; i< binary_arr.length; i++){
            if (binary_arr[i].equals("1")){
                text += "0";
            }else if (binary_arr[i].equals("0")){
                text += "1";
            }
        }
        //print("text "+text);

        //MAKING THE RESULT TO BE SUMMED +1
        //CREATING AN INSTANCE OF SYS_OPERATIONS
        Sys_operations sys = new Sys_operations();

        //print("Inverse code "+text);
        //print(sys.add(text, "1"));
        return sys.add(text, "1");
    }

    //THIS METHOD FINDS THE CORRECT BITS BASED ON THE SIZE OF THE BIGGEST PARAMETER LENGTH.
    //IF BIGGEST VALUE IS SMALLER THAN 8, THEN BITS = 8; IF SMALLER THAN 16, THEN 16.
    //GENERAL FORMULAE: IF BIGGEST <= 2^I THEN bits = 2^I
    public int bit_set(int biggest){
        int bits = 0 ;
        for (int i = 0; i<Math.pow(2,10); i++){// STOP = 1024
            if (biggest < Math.pow(2,i)){// IF FINDS BIGGEST SMALLER THAN 2^I
                bits = (int)Math.pow(2,i);//ASSGIN THE VALUE
                i = (int)Math.pow(2,10);//BREAKS THE LOOP
            }
        }
        
        return bits;
    }


    //METHOD FOR FIDING THE BIGGEST PARAMETER LENGTH
    public int b_length(String a, String b){
        int biggest;
        if (a.length() >= b. length()){
            biggest = a.length();
        }else{
            biggest = b.length();
        }
        return biggest;
    }
}
