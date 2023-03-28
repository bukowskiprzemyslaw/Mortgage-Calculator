package main.java.com.bukowskidev;


import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int loan = 0;

        System.out.println("Witaj w kalkulatorze kredytowym");
        System.out.println("-------------------------------");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Podaj kwotę kredytu:");
            loan = scanner.nextInt();
            if (loan >= 1000 && loan <= 5_000_000)
                break;
            System.out.println("Kwota kredytu powinna wynosić od tysiąca do 5 milionów zł");
        }

        System.out.println("Podaj roczne oprocentowanie:");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.println("Podaj okres spłaty (ilość lat): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortage = loan
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println("Miesięczna rata kredytu wynosi : " + mortgageFormatted);
    }

    }