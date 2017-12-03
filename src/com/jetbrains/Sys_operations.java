package com.jetbrains;

public class Sys_operations extends System_{



    //METHOD FOR CARRYING OUT THE ADDITION OF BINARY NUMBERS

    public String add(String a, String b){

        int bits;
        int biggest;

        //FIDING WHO IS THE BIGGEST
        biggest = b_length(a, b);

        //FIDING THE CORRESPONDING BIT VALUE
        bits = bit_set(biggest);

        //print(bits);
        a = str_mult("0", bits-a.length())+a;
        b = str_mult("0", bits-b.length())+b;
        //print(a);
        //print(b);

        //TURNING THEM INTO ARRAYS
        String[] a_arr = a.split("");
        String[] b_arr = b.split("");


        //CARRYING OUT THE ADDITION
        int carry_up = 0;
        String result = "";
        for (int i = a_arr.length-1; i >=0; i--) {

            if(carry_up ==1){

                if (a_arr[i].equals(b_arr[i])){
                    if (a_arr[i].equals("0")){
                        result += "1";
                        carry_up = 0;
                    }else if (a_arr[i].equals("1")){
                        result += "1";
                        carry_up = 1;
                    }

                }else{
                    result += "0";
                    carry_up = 1;
                }
            }else if (carry_up == 0){
                if (a_arr[i].equals(b_arr[i])){
                    if (a_arr[i].equals("0")){
                        result += "0";
                        carry_up = 0;
                    }else if (a_arr[i].equals("1")){
                        result += "0";
                        carry_up = 1;
                    }
                }else{
                    result += "1";
                    carry_up = 0;
                }
            }

        }

        //ADDING THAT EXTRA BIT IN CASE THE CARRY UP IS ONE AND IT HAS RUN OUT OF DIGITS
        if (carry_up == 1){
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
        int biggest;

        biggest = b_length(a, b);

        bits = bit_set(biggest);
        //print(bits);
        b = two_compl_retriever(b);

        // REARRANGING PARAMETERS
        a = str_mult("0", bits - a.length())+a;
        b = str_mult("0", bits - b.length())+b;



        String result;

        //print("a "+a);
        //print("b " +b);

        result = add(a, b);

        //GETTING RID OF THE 1'S OF THE RESULT

        return result;
    }

    //THIS METHOD MULTIPLIES TWO STRINGS BINARY NUMBERS
    public String mult(String a, String b){
        int biggest;
        int bits;
        String[] b_arr;
        String[] a_arr;
        String result;
        String result_;
        int counter;

        //FIDING THE SIZE OF THE BIGGEST LENGTH
        biggest = b_length(a , b);

        //FINDING VALUE OF BITS
        bits = bit_set(biggest);

        // ADJUSTING THEIR BITS/// UPDATING THEIR VALUES
        a = str_mult("0",bits - a.length())+ a;
        b = str_mult("0",bits - b.length())+ b;
        print(a + " x "+b);

        //TURNING PARAMETERS INTO ARRAYS
        a_arr = b.split("");
        b_arr = b.split("");


        result = "";//RESULT EACH STEP OF THE FOR
        result_= "";//ACCUMULATED RESULT.

        counter = 0;


        //CARRYING OUT THE MULTIPLICATION:
        for (int i = b_arr.length-1; i>=0; i--){
            if(b_arr[i].equals("1")){
                result = a+str_mult("0",counter);
                result_ = add(result, result_);
                //print(result_);
            }
            counter++;
        }

        print("answer in "+result_.length()+"bits: "+result_);


        return "";
    }



}



