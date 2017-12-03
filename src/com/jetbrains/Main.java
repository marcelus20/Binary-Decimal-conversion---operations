package com.jetbrains;

public class Main extends System_{

    Main(){

        Decimal_to_Binary db = new Decimal_to_Binary();
        Binary_to_Deciimal bt = new Binary_to_Deciimal();
        Sys_operations s = new Sys_operations();

        //CONVERTING TEST: BINARY TO DECIMAL:
        bt.Bin_to_Dec("110011");
        print("____________________________________");

        //CONVERTING TEST: DECIMAL TO BINARY
        print(db.to_binary(22.4448));
        print("____________________________________");
        print(db.to_binary(15));
        print("____________________________________");

        //test: ADDITION BETWEEN TWO NUMBERS:
        print(s.add("1011", "1"));
        print("____________________________________");

        //TEST: SUBTRACTION:
        print(s.sub("1011111","1111"));
        print("____________________________________");

        //MULTIPLICATION:
        s.mult("10","10");
        print("____________________________________");


    }

    public static void main(String[] args) {
	new Main();
    }
}
