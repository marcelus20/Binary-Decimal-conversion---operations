package com.jetbrains;

public class Application extends Auxiliar{

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
    void add_bin(){
        //INVITING USER TO INSERT THE FIRST BINARY NUMBER:
        String num_1 = number_catcher("Insert the first binary: ",
                "[0-1]*\\.?[0-1]*", "You should type just numbers 1 and 0, double or integers");

        //INVITING USER TO TYPE THE SECOND BINARY
        String num_2 = number_catcher("Insert the second binary: ",
                "[0-1]*\\.?[0-1]*", "You should type just numbers 1 and 0, double or integers");

        num_1 = num_adjuster(num_1);
        num_2 = num_adjuster(num_2);

        /*
        * NOW, BEFORE CARRYING OUT THE SUM, WE NEEED TO MAKE SURE BOTH STRINGS HAS SAME LENGTH
        * FOR THAT, A METHOD FROM THE AUXILIARY CLASS WILL FILL THE SMALLER STRING WITH ZEROS UNTIL IT GETS
        * THE SIZE OF THE BIGGEST, BEING SETTLED WITH SAME LENGTH BOTH
        *
        * */
        num_1 = length_settler(num_1, num_2)[0];
        num_2 = length_settler(num_1, num_2)[1];

        print(" " + num_1);
        print(" " + num_2);
        print(mult_str("_", num_1.length()));

        //NOW, FINALLY THE CALCULATOR WILL BE CALLED:
        sum(num_1, num_2);




    }
    void sub_bin(){}
    void mult_bin(){}
    void div_bin(){}

}
