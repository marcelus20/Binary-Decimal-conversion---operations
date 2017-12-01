package com.jetbrains;

public class Main {

    Main(){
        double number = 25.99;
        Decimal_to_Binary sys = new Decimal_to_Binary();

        //PRINTING ANSWER IN 8 BITS
        sys.print_n_bits(sys.to_binary(number), 8);
        //sys.print(1%2);
    }

    public static void main(String[] args) {
	new Main();
    }
}
