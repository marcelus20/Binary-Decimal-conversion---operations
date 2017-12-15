package com.jetbrains;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
THIS CLASS WAS CREATED TO HELP OPERATE OTHER CLASSES.
IT WILL HAVE METHODS THAT WILL BE CALLED IN OTHER CLASSES

*/
public class Auxiliar{

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
                print(msg);
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

}
