package com.jetbrains;

public class Application extends Auxiliar {
    void welcome(){
        String[] welcome = new String[]{"WELCOME","TO THE","BINARY","CALCULATOR"};
        arr_printer(welcome);
    }
    void menu(){
        String[] menu = new String[]{"CONVERT BINARY TO DECIMAL",
        "CONVERT DECIMAL TO BINARY", "ADD TWO BINARIES STRINGS", "SUBTRACT TWO DINARIES STRINGS",
        "MULTIPLY TWO BINARIES STRING", "DIVIDE TWO BINARIES STRING"};
        arr_printer_ordered(menu);
    }
}
