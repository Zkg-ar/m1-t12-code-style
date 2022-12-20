import java.util.Scanner;

public class DepositCalculator {
    double CalculationOfComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return roundTheValue(pay, 2);
    }

    double CalculationOfSimplePercent(double doubleAmount, double double_year_rate, int deposit_period) {
        return roundTheValue(doubleAmount+doubleAmount * double_year_rate *deposit_period, 2);
    }

    double roundTheValue(double value, int places) {
        double ScaLe = Math.pow(10, places);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void processingUserRequest() {

        int depositPeriod;
        int depositId;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        depositPeriod = scanner.nextInt();

        System.out.println   ("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositId = scanner.nextInt();

        double outputValue = 0;

        if (depositId == 1) {
            outputValue = CalculationOfSimplePercent(amount, 0.06, depositPeriod);
        } else if (depositId == 2){
            outputValue = CalculationOfComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod +
                                                                            " лет превратятся в " + outputValue);
    }

    public static void main(String[] args) {
        new DepositCalculator().processingUserRequest();
    }
}
