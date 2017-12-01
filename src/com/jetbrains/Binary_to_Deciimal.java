package com.jetbrains;

public class Binary_to_Deciimal extends System_{



    // THIS METHOD PRINTS THE BINARY NUMBER IN DECIMAL FORMAT, NO MATTER THIS IS
    //DECIMAL OR INTEGER
    String Bin_to_Dec(String binary) {
        String[] arr_bin = binary.split("");
        String converted = "";
        boolean isDecimal = false;

        //CHEKCING IF THE PARAMETER HAS "." IN IT, THEREFORE IF THAT'S DECIMAL:
        //IF THERE IS ANY "." IN THE PARAMETER, IT WILL BE CONSIDERED DECIMAL;
        for (int i = 0; i < arr_bin.length; i++) {

            if(arr_bin[i].equals(".")){
                isDecimal = true;
                i = arr_bin.length;
            }
        }


        if (!isDecimal){
            converted = convert_int_binary(binary);
        }else{
            String[] bin = binary.split("[.]");
            converted = convert_int_binary(bin[0])+"."+conver_dou_binary(bin[1]);
        }
        print(converted);
        return converted;
    }

    //CONVERTING INTEGER BINARY INTO DECIMAL
    String convert_int_binary(String binary){

        String[] arr_bin = binary.split("");

        int result = 0;
        int index = 0;
        for (int i = arr_bin.length-1; i>=0; i--){

            if (arr_bin[i].equals("1")){
                result += Math.pow(2, index);

            }
            index++;
        }

        return String.valueOf(result);
    }

    // CONVERTING JUST DECIMAL PLACES BINARY INTO INTEGER
    String conver_dou_binary(String binary){

        String[] arr_bin = binary.split("");

        int index = -1;
        Double result = 0.0;

        for (int i = 0; i < arr_bin.length; i++){
            if (arr_bin[i].equals("1")){
                result += Math.pow(2, index);
            }
            index--;
        }

        //GETTING RID OF THE 0. ON THE BEGUINING
        String resu_[] = String.valueOf(result).split("");
        String result_ = "";
        for (int i = 2; i< resu_.length; i++){
            result_ += resu_[i];
        }
        return result_;
    }


}
