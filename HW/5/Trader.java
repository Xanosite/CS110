//  Blake Hershberger
// 4-Mar-2021
// traders for the stock market thingy
// break inout: anything that is not a Double

// Import the Random class
import java.util.Random;

// A Class that defines an object of type Trader
public class Trader {
    // fields; there are four of them, and each should be private:
    //
    // traderName of type String
    private String traderName;
    // stockChangePercentage of type double
    private Double stockChangePercentage;
    // dollarsSpent of type double
    private Double dollarsSpent;
    // dollarsMade of type double
    private Double dollarsMade;
    //
    // method: getStockChangePercentage, public
    // input: void
    // output: double
    // description: retrieves the value stockChangePercentage field
    public Double getStockChangePercentage() {
      return stockChangePercentage;
    }
    //
    // method: setStockChangePercentage , public
    // input: percentage, which is of type double
    // output: void
    // description: assign the field stockChangePercentage to percentage
    public void setStockChangePercentage(Double percentage) {
      stockChangePercentage = percentage;
    }
    //
    // method: tradeSomeMore, public
    // input parameter: dollars, which is of type double
    // output: none
    // description (pseudocode):
    public void tradeSomeMore(Double dollars) {
    //
    // 1) increment field dollarsSpent by input value dollars
      dollarsSpent += dollars;
    // 2) declare randomNumbers of be of type Random, and instantiate new random class
      Random randomNumbers = new Random();
    // 3) declare variable randomDouble of type double, and assign it the value output
    //    by the method nextDouble() of randomNumbers
      Double randomDouble = randomNumbers.nextDouble();
    // 4) if (randomDouble < stockChangePercentage){
    //        println(traderName + " made");
    //        dollarsMade += (dollars*2);
    //    else {
    //        println(traderName + " lost");
    //        dollarsMade -= dollars*3;
    //    }
      if (randomDouble < stockChangePercentage) {
        System.out.println(traderName + " made");
        dollarsMade += (dollars * 2);
      } else {
        System.out.println(traderName + " lost");
        dollarsMade -= (dollars * 3);
      }
    }
    //
    // method: getTraderName, public
    // input paramter: none
    // output: value of field traderName
    public String getTraderName() {
      return traderName;
    }
    //
    // method: getDollarsSpent, public
    // input paramter: none
    // output: value of field dollarsSpent
    public Double getDollarsSpent() {
      return dollarsSpent;
    }
    //
    // method: getDollarsMade, public
    // input paramter: none
    // output: value of field dollarsMade;
    public Double getDollarsMade() {
      return dollarsMade;
    }
    //
    // method: getNetProfit, public
    // input paramter: none
    // output: result of (dollarsMade - dollarsSpent)
    public Double getNetProfit() {
      return (dollarsMade - dollarsSpent);
    }
    //
    // Non-default constructor
    // input paramter: name, which is of type String
    // output: NA
    //
    // 1. set traderName to value in input argument name
    // 2. set dollarsMade to 1000 (all Traders begin with $1000)
    // 3. set dollarsSpent to 0 (all Traders begin neutrally)
    public Trader(String name) {
        traderName = name;
        dollarsMade = 1000.0;
        dollarsSpent = 0.0;
    }
}
