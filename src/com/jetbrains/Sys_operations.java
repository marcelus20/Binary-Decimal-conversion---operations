package com.jetbrains;

public class Sys_operations extends System_{

    public void add(String a, String b){

        int bits = 8;

        if (a.length() < 8 && b.length() < 8){
            bits = 8;
        }

        a = str_mult("0", bits-a.length())+a;
        b = str_mult("0", bits-b.length())+b;
        print(a);
        print(b);

        String[] a_arr = a.split("");
        String[] b_arr = b.split("");


        int bring_up = 0;
        String result = "";
        for (int i = a_arr.length-1; i >=0; i--){
            if (bring_up == 1 ){
                if (a_arr[i].equals(b_arr[i])){
                    if (a_arr[i]. equals("0") && (b_arr[i]. equals("0"))){
                        result += "1";
                        bring_up = 0;
                    }else{
                        result += "0";
                        bring_up = 1;
                        if (i == 0 && bring_up == 1){
                            result += "1";
                        }
                    }
                }
                else if (!a_arr[i].equals(b_arr[i])){
                    result += "0";
                    bring_up = 0;
                }
            }else{
                if (a_arr[i].equals(b_arr[i])){
                    if (a_arr[i]. equals("0") && (b_arr[i]. equals("0"))){
                        result += "0";
                        bring_up = 0;
                    }else{
                        result += "0";
                        bring_up = 1;
                    }
                }
                else if (!a_arr[i].equals(b_arr[i])){
                    result += "1";
                    bring_up = 0;
                }
            }

        }

    print(inverter(result));
    }
}
