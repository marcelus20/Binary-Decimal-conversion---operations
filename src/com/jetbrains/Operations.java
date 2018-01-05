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

        if (aux.is_double(a)||aux.is_double(b)){
            is_double = true;
            dot_index = aux.places_after_dot(a)+aux.places_after_dot(b);
            a = aux.dot_deletion(a);
            b = aux.dot_deletion(b);

            //aux.print(dot_index);
        }

        arr_a = a.split("");
        arr_b = b.split("");

        result = "0";
        result_ = "";

        int count = 0;
        for (int i = arr_a.length-1; i>=0; i--){
            if(arr_b[i].equals("1")){
                result_ = a+aux.mult_str("0", count);
                result = sum(result, result_);
                aux.print("res" + result);


            }
            count++;
        }

        if(is_double){
            result = aux.dot_insertion(result, dot_index);
            return result;
        }
        return result;

    }
    String div(String dividend, String divisor){
        Auxiliar aux = new Auxiliar();

        //ADJUSTING EXCESSIVE ZEROS

        dividend = aux.num_adjuster(dividend);
        divisor = aux.num_adjuster(divisor);

        //IT WILL FIRSTLY CHECK IF BOTH STRINGS ARE EQUALS, IF SO, THEN THE RESULT WILL BE ONE
        if (dividend.equals(divisor)){
            return "1";
        }else{
            String result = "";
            int len_divisor = divisor.length();
            String dividend_slice = aux.range_ar(dividend, 0, len_divisor);

            //CHECKING WHO IS GRATER, WHETHER THIS IS THE DIV_SLICE OR THE DIVISOR
            String grater = aux.whosgrater(dividend_slice, divisor);
            if (dividend_slice.equals(grater)){
                result +="1";
            }else{
                result +="0";
                return result;
            }
            return result;

        }


    }

    //CONVERTIONS

    /*
    * THE BIN_TO_DEC METHOD WILL CHECK IF THE BINARY HAS A BINARY POINT, IF SO, THEN IT WILL TREAT THE CALCULATION
    * SEPERATELY.
    * FOR THE INT PART, IT WILL GO THROUGH THE STRING AND CHECK THE 1'S AND ITS INDEX AND COME TO A RESULT
    * FOR DOUBLE PART, IT WILL SPLIT INT AND DOUBLE, CALCULATES INT, CALCULATE DOUBLE AND THEN JOIN THEM TOGETHER
    * */
    String bin_to_dec(String number){
        Auxiliar aux = new Auxiliar();

        //ARRAYS THAT WILL BE ON THE FOR LOOP
        String[] numb_arr, point_arr;
        //THE 1'S INDEXES AND THE RESULT, BOTH ARE INT
        int index, result;
        result = 0;
        index = 0;

        //HERE IT WILL BE CHECK WHETHER OR NOT THE NUMBER IS DOUBLE.
        if(!aux.is_double(number)){//IF NOT DOUBLE

            //THE INTEGER NUMBER STRING WILL BE TURNED INTO AN ARAY
            numb_arr = number.split("");

            /*THE CALCULATION GOES IN HERE, THIS FOR CHECKS IF THE ELEMENT IN THE STRING IS 1, IF SO,
            *IT WILL SUM THE PREVIOUS VALUE OF RESULT WITH THE 2^INDEX UNTIL THE STRING IS FINISHED.
            *EVERY LOOP STEP, THE INDEX INCREMENTS IN ONE.
            */
            for (int i = numb_arr.length-1; i>=0; i--){
                if(numb_arr[i].equals("1")){
                    result += (int)Math.pow(2,index);
                }
                index++;
            }
            // LAST, RETURN THE VALUE
            return String.valueOf(result);
        }else{//IF DOUBLE
            //THIS VARIABLE REPRESENTS DOUBLE PART INITIALIZING WITH 0.
            double dec_result;
            dec_result = 0;

            //IT WILL BE MADE AN INT PART AND DOUBLE PART, THEY WILL BE TREATED SEPARETEDLY
            String int_part;
            String doub_part;

            //THIS TUPLE WILL STORE BOTH PARTS. INT PART AND DOUBLE PART INTO AN ARRAY. THIS WAY HELPS LATER ON
            //FOR ASSIGNING THE INT PART AND DOUB_PART BASED ON THE TUPLE
            String[] tuple;

            //ASSIGNING VALUES TO THE VARIABLES
            index = -1;
            tuple = number.split("\\.");
            int_part = tuple[0];
            doub_part = tuple[1];

            point_arr = doub_part.split("");

            //AS THE INTEGER PART IS READY, WE JUST NEED TO CALL THIS SAME FUNCTION RECURSIVELY
            //AND STORE THE RESULT INTO THIS VARIABLE
            result = Integer.parseInt(bin_to_dec(int_part));

            //DEALING WITH FLOAT POINT
            /*
            * SAME WITH THE INTEGER PART, BUT INSTEAD OF GOING BACKWORDS, IT GOES FORWARD AND THE INDEXES
            * DECREASE.
            * */
            for (int i = 0; i<point_arr.length; i++){
                if(point_arr[i].equals("1")){
                    dec_result += Math.pow(2,index);
                }
                index--;
            }
            //JOINING THEM TOGETHER
            return String.valueOf(result+dec_result);
        }


    }


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
