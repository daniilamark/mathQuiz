package com.daniilamark.mathquiz;

public class Calculations {
    private int num1, num2, result, count = 0;

    public String getStrNum1() {
        num1 = getNum1();
        String numStr1 = String.valueOf(num1);
        return numStr1;
    }

    public int getNum1() {
        num1 = 1 + (int) (Math.random() * 10);
        return num1;
    }

    public String getStrNum2() {
        num2 = getNum2();
        String numStr2 = String.valueOf(num2);
        return numStr2;
    }
    public int getNum2() {
        num2 = 1 + (int) (Math.random() * 10);
        return num2;
    }

    public int getResult() {
        result = num1 + num2;
        return result;
    }
    public int getCount() {
        return count;
    }
    public String getStrCount() {
        count = getCount();
        String countStr = String.valueOf(count);
        return countStr;
    }
    public int setCountPlus() {
        count++;
        return count;
    }
    public int setCountMinus() {
        if(count != 0){
            count--;
        }
        return count;
    }
}
