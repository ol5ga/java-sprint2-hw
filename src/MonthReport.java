import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

 public class MonthReport {
     public HashMap<String, ArrayList<Integer>> monthOne = reedMonthReport(1);
     public HashMap<String, ArrayList<Integer>> monthTwo = reedMonthReport(2);
     public HashMap<String, ArrayList<Integer>> monthThree = reedMonthReport(3);


     public HashMap reedMonthReport(int c){
         HashMap<String, ArrayList<Integer>> monthContents = new HashMap<>();
         String monthPath = "resources/m.20210" + c + ".csv";
         String content = readFileContentsOrNull(monthPath);
        String[] lines = content.split("\r?\n"); // массив строк

         for (int i = 1; i < lines.length; i++) {
             ArrayList<Integer> monthValues = new ArrayList<>();
             String line = lines[i]; //
             String[] parts = line.split(",");
             String itemName = parts[0];
             boolean isExpense = Boolean.parseBoolean(parts[1]);
             int quantity = Integer.parseInt(parts[2]);
             int sumOfOne = Integer.parseInt(parts[3]);
             if (isExpense) {
                 monthValues.add(0);
             } else monthValues.add(1);
             monthValues.add(quantity);
             monthValues.add(sumOfOne);
             monthContents.put(itemName, monthValues);


        } return monthContents;
     }

     public void getMonthReport(){
         System.out.println("Месяный отчет:");
         System.out.println("Месяц 1 - январь: ");
            System.out.println("Самый прибыльный товар: " + findMaxIncome(monthOne));
            System.out.println("Самая большая трата: " + findMaxExpense(monthOne));
         System.out.println("Месяц 2 - февраль: ");
             System.out.println("Самый прибыльный товар: " + findMaxIncome(monthTwo));
             System.out.println("Самая большая трата: " + findMaxExpense(monthTwo));
         System.out.println("Месяц 3 - март: ");
            System.out.println("Самый прибыльный товар: " + findMaxIncome(monthThree));
            System.out.println("Самая большая трата: " + findMaxExpense(monthThree));


     }
     public HashMap<String,Integer> findMaxIncome (HashMap<String, ArrayList<Integer>> monthContents){
         HashMap<String,Integer>MaxIncome = new HashMap<>();
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
