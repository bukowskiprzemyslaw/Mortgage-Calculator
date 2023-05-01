package main.java.com.bukowskidev;


import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        int loan = 0;
        float annualInterest = 0;
        byte years = 0;

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
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 50)
                break;
            System.out.println("Oprocentowanie powinno być w przedziale od 1 do 50");
        }

        while (true) {
            System.out.println("Podaj okres spłaty (ilość lat): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 40)
                break;
            System.out.println("Okres kredytowania powinnien mieścić się w zakresie od roku do 40 lat");
        }

         double mortage = calculateMortgage(loan, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println("Miesięczna rata kredytu wynosi : " + mortgageFormatted);
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
