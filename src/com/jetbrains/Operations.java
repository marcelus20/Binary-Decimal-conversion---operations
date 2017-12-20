package com.jetbrains;

public class Operations{
    String sum (String a, String b){
        Auxiliar aux = new Auxiliar();
        boolean doub = aux.is_double(a);
        int carry_up = 0;

        //THE INDEX OF THE DOT WILL BE RETRIEVED FOR LATER ON PUTTING IT BACK IN.
        int dot_index = aux.places_after_dot(a);


        String[] arr_a,arr_b, tuple;
        tuple = aux.length_settler(a,b);
        a = tuple[0];
        b = tuple[1];



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

        //FINALLY RETURNUNG RESULT
        return result;
    }
    String sub (String a, String b){
        Auxiliar aux = new Auxiliar();
        String result="";

       b = aux.two_comp(b);

        a = aux.length_settler(a,b)[0];
        b = aux.length_settler(a,b)[1];

        result = sum(a,b);

        //GETTING RID OF EXCESSIVE ZEROS
        result = aux.num_adjuster(result);

        //IF RESULT LENGTH IS GRATER THAN A LENTH, THEN THERE IS A CARRY OVER. THIS FOR WILL GET RID OF IT
        if(result.length()>a.length()){
            String[] result_arr = result.split("");
            String result2 = "";

            for(int i = 1; i<result_arr.length; i++){
                result2 += result_arr[i];
            }
            result2 = aux.num_adjuster(result2);
            return result2;
        }

        //aux.print(result);

        return result;
    }
    String mult(String a, String b){
        Auxiliar aux = new Auxiliar();
        String result, result_;
        int dot_index = 0;
        boolean is_double = false;
        String[] arr_a, arr_b;
        arr_a = a.split("");
        arr_b = b.split("");

        if (aux.is_double(a)||aux.is_double(b)){
            is_double = true;
            a = aux.dot_deletion(a);
            b = aux.dot_deletion(b);
            dot_index = -(aux.places_after_dot(a)+aux.places_after_dot(b));
            //aux.print(dot_index);
        }

        result = "0";
        result_ = "";

        int count = 0;
        for (int i = arr_a.length-1; i>=0; i--){
            if(arr_b[i].equals("1")){
                result_ = a+aux.mult_str("0", count);
                result = sum(result, result_);

                count++;
            }else{
                result_ = "0"+aux.mult_str("0", count);
                result = sum(result, result_);
                count++;
            }
        }

        if(is_double){
            result = aux.dot_insertion(result, dot_index);
            return result;
        }
        return result;

    }
    void dev (String a, String b){}

    //CONVERTIONS
    void bin_to_dec(String number){}

    /*
    * FOR CARRYING OUT THE DECIMAL TO BINARY CONVERTION, IT HAS BEEN USED THE OVERLOAD CONCEPTION.
    * AS THE PARAMETER CAN BE EITHER INT OR DOUBLE, I CREATED TWO FUNCTION WITH THE SAME NAME (OVERLOADING)
    * AND FIRST ONE WILL RECEIVE ONLY INT ARGUMENT. IF THERE IS A DOUBLE ARGUMENT IT WILL GO TO THE SECOND.
    * */
    String dec_to_bin(int number){
        Auxiliar aux = new Auxiliar();

        String result = "";

        /*
        * THIS LOOP CARRIES OUT THE CONVERTION.
        * IT FILLS THE VARIABLE RESULT EVERY STEP OF THE LOOP WITH A VALUE 0 OR 1, WHICH IS THE
        * MODULE OF THE NUMBER%2. EVERY LOOP STEP THE NUMBER IS DIMINISHED BY HALF UNTIL IT REACHES 0, WHEN THE
        * LOOP IS BROKEN
        * */
        while (number != 0){
            result += number%2;
            number = number/2;
        }
        //AFTER RESULT IS PROCESSED BY LOOP, WE SHOULD INVERT THE STRING INDEXES
        result = aux.inverter(result);
        //IF THERE IS ANY EXCESSIVE 0'S WE GET RID OF THEM BY USIN THE NUM_ADJUSTER METHOD
        result = aux.num_adjuster(result);
        //AT LAST, WE RETURN THE RESULT;
        return result;
    }
    /*
    * THIS IS THE DECIMAL TO BINARY CONVERTER THAT DEALS WITH THE DOUBLE DECIMAL ARGUMENT.
    * */
    String dec_to_bin(double number){
        Auxiliar aux = new Auxiliar();
        int int_part;
        String int_result, result;
        double doub_part;
        //RETRIEVING JUST THE INTEGER PART AND GETTING ITS CORRESPONDENT BINARY VALUE BY USING THE METHOD ABOVE
        int_part = (int)number;
        int_result = dec_to_bin(int_part);

        //INITIALIZING RESULT WITH AN EMPTY STRING FOR FILLING WITH VALUES LATER ON THE LOOP;
        result = "";

        //INITIALIZING DOUBLE PART WITH A VALUE SMALLER THAN 1, SO NUMBER - INTEGER PART OF THIS NUMBER
        doub_part = number-int_part;

        /*
        * LOOPING FOR FILLING THE RESULT.
        *THE LOOP BREAKS AT DOUB_PART EQUALS TO 1
        * IT MAKES DOUB_PART TIMES 2 AND RETRIEVE JUST THE INTEGER PART AND FILL THE RESULT WITH THIS INTEGER PART
        * WHEN THE LENGTH OF RESULT IS 6, THEN WE MAKE DOUB_PART =1, THEREFORE THE LOOP BREAKS
        * */
        while(doub_part != 1){
            doub_part = doub_part*2;
            if(doub_part>1){
                result += (int)doub_part;
                doub_part = doub_part-1;
            }else{
                result += (int)doub_part;
            }
            if(result.length()>6){
                doub_part = 1;
            }
        }

        //AT LAST WE JOIN ALL STRINGS, THE INT RESULT, THE DOT AND THE DOUBLE RESULT;
        return int_result+"."+result;
    }

}
