import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class YearlyReport {

    public HashMap<Integer, YearlyReportMonth> monthsData;

    public YearlyReport() {
        monthsData = new HashMap<>();
    }

    public void reedYearlyReport(String path) {


        String content = readFileContentsOrNull(path); // << содержимое файла
        if (content == null) {
            return;
        } else {System.out.println("Отчет считан");}
        String[] lines = content.split("\r?\n"); // массив строк

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i]; // "01,350000,true"
            String[] parts = line.split(","); // "01,350000,true" -> ["01", "350000", "true"]
            int month = Integer.parseInt(parts[0]);
            int sum = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);

            if (!monthsData.containsKey(month)) {
                monthsData.put(month, new YearlyReportMonth(month));

            }

            YearlyReportMonth oneMonthData = monthsData.get(month);
            if (isExpense) {
                oneMonthData.expenses += sum;
            } else {
                oneMonthData.income += sum;
            }

        }

    }
    public void printYearlyReport(){
        if (!monthsData.isEmpty()) {
            System.out.println("Отчет за год:");
            sumProfit();
            System.out.println("Средний расход: " + averageExpense());
            System.out.println("Средний доход: " + averageIncome());
        } else {
            System.out.println("Отчет не считан");
        }

    }

    public void sumProfit() {

        int profit = 0;
        for (YearlyReportMonth oneMonthData : monthsData.values()) {
            profit += oneMonthData.income - oneMonthData.expenses;
            System.out.println("Прибыль за " + oneMonthData.month + " месяц: " + profit);
        }

    }

    public int averageIncome() {

        int income = 0;
        int sum = 0;
        for (YearlyReportMonth oneMonthData : monthsData.values()) {
            sum += oneMonthData.income;
            income = sum / 3;
        }
        return income;
    }

    public int averageExpense() {

        int expense = 0;
        int sum = 0;
        for (YearlyReportMonth oneMonthData : monthsData.values()) {
            sum += oneMonthData.expenses;
            expense = sum / 3;
        }
        return expense;
    }

    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}



