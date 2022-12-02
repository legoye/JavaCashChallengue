package com.company;

import java.util.*;

public class Cash {


    public static void main(String ... args) {
        Map<Integer, Integer> registerStatus = new HashMap<Integer, Integer>();
        registerStatus.put(1, 2); // One Dolar, 30 bills;
        registerStatus.put(2, 3); // Two Dolar, 3 bills;
        registerStatus.put(5, 3); // Five Dolar, 3 bills;
        registerStatus.put(10, 2); // Ten Dolar, 2 bills;
        registerStatus.put(20, 1); // twenty Dolar, 2 bills;
        registerStatus.put(50, 2); // fifhty Dolar, 2 bills;
        registerStatus.put(100, 2); // One hundred Dolar, 2 bills;

        boolean result = canIGiveChange(registerStatus, 100, 9);
        System.out.println("Result " + result);

        boolean resultNotChange = canIGiveChange(registerStatus, 500, 100);
        System.out.println("Result " + resultNotChange);

        boolean resultNotChange2 = canIGiveChange(registerStatus, 300, 50);
        System.out.println("Result " + resultNotChange2);

    }

    public static boolean canIGiveChange(Map<Integer,Integer> registerStatus, Integer customerPayment, Integer productCost) {

        int change = customerPayment - productCost;
        int valueMinus = 0;
        boolean exist = false;

        if(change == 0){
            return true;
        }

        if(change>=100){
            Integer actualQ = registerStatus.get(100);
            if(actualQ>0){
                exist = true;
                valueMinus = 100;
                registerStatus.put(100, actualQ - 1);
            }
        }

        if(change>=50&&!exist){
            Integer actualQ = registerStatus.get(50);
            if(actualQ>0){
                exist = true;
                valueMinus = 50;
                registerStatus.put(50, actualQ - 1);
            }
        }

        if(change>=20&&!exist){
            Integer actualQ = registerStatus.get(20);
            if(actualQ>0){
                exist = true;
                valueMinus = 20;
                registerStatus.put(20, actualQ - 1);
            }

        }

        if(change>=10&&!exist){
            Integer actualQ = registerStatus.get(10);
            if(actualQ>0){
                exist = true;
                valueMinus = 10;
                registerStatus.put(10, actualQ - 1);
            }

        }

        if(change>=5&&!exist){
            Integer actualQ = registerStatus.get(5);
            if(actualQ>0){
                exist = true;
                valueMinus = 5;
                registerStatus.put(5, actualQ - 1);
            }

        }

        if(change>=2&&!exist){
            Integer actualQ = registerStatus.get(2);
            if(actualQ>0){
                exist = true;
                valueMinus = 2;
                registerStatus.put(2, actualQ - 1);
            }

        }

        if(change>=1&&!exist){
            Integer actualQ = registerStatus.get(1);
            if(actualQ>0){
                exist = true;
                valueMinus = 1;
                registerStatus.put(1, actualQ - 1);
            }

        }

        if(exist){
            return  canIGiveChange(registerStatus, change, valueMinus);
        }

        return false;
    }

}