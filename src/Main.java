
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {
    public static final int MONTHS_COUNT = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        MonthReport mReport = new MonthReport();
        YearlyReport report = new YearlyReport();
        //Collation collation = new Collation();


        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                // Считать месячные отчеты
                mReport.reedMonthReport(MONTHS_COUNT);


            } else if (userInput == 2) {
                // Считать годовой отчет
                report.reedYearlyReport("resources/y.2021.csv");


            } else if (userInput == 3) {
                //Сверить отчеты
                //collation.Compare();
            } else if (userInput == 4) {
                //Вывести информацию о всех месячных отчётах
                mReport.getMonthReport();

            } else if (userInput == 5) {
                //Вывести информацию о годовом отчёте
                report.getYearlyReport();

            } else System.out.println("Извините, такой команды пока нет");
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");

    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");

    }







}


