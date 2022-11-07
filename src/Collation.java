import java.util.ArrayList;
import java.util.HashMap;


public class Collation {

    MonthReport mReport = new MonthReport();
    YearlyReport yReport = new YearlyReport(2021, "resources/y.2021.csv");
    int incomeOne = sumIncome(mReport.monthOne);
    int incomeTwo = sumIncome(mReport.monthTwo);
    int incomeThree = sumIncome(mReport.monthThree);
    int expenseOne = sumExpense(mReport.monthOne);
    int expenseTwo = sumExpense(mReport.monthTwo);
    int expenseThree = sumExpense(mReport.monthThree);
    YearlyReportMonth monthOne = yReport.monthsData.get(1);
    YearlyReportMonth monthTwo = yReport.monthsData.get(2);
    YearlyReportMonth monthThree = yReport.monthsData.get(3);

    public void Compare(){
    if ((incomeOne == monthOne.income) && (expenseOne == monthOne.expenses)) {
        if ((incomeTwo == monthTwo.income) && (expenseTwo == monthTwo.expenses)){
            if ((incomeThree == monthThree.income) && (expenseThree == monthThree.expenses)) {
                System.out.println("Сверка успешно завершена");
            } else {System.out.println("Обнаружено несоответствие в месяце" + monthThree.month);}
        } else {System.out.println("Обнаружено несоответствие в месяце" + monthTwo.month);}
    } else {System.out.println("Обнаружено несоответствие в месяце" + monthOne.month);}

    }



    public int sumIncome(HashMap<String, ArrayList<Integer>> monthreport){
        int sum =0;
        for (String income: monthreport.keySet()){
            ArrayList<Integer> value = monthreport.get(income);
            if (value.get(0)==1) {
                sum += value.get(1) * value.get(2);
            }

        } return sum;
    }

    public int sumExpense(HashMap<String, ArrayList<Integer>> monthreport){
        int sum =0;
        for (String income: monthreport.keySet()){
            ArrayList<Integer> value = monthreport.get(income);
            if (value.get(0)==0) {
                sum += value.get(1) * value.get(2);
            }

        } return sum;
    }

}
