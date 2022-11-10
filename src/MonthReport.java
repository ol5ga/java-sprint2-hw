import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class MonthReport {

    int month;
    HashMap<Integer, HashMap<String, Item>> monthReport = new HashMap<>();
    Item tem = new Item();
    public void reedMonthReport(int c){

        for(int m = 1; m <= c; m++) {
            HashMap<String, Item> monthContents = new HashMap<>();
            String monthPath = "resources/m.20210" + m + ".csv";
            String content = readFileContentsOrNull(monthPath); // << содержимое файла
            if (content == null) {
                return;
            } else {System.out.println("Отчет считан");}
            String[] lines = content.split("\r?\n"); // массив строк

            for (int i = 1; i < lines.length; i++) {
                Item tem = new Item();
                String line = lines[i]; //
                String[] parts = line.split(",");
                String itemName = parts[0];
                tem.name = itemName;
                tem.isExpense = Boolean.parseBoolean(parts[1]);
                tem.qty = Integer.parseInt(parts[2]);
                tem.SumOfOne = Integer.parseInt(parts[3]);


                monthContents.put(itemName, tem);

            } monthReport.put(m, monthContents);

        }
    }

    public void getMonthReport(){
        if (!monthReport.isEmpty()) {
            System.out.println("Месяный отчет:");
            System.out.println("Месяц 1 - январь: ");
            System.out.println("Самый прибыльный товар: " + findMaxIncome(1));
            System.out.println("Самая большая трата: " + findMaxExpense(1));
            System.out.println("Месяц 2 - февраль: ");
            System.out.println("Самый прибыльный товар: " + findMaxIncome(2));
            System.out.println("Самая большая трата: " + findMaxExpense(2));
            System.out.println("Месяц 3 - март: ");
            System.out.println("Самый прибыльный товар: " + findMaxIncome(3));
            System.out.println("Самая большая трата: " + findMaxExpense(3));
        }else {
            System.out.println("Отчеты не считаны");}
    }

    public HashMap<String,Integer> findMaxIncome (int month){

        HashMap<String,Integer> MaxIncome = new HashMap<>();
        int maxIncome = 0;
        String key = " ";
        int sum = 0;
        HashMap<String, Item> oMReport = monthReport.get(month);
        for (Item oneMonth : oMReport.values()) {

            if (!oneMonth.isExpense){
                sum = oneMonth.qty* oneMonth.SumOfOne;
            }
            if (maxIncome < sum){
                maxIncome = sum;
                key = oneMonth.name;

            }

        } MaxIncome.put(key,maxIncome);
        return MaxIncome;
    }

    public HashMap<String,Integer> findMaxExpense (int month){
        HashMap<String, Item> mReport = monthReport.get(month);
        HashMap<String,Integer>MaxExpense = new HashMap<>();
        int maxExpense = 0;
        String key = " ";
        int sum = 0;
        for (Item oneMonth : mReport.values()) {

            if (oneMonth.isExpense){
                sum = oneMonth.qty* oneMonth.SumOfOne;
            }
            if (maxExpense < sum){
                maxExpense = sum;
                key = oneMonth.name;

            }
        } MaxExpense.put(key,maxExpense);
        return MaxExpense;
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