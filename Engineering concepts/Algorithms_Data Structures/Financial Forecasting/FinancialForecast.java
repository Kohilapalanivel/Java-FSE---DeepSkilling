import java.util.*;
public class FinancialForecast 
{
    static double futureValue(double currentValue, double rate, int years)
    {
        if(years == 0)
        {
            return currentValue;
        }

        return futureValue(currentValue, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter current value: ");
        double value = sc.nextDouble();
        System.out.print("Enter growth rate (e.g. 0.1 for 10%): ");
        double rate = sc.nextDouble();
        System.out.print("Enter number of years: ");
        int years = sc.nextInt();
        double result = futureValue(value, rate, years);
        System.out.printf("Future Value: %.2f" , result);
    }
}
