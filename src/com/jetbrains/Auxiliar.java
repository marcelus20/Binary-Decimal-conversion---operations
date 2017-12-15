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
    IT RECEIVES THREE PARAMETERS. THE MSG WILL BE PRINTED TO INVITE THE USER TO
    TYPE A NUMBER IN. THEN, THE SECOND PARAMETER IS FOR CHECKING IF WHAT WAS TYPED MATCHES THE RREGEX
    THE THIRD PARAMETER IS A ERROR_MSG TRHOWN WHEN IT DOES NOT MATCH THE REGEX
    */
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
}
