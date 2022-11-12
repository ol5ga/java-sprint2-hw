import java.util.HashMap;


public class Collation {

    public void compare(HashMap<Integer, HashMap<String, Item>> m, HashMap<Integer, YearlyReportMonth> y){

        if (y.isEmpty() && m.isEmpty()) {
            System.out.println("Отчеты не считаны");
        } else if (y.isEmpty() ) {
            System.out.println("Годовой отчет не считан");
        } else if (m.isEmpty()) {
            System.out.println("Месячные отчеты не считаны");
        } else {
        int incomeOne = sumIncome(m.get(1));
        int incomeTwo = sumIncome(m.get(2));
        int incomeThree = sumIncome(m.get(3));
        int expenseOne = sumExpense(m.get(1));
        int expenseTwo = sumExpense(m.get(2));
        int expenseThree = sumExpense(m.get(3));

        YearlyReportMonth monthOne = y.get(1);
        YearlyReportMonth monthTwo = y.get(2);
        YearlyReportMonth monthThree = y.get(3);



            if ((incomeOne == monthOne.income) && (expenseOne == monthOne.expenses)) {
                if ((incomeTwo == monthTwo.income) && (expenseTwo == monthTwo.expenses)){
                    if ((incomeThree == monthThree.income) && (expenseThree == monthThree.expenses)) {
                        System.out.println("Сверка успешно завершена");
                    } else {System.out.println("Обнаружено несоответствие в месяце" + 3);}
                } else {System.out.println("Обнаружено несоответствие в месяце" + 2);}
            }

        }

    }



    public int sumIncome (HashMap<String, Item> report){
        int sum =0;
        for (Item oneMonth : report.values()){

            if (!oneMonth.isExpense) {
                sum += oneMonth.qty* oneMonth.SumOfOne;
            }

        } return sum;
    }

    public int sumExpense(HashMap<String, Item> report){
        int sum =0;
        for (Item oneMonth : report.values()){

            if (oneMonth.isExpense) {
                sum += oneMonth.qty* oneMonth.SumOfOne;
            }

        } return sum;
    }


}
