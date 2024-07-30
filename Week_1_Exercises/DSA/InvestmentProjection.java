public class InvestmentProjection {

    // Recursive method to calculate the projected future value
    public static double calculateFutureValue(double initialAmount, double rateOfReturn, int timePeriods) {
        // Base case: if no periods left, return initial amount
        if (timePeriods == 0) {
            return initialAmount;
        }
        // Recursive case: apply rate of return to initial amount and reduce the period
        return calculateFutureValue(initialAmount * (1 + rateOfReturn), rateOfReturn, timePeriods - 1);
    }

    public static void main(String[] args) {
        double currentAmount = 1000.0;
        double annualGrowthRate = 0.05; // 5% annual growth rate
        int years = 10;
        double futureAmount = calculateFutureValue(currentAmount, annualGrowthRate, years);
        System.out.println("Projected Future Value: $" + futureAmount);
    }
}
