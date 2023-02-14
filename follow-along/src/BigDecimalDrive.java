import java.math.BigDecimal;
import java.util.Arrays;

public class BigDecimalDrive {
  public static void main(String[] args) {
    BigDecimal disbursedLoan = new BigDecimal("20000");
    BigDecimal numberOfRepayment = new BigDecimal("3");

    BigDecimal averageRepayment = disbursedLoan.divideToIntegralValue(numberOfRepayment);

    BigDecimal delta = disbursedLoan.subtract(averageRepayment.multiply((numberOfRepayment)));

    BigDecimal[] repaymentPlan = new BigDecimal[numberOfRepayment.intValue()];

    for (int index = 0; index < numberOfRepayment.intValue(); index++) {
      repaymentPlan[index] = averageRepayment;

      if (index == numberOfRepayment.intValue() - 1) {
        repaymentPlan[index] = repaymentPlan[index].add(delta);
      }
    }
    // BigDecimal totalDisbursed =
    // averageRepayment.multiply(numberOfRepayment).add(delta);
    BigDecimal totalDisbursed = Arrays.asList(repaymentPlan).stream().reduce(new BigDecimal(0),
        (a, b) -> a.add(b));

    System.out.println("approved loan: " + disbursedLoan);
    System.out.println("number of installments: " + numberOfRepayment);
    System.out.println("average installment: " + averageRepayment);
    System.out.println("delta: " + delta);
    System.out.println("total: " + totalDisbursed);
    System.out.println("repaymentPlan: " + Arrays.toString(repaymentPlan));
    System.out.println("isCorrect: " + totalDisbursed.equals(disbursedLoan));
  }
}
