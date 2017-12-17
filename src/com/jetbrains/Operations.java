package com.jetbrains;

public class Operations{
    void sum (String a, String b){
        Auxiliar aux = new Auxiliar();
        int carry_up = 0;
        int index = 0;
        String a_temp;
        String b_temp;

        String[] arr_a;
        String[] arr_b;

        if(aux.is_double(a)){
            a_temp = a.split("\\.")[0]+a.split("\\.")[1];
            b_temp = b.split("\\.")[0]+b.split("\\.")[1];
            index = aux.places_after_dot(a);
            aux.print(a);
            aux.print(b);
            arr_a = a_temp.split("");
            arr_b = b_temp.split("");

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
        result = aux.inverter(result);
        if (aux.is_double(a)){
            result = aux.dot_insertion(a, index);
        }
        aux.print(result);



        }










    void sub (String a, String b){}
    void mult(String a, String b){}
    void dev (String a, String b){}

    //CONVERTIONS
    void bin_to_dec(String number){}
    void dec_to_bin(String number){}
}
