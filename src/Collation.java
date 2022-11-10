import java.util.ArrayList;
import java.util.HashMap;


public class Collation {

    MonthReport mReport = new MonthReport();
    YearlyReport yReport = new YearlyReport();


    /*int incomeOne = sumIncome(mReport.monthReports.get(0));
    int incomeTwo = sumIncome(mReport.monthReports.get(1));
    int incomeThree = sumIncome(mReport.monthReports.get(2));
    int expenseOne = sumExpense(mReport.monthReports.get(0));
    int expenseTwo = sumExpense(mReport.monthReports.get(1));
    int expenseThree = sumExpense(mReport.monthReports.get(2));

    YearlyReportMonth monthOne = yReport.monthsData.get(1);
    YearlyReportMonth monthTwo = yReport.monthsData.get(2);
    YearlyReportMonth monthThree = yReport.monthsData.get(3);*/

    public void compare(){
        System.out.println(mReport.monthReport);
        System.out.println(yReport.monthsData);
        // if (!yReport.monthsData.isEmpty()){
    /*if ((incomeOne == monthOne.income) && (expenseOne == monthOne.expenses)) {
        if ((incomeTwo == monthTwo.income) && (expenseTwo == monthTwo.expenses)){
            if ((incomeThree == monthThree.income) && (expenseThree == monthThree.expenses)) {
                System.out.println("Сверка успешно завершена");
            } else {System.out.println("Обнаружено несоответствие в месяце" + 3);}
        } else {System.out.println("Обнаружено несоответствие в месяце" + 2);}
    } else {System.out.println("Обнаружено несоответствие в месяце" + 1);}*/
    //} else {System.out.println("Годовой отчет не считан");}

    }



    public int sumIncome(HashMap<String, ArrayList<Integer>> report){
        int sum =0;
        for (String income: report.keySet()){
            ArrayList<Integer> value = report.get(income);
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
