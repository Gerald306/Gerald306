import java.util.ArrayList;
import java.util.Arrays;

public class StockAnalyzer {

    /**
     * Calculates the average stock price.
     *
     * @param prices Array of stock prices
     * @return The average price as a double
     * @throws IllegalArgumentException if the array is empty
     */
    public static double calculateAveragePrice(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("Prices array cannot be null or empty");
        }
        
        double sum = 0;
        for (int price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    /**
     * Finds the maximum stock price.
     *
     * @param prices Array of stock prices
     * @return The maximum price among the array elements
     * @throws IllegalArgumentException if the array is empty
     */
    public static int findMaximumPrice(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("Prices array cannot be null or empty");
        }
        
        int max = prices[0];
        for (int price : prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    /**
     * Counts how many times a specific price occurs.
     *
     * @param prices Array of stock prices
     * @param targetPrice The price to look for
     * @return The count of occurrences of the target price
     * @throws IllegalArgumentException if the array is empty
     */
    public static int countOccurrences(int[] prices, int targetPrice) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("Prices array cannot be null or empty");
        }
        
        int count = 0;
        for (int price : prices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    /**
     * Computes the cumulative sum (prefix sum) for an ArrayList of stock prices.
     *
     * @param pricesList The ArrayList of stock prices
     * @return A new ArrayList containing the cumulative sum at each position
     * @throws IllegalArgumentException if the list is empty
     */
    public static ArrayList<Integer> computeCumulativeSum(ArrayList<Integer> pricesList) {
        if (pricesList == null || pricesList.isEmpty()) {
            throw new IllegalArgumentException("Prices list cannot be null or empty");
        }
        
        ArrayList<Integer> cumulativeSum = new ArrayList<>();
        int sum = 0;
        for (int price : pricesList) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }

    /**
     * Main method for testing the methods.
     */
    public static void main(String[] args) {
        try {
            // Example array of stock prices
            int[] stockPricesArray = {100, 200, 150, 300, 250};

            // Convert the array into an ArrayList for the cumulative sum function
            ArrayList<Integer> stockPricesList = new ArrayList<>();
            for (int price : stockPricesArray) {
                stockPricesList.add(price);
            }

            // Calculate all metrics
            double averagePrice = calculateAveragePrice(stockPricesArray);
            int maximumPrice = findMaximumPrice(stockPricesArray);
            int targetPrice = 150;
            int occurrenceCount = countOccurrences(stockPricesArray, targetPrice);
            ArrayList<Integer> cumulativeSum = computeCumulativeSum(stockPricesList);

            // Output the results with formatted strings
            System.out.println("Stock Analysis Results:");
            System.out.println("----------------------");
            System.out.printf("Stock Prices: %s%n", Arrays.toString(stockPricesArray));
            System.out.printf("Average Stock Price: %.2f%n", averagePrice);
            System.out.printf("Maximum Stock Price: %d%n", maximumPrice);
            System.out.printf("Occurrences of %d: %d%n", targetPrice, occurrenceCount);
            System.out.printf("Cumulative Sum: %s%n", cumulativeSum);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}