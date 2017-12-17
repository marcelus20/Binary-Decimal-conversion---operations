package com.jetbrains;

public class Operations{
    void sum (String a, String b){
        Auxiliar aux = new Auxiliar();
        int carry_up = 0;
        int index;
        /*
        * IF A IS DOUBLE, THEN B IS ALSO DOUBLE, AS THIS STEP WAS FIXED ON THE APPLICATION AD_BIN()
        * */
        if(aux.is_double(a)){
            //GETTING RID OF THE DOT:
            String[] arr_a_integer = (a.split("\\.")[0]+a.split("\\.")[1]).split("");
            String[] arr_b_integer = (a.split("\\.")[0]+a.split("\\.")[1]).split("");

            //RETRIEVING INDEX OF THE DOT FOR LATER ON PUTIING IT BACK THERE
            //THE INDEX STANDS FOR MOVING BACKWARDS, SO IF INDEX IS 5, ACTUALLY IT IS THE END OF STRING MOVING
            //BACKWARDS 5 DECIMAL PLACES.
            index = aux.dot_index(a);
            aux.print(index);

            //DECIMAL DEALING FOR:

            String result = "";
            for (int i = arr_a_integer.length-1; i >=0; i--) {

                if(carry_up ==1){

                    if (arr_a_integer[i].equals(arr_b_integer[i])){
                        if (arr_a_integer[i].equals("0")){
                            result += "1";
                            carry_up = 0;
                        }else if (arr_a_integer[i].equals("1")){
                            result += "1";
                            carry_up = 1;
                        }

                    }else{
                        result += "0";
                        carry_up = 1;
                    }
                }else if (carry_up == 0){
                    if (arr_a_integer[i].equals(arr_b_integer[i])){
                        if (arr_a_integer[i].equals("0")){
                            result += "0";
                            carry_up = 0;
                        }else if (arr_a_integer[i].equals("1")){
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

            //IT IS REQUIRED TO INVERT THE STRING TO RETRIEVE THE CORRECT RESULT
            result = aux.inverter(result);

            aux.print(result);
        }









    }
    void sub (String a, String b){}
    void mult(String a, String b){}
    void dev (String a, String b){}

    //CONVERTIONS
    void bin_to_dec(String number){}
    void dec_to_bin(String number){}
}
