package com.bukowskidev;


import com.bukowskidev.Console;

import java.text.NumberFormat;

public class Main {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        System.out.println("Witaj w kalkulatorze kredytowym");
        System.out.println("-------------------------------");

        int loan = (int) Console.readNumber("Kredyt: ", 1000, 1000000);
        float annualInterest = (float) Console.readNumber("Oprocentowanie: ", 1, 50);
        byte years = (byte) Console.readNumber("Okres kredytowania", 1, 40);

        printMortgage(loan, annualInterest, years);
        printPaymentSchedule(loan, annualInterest, years);
    }

    public static void printMortgage(int loan, float annualInterest, byte years) {
        double mortage = calculateMortgage(loan, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println();
        System.out.println("Kredyt");
        System.out.println("------");
        System.out.println("Miesięczna rata kredytu wynosi : " + mortgageFormatted);
    }

    public static void printPaymentSchedule(int loan, float annualInterest, byte years) {
        System.out.println();
        System.out.println("Tabela spłat");
        System.out.println("------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(loan, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double calculateMortgage(int loan, float annualInterest, byte years) {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        double mortage = loan
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortage;
    }

    public static double calculateBalance(int loan, float annualInterest, byte years, short numberOfPaymentsMade) {

            float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
            float numberOfPayments = (float)(years * MONTHS_IN_YEAR);
            double balance = loan
                    * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

            return balance;
    }
}
