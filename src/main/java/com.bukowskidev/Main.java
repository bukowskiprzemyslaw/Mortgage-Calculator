package main.java.com.bukowskidev;


import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Witaj w kalkulatorze kredytowym");
        System.out.println("-------------------------------");

        int loan = (int) readNumber("Kredyt: ", 1000, 1000000);
        float annualInterest = (float) readNumber("Oprocentowanie: ", 1, 50);
        byte years = (byte) readNumber("Okres kredytowania", 1, 40);

         double mortage = calculateMortgage(loan, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println("Miesięczna rata kredytu wynosi : " + mortgageFormatted);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.println(prompt);
            value = scanner.nextInt();
            if (value >= min && value <= max)
                break;
            System.out.println("Podaj wartość między" + min + " i " + max );
        }
        return value;
    }

    public static double calculateMortgage(int loan, float annualInterest, byte years) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        double mortage = loan
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortage;
    }
}
