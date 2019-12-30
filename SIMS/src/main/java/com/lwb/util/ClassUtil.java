package com.lwb.util;

import java.math.BigInteger;

public class ClassUtil {






    public static String decimalToBinary(int ten){
        BigInteger binary = new BigInteger(ten+"");
        return binary.toString(2);
    }


    public  static int binaryToDecimal(String binary){
        BigInteger ten = new BigInteger(binary,2);
        return ten.intValue();
    }
}
