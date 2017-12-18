package com.jetbrains;

public class Operations{
    void sum (String a, String b){
        Auxiliar aux = new Auxiliar();
        boolean doub = aux.is_double(a);
        int carry_up = 0;

        //THE INDEX OF THE DOT WILL BE RETRIEVED FOR LATER ON PUTTING IT BACK IN.
        int dot_index = aux.places_after_dot(a);


        String[] arr_a;
        String[] arr_b;

        /*
        * IF A IS DOUBLE, THEN B IS. BECAUSE THE PARAMETERS ARE EXTERNALLY FIXED BEFORE THIS METHOD IS FIRED.
        * WE WILL GET RID OF THE DOT, CARRY OUT THE ADDITION AND THEN WE WILL PUT THE DOT BACK IN
        * ALL OF THIS WILL BE DONE BY THE METHODS IN THE AUXILIAR CLASS
        * */
        if(aux.is_double(a)){
            a = aux.dot_deletion(a);
            b = aux.dot_deletion(b);

            arr_a = a.split("");
            arr_b = b.split("");

        }else{
            arr_a = a.split("");
            arr_b = b.split("");
        }

        //CARRYING OUT THE ADDITION

        String result = "";
        for (int i = arr_a.length-1; i >=0; i--) {

            if(carry_up ==1){

                if (arr_a[i].equals(arr_b[i])){
                    if (arr_a[i].equals("0")){
                        result += "1";
                        carry_up = 0;
                    }else if (arr_a[i].equals("1")){
                        result += "1";
                        carry_up = 1;
                    }

                }else{
                    result += "0";
                    carry_up = 1;
                }
            }else if (carry_up == 0){
                if (arr_a[i].equals(arr_b[i])){
                    if (arr_a[i].equals("0")){
                        result += "0";
                        carry_up = 0;
                    }else if (arr_a[i].equals("1")){
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
        //INVERTING THE RESULT, CAUSE THE WAY IT WAS PROGRAMMED, THE RESULT IS GIVEN BACKWARDS.
        result = aux.inverter(result);

        /*
        * IF A WAS ORIGINALLY DOUBLE, WE HAVE TO PUT THE DOT BACK IN THE STRING
        * WITH YOUR RESPECTIVE INDEX
        * */
        if (doub){
            result = aux.dot_insertion(result, dot_index);
        }

        //BEFORE PRINTING THE RESULT, WE SHOULD FIX THE EXCESSIVE ZEROS, IF IT HAS
        result = aux.num_adjuster(result);

        //RETRIEVING THE RESULT IN A CORRECT BITS CATEGORY: 2^N
        String resul_bits = aux.n_bits(result);

        //FINALLY PRINTING THE RESULT
        aux.print("Result: "+ result);
        aux.print("Result in "+resul_bits.split("\\.")[0].length()+" bits: "+resul_bits);
    }
    void sub (String a, String b){}
    void mult(String a, String b){}
    void dev (String a, String b){}

    //CONVERTIONS
    void bin_to_dec(String number){}
    void dec_to_bin(String number){}
}
