package main.java.com.bukowskidev;


import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int loan = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

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

        while (true) {
            System.out.println("Podaj roczne oprocentowanie:");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 50) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Oprocentowanie powinno być w przedziale od 1 do 50");
        }

        while (true) {
            System.out.println("Podaj okres spłaty (ilość lat): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 40) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Okres kredytowania powinnien mieścić się w zakresie od roku do 40 lat");
        }

        double mortage = loan
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println("Miesięczna rata kredytu wynosi : " + mortgageFormatted);
    }

}