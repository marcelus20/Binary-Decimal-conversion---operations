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

        String text = "";
        String[] binary_arr = binary.split("");
        for (int i = 0; i< binary_arr.length; i++){
            if (binary_arr[i].equals("1")){
                text += "0";
            }else{
                text += "1";
            }
        }

        //MAKING THE RESULT TO BE SUMMED +1
        //CREATING AN INSTANCE OF SYS_OPERATIONS
        Sys_operations sys = new Sys_operations();

        //print("Inverse code "+text);
        //print("two complement "+sys.add(text, "1"));
        return sys.add(text, "1");
    }
}
