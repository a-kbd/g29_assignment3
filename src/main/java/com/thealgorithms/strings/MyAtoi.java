// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function). Here is my implementation

package com.thealgorithms.strings;
import java.util.Arrays;

public class MyAtoi {
    static boolean[] coverageArray = new boolean[30];

    static public void getCoverage(){
        System.out.println(Arrays.toString(coverageArray));

        int counter = 0;
        for(int i = 0; i<coverageArray.length; i++){
            if(coverageArray[i]){
                counter++;
            }
        }

        double percentage = (double) counter / coverageArray.length;
        percentage = percentage * 100;

        System.out.println("PERCENTAGE COVERAGE: " + percentage);
    }

public static int myAtoi(String s) {
        s = s.trim();
        char[] char_1 = s.toCharArray();
        String number = "";
        boolean negative = false;
        boolean zero = false;
        boolean isDigit = false;

        for (char ch : char_1) {
            //b1
            coverageArray[0] = true;
            if (Character.isDigit(ch)) {
                //b1.1
                coverageArray[1] = true;
                if (number.length() > 1 && !isDigit) {
                    //b1.1.1
                    coverageArray[2] = true;
                    number = "0";
                    break;
                }
                isDigit = true;
                if (zero) {
                    //b1.1.2
                    coverageArray[3] = true;
                    number = "0";
                    break;
                }
                switch (ch) {
                    case '0' -> {
                        //b1.1.3
                        number += ch;
                        coverageArray[4] = true;
                    }
                    case '1' -> {
                        //b1.1.4
                        number += ch;
                        coverageArray[5] = true;
                    }
                    case '2' -> {
                        //b1.1.5
                        number += ch;
                        coverageArray[6] = true;
                    }
                    case '3' -> {
                        //b1.1.6
                        number += ch;
                        coverageArray[7] = true;
                    }
                    case '4' -> {
                        //b1.1.7
                        number += ch;
                        coverageArray[8] = true;
                    }
                    case '5' -> {
                        //b1.1.8
                        number += ch;
                        coverageArray[9] = true;
                    }
                    case '6' -> {
                        //b1.1.9
                        number += ch;
                        coverageArray[10] = true;
                    }
                    case '7' -> {
                        //b1.1.10
                        number += ch;
                        coverageArray[11] = true;
                    }
                    case '8' -> {
                        //b1.1.11
                        number += ch;
                        coverageArray[12] = true;
                    }
                    case '9' -> {
                        //b1.1.12
                        number += ch;
                        coverageArray[13] = true;
                    }
                }
            } else if (ch == '-' && !isDigit) {
                //b1.2
                coverageArray[14] = true;
                number += "0";
                negative = true;
            } else if (ch == '+' && !isDigit) {
                //b1.3
                coverageArray[15] = true;
                number += "0";
            } else if (ch == '.' && isDigit) {
                //b1.4
                coverageArray[16] = true;
                break;
            } else if (ch == '.') {
                //b1.5
                coverageArray[17] = true;
                zero = true;
            } else {
                //b1.6
                coverageArray[18] = true;
                if (!isDigit) {
                    //b1.6.1
                    coverageArray[19] = true;
                    number = "0";
                }
                break;
            }
        }
    
    if (!isDigit) {
        //b2
        coverageArray[20] = true;
            return 0;
        }
    
         number = number.replaceFirst("^0+(?!$)", "");
    
    
    if (number.length() > 10 && negative) {
        //b3
        coverageArray[21] = true;
            return -2147483648;
        } else if (number.length() > 10) {
            //b4
            coverageArray[22] = true;
            return 2147483647;
        } else if (number.length() == 10 && negative) {
            //b5
            coverageArray[23] = true;
            double db1 = Double.parseDouble(number);
            if (db1 >= 2147483648d) {
                //b5.1
                coverageArray[24] = true;
                return -2147483648;
            }
        } else if (number.length() == 10) {
            //b6
            coverageArray[25] = true;
            double db1 = Double.parseDouble(number);
            if (db1 > (2147483647)) {
                //b7
            coverageArray[26] = true;
                return 2147483647;
            }
        }else if (number.length() == 10 && negative) {
            //b8
            coverageArray[27] = true;
            double db1 = Double.parseDouble(number);
            if (db1 >= 2147483648d) {
                //b8.1
            coverageArray[28] = true;
                return -2147483648;
            }
        }
    
    if(negative){
        //b9
            coverageArray[29] = true;
        return Integer.parseInt(number)*-1;
    }

        return Integer.parseInt(number);
    }
}
