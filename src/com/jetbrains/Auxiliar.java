package com.jetbrains;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
THIS CLASS WAS CREATED TO HELP OPERATE OTHER CLASSES.
IT WILL HAVE METHODS THAT WILL BE CALLED IN OTHER CLASSES

*/
public class Auxiliar extends Operations{

    //THIS FUNTION WILL REPLACE THE system.out.println() method
    void print(Object stuff){
        System.out.println(stuff);
    }


    /*THIS METHOD WILL GET THE NUMBER THE USER TYPES ON KEYBOARD.
    *IT RECEIVES THREE PARAMETERS. THE MSG WILL BE PRINTED TO INVITE THE USER TO
    *TYPE A NUMBER IN. THEN, THE SECOND PARAMETER IS FOR CHECKING IF WHAT WAS TYPED MATCHES THE RREGEX
    *THE THIRD PARAMETER IS A ERROR_MSG TRHOWN WHEN IT DOES NOT MATCH THE REGEX
    **/
    String number_catcher(String msg, String regex, String error_msg){

        String line = "";
        boolean is_number;

        do{
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(msg);
                line = br.readLine();
            }catch(Exception e){}
            if (!line.matches(regex)){
                print(error_msg);
                is_number = false;
            }else{
                is_number = true;
            }
        }while(!is_number);

        return line;
    }


    /*
    *THIS METHOD IS FOR PRINTING THE ARRAYS NICELY, WITH LINES, GRIDS
    * IT WILL RECEIVE AN ARRAY AS A PARAMETER AND WILL PRINT ALL ELEMENTS OF AN ARRAY
    * IN A NICE SHAPE
    * */
    void arr_printer(String[] arr){
        /*
         * NOW, IT WILL BE CHECKED WHAT LENGTH THE ARRAY WILL HAVE BASED ON THE INDEX THAT
         * HAS THE LARGEST STRING LENGTH. THIS FOR LOOP WILL CHECK WHAT INDEX HOLDS THE BIGGEST STRING LENGTH
         */
        int width = 0;
        for (int i = 0; i<arr.length; i++){
            if (arr[i].length()>width){
                width = arr[i].length();
            }
        }
        /*
        * AT THIS POINT, WIDTH IS SET UP, LET'S ADD TWO MORE SPACES IN BOTH SIDES
        * */
        width +=4;

        //LET'S BEGIN THE PRINTING
        print("+"+mult_str("-", width)+"+");
        for (int i = 0; i<arr.length; i++){
            //ARRAGING THE SPACES USING BASED ON THE WIDTH)
            String line_width = mult_str(" ", (width-arr[i].length())/2);
            print("|"+line_width+arr[i]+line_width+"|");
        }
        print("+"+mult_str("-", width)+"+");


    }


    /*THIS METHOD DOES THE SAME AS ARR_PRINTER, THE DIFFERENCE IS THAT, INSTEAD OF CENTRILIZED, IT WI
    *IT WILL PRINT AS AN ORDERED LIST
    */
    void arr_printer_ordered(String[] arr){
        /*
         * NOW, IT WILL BE CHECKED WHAT LENGTH THE ARRAY WILL HAVE BASED ON THE INDEX THAT
         * HAS THE LARGEST STRING LENGTH. THIS FOR LOOP WILL CHECK WHAT INDEX HOLDS THE BIGGEST STRING LENGTH
         */
        int width = 0;
        for (int i = 0; i<arr.length; i++){
            if (arr[i].length()>width){
                width = arr[i].length();
            }
        }
        /*
        * AT THIS POINT, WIDTH IS SET UP, LET'S ADD TWO MORE SPACES IN ONE SIDE
        * */
        width +=2;

        //LET'S BEGIN THE PRINTING
        print("+"+mult_str("-", width+3)+"+");
        for (int i = 0; i<arr.length; i++){
            //ARRAGING THE SPACES USING BASED ON THE WIDTH)
            String line_width = mult_str(" ", width-arr[i].length());
            print("|"+String.valueOf(i+1)+". "+arr[i]+line_width+"|");
        }
        print("+"+mult_str("-", width+3)+"+");


    }


    /*
     *THIS METHOD RETURNS HOW MANY TIMES YOU WANT A STRING TO BE MULTIPLYED
     * FOR EXAMPLE, IF YOU DO mult_str("0", 7), THE RETURN WILL BE "0000000"
     */
    String mult_str(String element, int times){
        String text = "";
        for (int i = 0; i< times; i++){
            text+=element;
        }
        return text;
    }


    /*
    * THIS METHOD WILL REGULATE THE STRING, IF IT BEGIN WITH ZEROS, THEY WILL VANISH
    * IF IT ENDS WITH ZEROS AFTER DECIMAL PLACE, THEY WILL VANISH AS WELL
    * FOR EXAMPLE, IF USER TYPES 000111010.100000, THE OUTPUT WILL BE 111010.1
    * */
    String num_adjuster(String bin){
        //TURNING THIS BINARY STRING INTO AN ARRAY
        String[] arr_bin = bin.split("");

        String new_str = "";
        if (!is_double(bin)){
            int index = 0;

            //CHECKING WHICH INDEX THE THE NUMBER 1 APPEARS FROM LEFT TO RIGHT
            for (int i = 0; i<arr_bin.length; i++){
                if(arr_bin[i].equals("1")){
                    index = i;
                    break;
                }
            }
            //LOOPING FOR FILLING THE NEW STRING VARIABLE WITH THE NUMBER WITHOUT 0 AT THE FRONT
            //THIS WILL BE DONE BASED ON THE INDEX RETRIEVED FROM THE PREVIOUS LOOP
            for (int i = index; i<arr_bin.length; i++){
                new_str += arr_bin[i];
            }
            return new_str;
        }else{
            //IF IT ENDS WITH . GET RID OF .
            if(arr_bin[arr_bin.length-1].equals(".")){
                for (int i = 0; i< arr_bin.length-1; i++){
                    new_str += arr_bin[i];
                }
                //AT THIS POINT, NEW_STR IS NO LONGER DOUBLE, SO CARRY OUT adjuster FUNCTION RECURSIVELY
                new_str = num_adjuster(new_str);
                return new_str;
            }else{
                String integer = bin.split("\\.")[0];
                String decimal = bin.split("\\.")[1];
                String[] arr_decimal = decimal.split("");
                //IF decimal VARIABLE HAS ONLY ZEROS, NUMBER IS JUST INTEGER, SO GET RID OF ZEROS AND DOT
                boolean only_zeros = true;
                int index = 0;
                //THIS FOR WILL CHECK IF THERE "1" IN DECIMAL ARRAY, IF SO, THEN THIS IS A DOUBLE BINARY.
                for (int i = arr_decimal.length-1; i >= 0; i--){
                    if (arr_decimal[i].equals("1")){
                        only_zeros = false;
                        index = i+1;
                        break;
                    }
                }
                /*
                * IF ONLY ZERO IS TRUE, IT MEANS THAT THE NUMBER IS INTEGER, SO IT WILL BE USED JUST THE VARIABLE
                * INTEGER PART OF THE BINARY.
                * IF IT IS FALSE, ONE MORE FOR WILL HAVE TO HAPPEN IN ORDER TO CONCATENATE THE INTEGER PART WITH
                * THE ADJUSTED DECIMAL PART (GETTING RID OF THE EXCESSIVE ZEROS AT THE END IF THERE IS ANY)
                * */
                if(only_zeros){
                    return num_adjuster(integer);
                }else{
                    new_str = integer;
                    new_str = num_adjuster(new_str)+".";
                    for (int i = 0; i< index; i++){
                        new_str +=arr_decimal[i];
                    }
                    return new_str;
                }
            }
        }
    }


    /*
    * THIS METHOD WILL RETURN A BOOLEAN VARIABLE. IT'S FOR CHECKING WHETHER THE BINARY
    * STRING IS DOUBLE OR NOT.
    * */
    boolean is_double(String bin){
        //TURNING BIN INTO AN ARRAY:
        String[] arr_bin = bin.split("");

        //CHECKING FOR POINTS IN THE STRING.
        //IF THERE IS POINT, THEN IT IS DOUBLE
        for(int i = 0; i<arr_bin.length; i++){
            if(arr_bin[i].equals(".") || arr_bin[arr_bin.length-1].equals(".")){
                return true;
            }
        }



    return false;
    }

    /*
    * THIS METHOD WILL MAKE TO BINARY NUMBERS BE SAME LENGTH, FILLING THE SMALL STRING WITH ZEROS UNTIL GETS
    * THE LENGTH OF THE BIGGEST, SO IT WILL RECEIVE TWO PARAMETERS
    * */

    String[] padding_binarries(String a, String b){
        String[] tuple = new String[2];
        int biggest;
        int d_biggest;
        String a_integer = "";
        String a_decimal = "";
        String b_integer = "";
        String b_decimal = "";

        /*
        * WE NEED TO CHECK IF THE BINARY IS DOUBLE, IF SO, THE FILLING WITH ZEROS FOR THE INTEGER PART
        * WILL BE DIFFERENT FOR THE DECIMAL PART. INTEGER THE FILLING WILL BE FROM AT THE START, ON THE
        * OTHER HAND, DECIMAL WILL BE AT THE END
        * */
        if(is_double(a) || is_double(b)){
            //FIXING VARIABLES IN ALL DIFFERENT POSSIBILITIES (3)
            if (is_double(a) && !is_double(b)) {
                //THIS IF WILL FIRE IF A IS DOUBLE AND B IS NOT
                a_integer = a.split("\\.")[0];
                a_decimal = a.split("\\.")[1];
                b_integer = b;
                b_decimal = "0";
            }else if (!is_double(a) && is_double(b)){
                //THIS IF WILL FIRE IF A IS NOT DOUBLE AND B IS
                a_integer = a;
                a_decimal = "0";
                b_integer = b.split("\\.")[0];
                b_decimal = b.split("\\.")[1];
            }else{
                //IT WILL FIRE IF BOTH ARE DOUBLE
                a_integer = a.split("\\.")[0];
                a_decimal = a.split("\\.")[1];
                b_integer = b.split("\\.")[0];
                b_decimal = b.split("\\.")[1];
            }
            //AT THIS POINT, VARIABLES ARE FIXED, SO WE CAN WORK ON FILLING WITH ZEROS
            //CHECKING INTEGER PART
            if(a_integer.length() >= b_integer.length()){
                biggest = a_integer.length();
                //FILLING B WITH ZEROS
                b_integer = mult_str("0",biggest-b_integer.length())+b_integer;
            }else{
                biggest = b_integer.length();
                //FILLING A WITH ZEROS IF A IS SMALLER
                a_integer = mult_str("0",biggest-a_integer.length())+a_integer;
            }
            //CHECKING DECIMAL
            if (a_decimal.length()>=b_decimal.length()){
                d_biggest = a_decimal.length();
                b_decimal = b_decimal + mult_str("0",d_biggest-b_decimal.length());
            }else{
                d_biggest = b_decimal.length();
                a_decimal = a_decimal + mult_str("0",d_biggest-a_decimal.length());
            }
            //JOING BOTH DECIMAL PART AND INTEGER PART WITH THEIR FIXED LENGTHS
            a = a_integer + "." + a_decimal;
            b = b_integer + "." + b_decimal;

        }else{//IF CODE REACHES HERE, IT MEANS THAT BOTH ARE INTEGERS
            //CHECKING WHO IS TE BIGGEST STRING;
            if(a.length()> b.length()){
                biggest = a.length();
                //FILLING B WITH ZEROS USING THE FUNCTION STRING MULTIPLYERS
                b = mult_str("0", biggest-b.length())+b;
            }else if(b.length()> a.length()){
                biggest = b.length();
                //FILLING A WITH ZEROS IF A IS SMALLER
                a = mult_str("0", biggest-a.length())+a;
            }else{

                tuple[0] = a;
                tuple[1] = b;
                return tuple;
            }
        }
        tuple[0] = a;
        tuple[1] = b;
        return tuple;// JAVA DOES NOT SUPPORT TUPLES, SO IT WILL RETURN AN ARRAY INSTEAD
    }

    /*
    * THIS METHOD WILL SIMPLY INVERT THE STRING THAT RECEIVE AS A PARAMETER
    * EG: inverter("abc") -> output is "cba"
    * */
    String inverter(String binary){
        String text = "";
        String[] bin_arr= binary.split("");
        for (int i = bin_arr.length-1; i >= 0; i--){
            text += bin_arr[i];
        }

        return text;
    }

    //THIS METHOD RETRIEVES THE NUMBER OF DECIMAL PLACES OF THE DOT IN A DOUBLE BINARY
    int places_after_dot(String bin){
        int d_places = 0;
        String[] arr_bin = bin.split("");
        for(int i = 0; i < arr_bin.length; i++){
            if(arr_bin[i].equals(".")){
                d_places = arr_bin.length-i;
                break;
            }
        }
        //print(d_places);
        //print(d_places-1);
        return d_places-1;
    }


    //THIS METHOD IS RESPONSIIBLE FOR INSERTING THE DOT INTO A STRING. YOU HAVE TO PASS THE DOT_INDEX AS A PARAMETER
    String dot_insertion(String bin, int index){
        String text = "";
        String[] arr_bin = bin.split("");
        for (int i = 0; i<arr_bin.length; i++){
            text += arr_bin[i];
            if (i == bin.length()-index-1){
                text+=".";
            }
        }
        return text;
    }

    //THIS METHOD WILL DELET DOT FROM A DOUBLE BINARY
    String dot_deletion(String bin){
        return bin.replace(".","");
    }

    /*
    * THIS METHOD WILL ADD A BINARY NUMBER EXTRA ZEROS UNTIL IT HAS REACHED 8 OR 16 OR 2^n BITS
    * DEPENDING ON THE LENGTH OF THE BIN. IF THE BIN HAS LENGTH 5, THE NEXT 2^n, N SHOULD BE 4 THEN 8.
    * EG: n_bits("11101");
    * n_bits("1")
    * n_bits("11111111111")
    * OUTPUT:::
    * "00011101"
    * "01"
    * "0000011111111111"
    *  */
    String n_bits(String bin){
        int bit = 0;
        String bin_integer;

        if(is_double(bin)){
            bin_integer = bin.split("\\.")[0];
            for (int i = 0; i<Math.pow(2,10); i++){
                if(bin_integer.length()>Math.pow(2,i)){
                    bit = (int)Math.pow(2,i+1);
                }
            }
            return mult_str("0",bit-bin_integer.length())+bin_integer + "." + bin.split("\\.")[1];
        }else{
            for (int i = 0; i<Math.pow(2,10); i++){
                if(bin.length()>Math.pow(2,i)){
                    bit = (int)Math.pow(2,i+1);
                }
            }
            return mult_str("0",bit-bin.length())+bin;
        }



    }

    //THIS FUNCTION WILL DO THE TWOS COMPLEMENT OF A BINARY
    String two_comp(String bin){
        String text = "";
        String[] arr_bin = bin.split("");
        for (int i = 0; i< bin.length(); i++){
            if (arr_bin[i].equals("0")){
                text += "1";
            }else{
                text += "0";
            }
        }
        String operand = mult_str("0",text.length()-1)+"1";
        //print(text);
        text = sum(text,operand);
        text = n_bits(text);

        return text;
    }

    //THIS FUNCTION CHANGES THE REPRESENTATION OF THE BINARY NUMBER.
    //IT RECEIVES, FOR EXAMPLE: 1101 AND RETURNS 0b1101.
    String binary_mask(String bin){
        return "0b"+bin;
    }

    //THIS METHOD PRINTS THE CALCULATION STRUCTURE:
    /*
    * EG:    1101
    *      +   10
    *     =======
    *        1110
    * */
    void calc_structure(String a, String b, String operation, String result){
        String[] tuple = padding_binarries(a, b);
        a = "  "+binary_mask(tuple[0]);
        b = " " + binary_mask(tuple[1]);

        print(a);
        print(operation + b);
        print(mult_str("=",a.length()));
        print(" "+binary_mask(result));
    }


    //THIS METHOD PAUSE THE APPLICATION, THE USER HAS TO PRESS ENTER TO CONTINUE THE CODE
    void system_pause(){
        number_catcher("Press enter to continue", "", "");
    }


    //THIS METHOD CHOOSES THE RANGE OF AN ARRAY OR STRING YOU WANT TO MAKE USE OF.
    //IF YOU CAST range_ar("Hello", 0, 2), the return will be "Hel"
    String range_ar(String element, int start, int stop){
        String new_string = "";
        if(stop > element.length()){
            stop = element.length();
        }
        if (start > stop){
            print("Start point can't be grater than stop");
            return element;
        }
        String [] element_arr = element.split("");
        for (int i =start; i< stop; i++){
             new_string += element_arr[i];
        }


        return new_string;
    }


    //THIS METHOD COMPARES WHICH BINARY IS GRATER THAN ANOTHER BASED ON THE VALUE THAT THE STRINGS REPRESENTS
    boolean dividend_is_greater(String dividend, String divisor){
        String grater = "";

        //GETTING RID OF THE EXCESSIVE ZEROS
        dividend = num_adjuster(dividend);
        divisor = num_adjuster(divisor);

        //PADDING THEM:
        String[] tuple = padding_binarries(dividend, divisor);
        dividend = tuple[0];
        divisor = tuple[1];

        if(dividend.equals(divisor)){
            return true;
        }

        //IF THEY ARE EQUAL LENGTH, THEN CHECK THE VALUE THAT THEY REPRESENT
        for(int i = 0; i<dividend.length(); i++){
            if (dividend.charAt(i) == divisor.charAt(i)){
                continue;
            }else{
                if (String.valueOf(dividend.charAt(i)).equals("1")){
                    return true;
                }else{
                    return false;
                }
            }
        }

        return false;
    }

    //THIS SUBTRACTION METHOD IS TO BE SUMMONED AT THE DIVISION OPERATION
    String div_subtraction(String div_slice, String factor){
        /*
        * AS THIS METHOD IS CALLED INTO THE DIVISION OPERATION, THERE WON'T EVER BE A SITUATION THAT
        *DIV_SLICE IS SMALLER THAN FACTOR, SO THE FUNCTION WILL FOLLOW ASSUMING THAT DIV_SLICE IS GRATER
        * */

        //PADDING THEM:
        String[] tuple = padding_binarries(div_slice, factor);
        div_slice = tuple[0];
        factor = tuple[1];
        String result = "";

        String borrow = "0";



        for (int i = div_slice.length()-1; i>=0 ; i--){
            String operand_1 = String.valueOf(div_slice.charAt(i));
            String operand_2 = String.valueOf(factor.charAt(i));

            if (!borrow.equals("0")){
                if(operand_1.equals("0")){
                    operand_1 = "1";
                    borrow = "1";
                }else{
                    operand_1 = "0";
                    borrow = "0";
                }
            }
            if(operand_1.equals("0") && operand_2.equals("0")){
                result += "0";
            }else if(operand_1.equals("1") && operand_2.equals("0")){
                result += "1";
            }else if(operand_1.equals("0") && operand_2.equals("1")){
                result += "1";
                borrow = "1";
            }else if(operand_1.equals("1") && operand_2.equals("1")){
                result += "0";
            }
            //print("Borrow: "+borrow);
            //print("operand: " + operand_1);
            //print("result: " + result);
            //system_pause();
        }


        result = num_adjuster(inverter(result));

        return result;
    }

}

