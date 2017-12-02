package com.jetbrains;

public class Sys_operations extends System_{



    //METHOD FOR CARRYING OUT THE ADDITION OF BINARY NUMBERS

    public String add(String a, String b){

        int bits;

        if (a.length()>b.length()){
            if (a.length() <= 8){
                bits = 8;
            }else if(a.length() <= 16){
                bits = 16;
            }
            else if (a.length() <= 24){
                bits = 24;
            } else {
                bits = 32;
            }
        }else{
            if (b.length() <= 8){
                bits = 8;
            }else if(b.length() <= 16){
                bits = 16;
            }
            else if (b.length() <= 24){
                bits = 24;
            } else {
                bits = 32;
            }
        }



        //print(bits);
        a = str_mult("0", bits-a.length())+a;
        b = str_mult("0", bits-b.length())+b;
        //print(a);
        //print(b);

        String[] a_arr = a.split("");
        String[] b_arr = b.split("");


        int bring_up = 0;
        String result = "";
        for (int i = a_arr.length-1; i >=0; i--) {

            if(bring_up ==1){

                if (a_arr[i].equals(b_arr[i])){
                    if (a_arr[i].equals("0")){
                        result += "1";
                        bring_up = 0;
                    }else if (a_arr[i].equals("1")){
                        result += "1";
                        bring_up = 1;
                    }

                }else{
                    result += "0";
                    bring_up = 1;
                }
            }else if (bring_up == 0){
                if (a_arr[i].equals(b_arr[i])){
                    if (a_arr[i].equals("0")){
                        result += "0";
                        bring_up = 0;
                    }else if (a_arr[i].equals("1")){
                        result += "0";
                        bring_up = 1;
                    }
                }else{
                    result += "1";
                    bring_up = 0;
                }
            }

        }

        //ADDING THAT EXTRA BIT IN CASE THE CARRY UP IS ONE AND IT HAS RUN OUT OF DIGITS
        if (bring_up == 1){
            result += "1";
        }


        //print(a);
        //print(b);
        //print(inverter(result));
        return inverter(result);
    }

    //THIS METHOD IS FOR CARRYING OUT THE SUBTRACTION OF THE NUMBERS
    //USING THE 2'S COMPLEMENT CONCEPT
    public String sub(String a, String b){
        //print(two_compl_retriever(a));

        //AJUSTING THEIR BITS
        int bits;

        if (a.length()>b.length()){
            if (a.length() <= 8){
                bits = 8;
            }else if(a.length() <= 16){
                bits = 16;
            }
            else if (a.length() <= 24){
                bits = 24;
            } else {
                bits = 32;
            }
        }else{
            if (b.length() <= 8){
                bits = 8;
            }else if(b.length() <= 16){
                bits = 16;
            }
            else if (b.length() <= 24){
                bits = 24;
            } else {
                bits = 32;
            }
        }

        // REARRANGING PARAMETERS
        a = str_mult("0", bits-a.length())+a;

        b = two_compl_retriever(str_mult("0", bits-b.length())+b);

        String result;

        print("a "+a);
        print("b " +b);

        result = add(a, b);

        //GETTING RID OF THE 1'S OF THE RESULT

        return result;
    }
}
