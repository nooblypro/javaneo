class InvestmentCalculator {
    public static double computeTotalAmount(double principal, double annualRate, int years) {
        return principal * Math.pow(1.0 + annualRate / 100.0, years);
    }

    public static double computeInterest(double principal, double annualRate, int years) {
        return computeTotalAmount(principal, annualRate, years) - principal;
    }
}
