import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

 public class MonthReport {

     Item item = new Item();
     OneMonthReport oneReport = new OneMonthReport(0);
     public HashMap <Integer, HashMap<String, ArrayList<Integer>>> monthReports = new HashMap<>();

     public void reedMonthReport(){
         HashMap<String, Item> monthContents = new HashMap<>();
         ArrayList<Integer> monthValues = new ArrayList<>();

         for(int m = 1; m <= 3; m++) {
         String monthPath = "resources/m.20210" + m + ".csv";
         String content = readFileContentsOrNull(monthPath);
             if (content == null) {
                 return;
             } else {System.out.println("Отчеты считаны");}
        String[] lines = content.split("\r?\n"); // массив строк

         for (int i = 1; i < lines.length; i++) {

             String line = lines[i]; //
             String[] parts = line.split(",");
             String itemName = parts[0];

             boolean isExpense = Boolean.parseBoolean(parts[1]);
             int quantity = Integer.parseInt(parts[2]);
             int sumOfOne = Integer.parseInt(parts[3]);
             //if (isExpense) {
               //  monthValues.add(0);
            // } else monthValues.add(1);
             item = new Item();
             item.isExpense = isExpense;
             item.qty = quantity;
             item.SumOfOne = sumOfOne;
             //monthValues.add(quantity);
             //monthValues.add(sumOfOne);
             monthContents.put(itemName, item);



         } oneReport.month = m;
             oneReport.monthReports = monthContents;


        System.out.println(oneReport.monthReports);

        }
         //return monthContents;
     }

     public void getMonthReport(){

         System.out.println("Месяный отчет:");
         System.out.println("Месяц 1 - январь: ");
            System.out.println("Самый прибыльный товар: " + findMaxIncome(oneReport.monthReports));
            System.out.println("Самая большая трата: " + findMaxExpense(monthReports.get(0)));
         System.out.println("Месяц 2 - февраль: ");
             System.out.println("Самый прибыльный товар: " + findMaxIncome(monthReports.get(1)));
             System.out.println("Самая большая трата: " + findMaxExpense(monthReports.get(1)));
         System.out.println("Месяц 3 - март: ");
            System.out.println("Самый прибыльный товар: " + findMaxIncome(monthReports.get(2)));
            System.out.println("Самая большая трата: " + findMaxExpense(monthReports.get(2)));


     }
     public HashMap<String,Integer> findMaxIncome (HashMap<String, Item> monthContents){
         HashMap<String,Integer> MaxIncome = new HashMap<>();
         int isExpense = 0;
         String key = " ";
         int sum = 0;
         for (String income: monthContents.keySet()) {
             ArrayList<Integer> value = monthContents.get(income);
                if (value.get(0)==1){
                   sum = value.get(1)*value.get(2);
                    }
             if (isExpense < sum){
                 isExpense = sum;
                 key = income;

             }

         } MaxIncome.put(key,isExpense);
         return MaxIncome;
     }

     public HashMap<String,Integer> findMaxExpense (HashMap<String, ArrayList<Integer>> monthContents){
         HashMap<String,Integer>MaxExpense = new HashMap<>();
         int isExpense = 0;
         String key = " ";
         int sum = 0;
         for (String income: monthContents.keySet()) {
             ArrayList<Integer> value = monthContents.get(income);
             if (value.get(0)==0){
                 sum = value.get(1)*value.get(2);
             }
             if (isExpense < sum){
                 isExpense = sum;
                 key = income;

             }

         } MaxExpense.put(key,isExpense);
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
