import java.util.*;

public class FinancialForecastOptimize {

    static double[] dp;

    static double futureValue(double value, double rate, int years)
    {
        if(years == 0)
            return value;

        if(dp[years] != -1)
            return dp[years];

        dp[years] = futureValue(value, rate, years - 1) * (1 + rate);

        return dp[years];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        double value = sc.nextDouble();
        double rate = sc.nextDouble();
        int years = sc.nextInt();

        dp = new double[years + 1];
        Arrays.fill(dp, -1);

        System.out.println(futureValue(value, rate, years));
    }
}
