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
    void decimal_to_bin(){

        String num, result;


        num = number_catcher("Insert the the decimal number:  ",
                "[0-9]*\\.?[0-9]*", "You should type numbers between 0 and 9, double or integers");



        //CARRYING OUT THE CONVERSION
        result = dec_to_bin(12);

        result = num_adjuster(result);
        print(result);




    }
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

        //NOW, FINALLY THE CALCULATOR WILL BE CALLED:
        String result = sum(num_1, num_2);

        String resul_bits = n_bits(result);

        calc_structure(num_1, num_2, "+", result);
        print("Result in " + resul_bits.split("\\.")[0].length() + " bits: "+binary_mask(resul_bits));
        system_pause();



        menu();
    }
    void sub_bin(){

        //FIRST NUMBER:
        String num1 = number_catcher("Type the first number",
                "[0-1]*\\.?[0-1]*", "You should type just numbers 1 and 0");
        //SECOND NUMBER:
        String num2 = number_catcher("Type the first number",
                "[0-1]*\\.?[0-1]*", "You should type just numbers 1 and 0");

        // MAKING BOTH NUMBERS HAVE THE SAME LENGTH
        num1 = length_settler(num1, num2)[0];
        num2 = length_settler(num1,num2)[1];

        String result = sub(num1, num2);
        //GETTING RID OF THE EXCESSIVE ZEROS (IF THERE IS)
        result = num_adjuster(result);
        String resul_bits = n_bits(result);



        print("Raw result: "+ result);
        print("Result in " + resul_bits.split("\\.")[0].length() + " bits: "+resul_bits);



    }
    void mult_bin(){
       String num_1, num_2, result, resul_bits;
       String[] tuple;
        num_1 = number_catcher("Type the first number",
                "[0-1]*\\.?[0-1]*", "You should type just numbers 1 and 0");
        num_2 = number_catcher("Type the first number",
                "[0-1]*\\.?[0-1]*", "You should type just numbers 1 and 0");
        tuple = length_settler(num_adjuster(num_1), num_adjuster(num_2));

        num_1 = tuple[0];
        num_2 = tuple[1];

        result = mult(num_1, num_2);
        resul_bits = n_bits(result);


        calc_structure(num_1,num_2,"*", result);
        print("Result in " + resul_bits.split("\\.")[0].length() + " bits: "+binary_mask(resul_bits));
    }
    void div_bin(){}

}
