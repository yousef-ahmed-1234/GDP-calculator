package GDP;


public class GDP {

 public static void main(String[] args) {
     try {
        
         double consumption = getComponentValue("Consumption");
         double investment = getComponentValue("Investment");
         double governmentSpending = getComponentValue("Government Spending");
         double netExports = getComponentValue("Net Exports");

      
         if (consumption < 0 || investment < 0 || governmentSpending < 0 || netExports < 0) {
             throw new InvalidGDPComponentException("GDP components cannot be negative.");
         }

   
         double gdp = calculateGDP(consumption, investment, governmentSpending, netExports);
         System.out.printf("The calculated GDP is: %.2f\n", gdp);

     } catch (InvalidGDPComponentException e) {
         System.err.println("Error: " + e.getMessage());}
    
 }

 
 private static double getComponentValue(String componentName) {
     java.util.Scanner scanner = new java.util.Scanner(System.in);
     System.out.print("Enter the value for " + componentName + ": ");
     return scanner.nextDouble();
 }

 private static double calculateGDP(double consumption, double investment, double governmentSpending, double netExports) {
     return consumption + investment + governmentSpending + netExports;
 }


 static class InvalidGDPComponentException extends Exception {
     public InvalidGDPComponentException(String message) {
         super(message);
     }
 }
}
