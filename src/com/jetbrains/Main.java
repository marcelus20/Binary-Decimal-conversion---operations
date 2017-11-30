package com.jetbrains;

public class Main {

    Main(){
        System_controller sys = new System_controller();
        sys.to_binary(25);
        //sys.print(1%2);
    }

    public static void main(String[] args) {
	new Main();
    }
}
