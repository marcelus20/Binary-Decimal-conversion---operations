package com.jetbrains;

public class Main {

    Main(){
        System_controller sys = new System_controller();
        System.out.println(sys.str_mult("0",4));
    }

    public static void main(String[] args) {
	new Main();
    }
}
