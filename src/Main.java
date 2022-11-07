
import java.util.Scanner;
public class Main {
    public static final int MONTHS_COUNT = 3;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        MonthReport mReport = new MonthReport();
        YearlyReport report = new YearlyReport(2021, "resources/y.2021.csv");
        Collation collation = new Collation();


        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                // Считать месячные отчеты
                for(int c = 1; c <= MONTHS_COUNT; c++) {
                    mReport.reedMonthReport(c);
                }

                System.out.println("Отчеты считаны");

            } else if (userInput == 2) {
                // Считать годовой отчет
                report = new YearlyReport(2021, "resources/y.2021.csv");
                System.out.println("Отчет считан");


            } else if (userInput == 3) {
                //Сверить отчеты
                collation.Compare();
            }  else if (userInput == 4) {
            //Вывести информацию о всех месячных отчётах
                mReport.getMonthReport();

            }  else if (userInput == 5) {
                //Вывести информацию о годовом отчёте
                report.getYearlyReport();

        }else System.out.println("Извините, такой команды пока нет");
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");

    }
    private static void printMenu() {
        System.out.println ("Что вы хотите сделать?");
        System.out.println("1 - Считать месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");

    }






}


