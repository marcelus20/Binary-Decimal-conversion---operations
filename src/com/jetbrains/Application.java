package com.jetbrains;

public class Application extends Auxiliar {

    void welcome(){
        String[] welcome = new String[]{"WELCOME ","TO THE","BINARY","CALCULATOR"};
        arr_printer(welcome);
    }
    void menu(){
        String[] menu = new String[]{"CONVERT BINARY TO DECIMAL",
        "CONVERT DECIMAL TO BINARY", "ADD TWO BINARIES STRINGS", "SUBTRACT TWO DINARIES STRINGS",
        "MULTIPLY TWO BINARIES STRING", "DIVIDE TWO BINARIES STRING", "CLOSE APPLICATION"};
        String option;

        arr_printer_ordered(menu);
        option = number_catcher("OPTION",
                "[1-"+menu.length+"]", "You should type just numbers between 1 and "+menu.length);
        if (option.equals("1")){
            bin_to_Decimal();
        }else if (option.equals("2")){
            decimal_to_bin();
        }else if (option.equals("3")){
            add_bin();
        }else if (option.equals("4")){
            sub_bin();
        }else if(option.equals("5")){
            mult_bin();
        }else if(option.equals("6")){
            div_bin();
        }else{
            print("THANKS FOR USING THIS CALCULATOR, FAREWELL");
            System.exit(0);
        }

    }
    void bin_to_Decimal(){}
    void decimal_to_bin(){}
    void add_bin(){}
    void sub_bin(){}
    void mult_bin(){}
    void div_bin(){}

}
