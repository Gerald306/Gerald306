import java.util.ArrayList;

public class StockAnalyzer {

    /**
     * Calculates the average stock price.
     *
     * @param prices Array of stock prices
     * @return The average price as a double
     */
    public static double calculateAveragePrice(int[] prices) {
        int sum = 0;
        for (int price : prices) {
            sum += price;
        }
        return (double) sum / prices.length;
    }

    /**
     * Finds the maximum stock price.
     *
     * @param prices Array of stock prices
     * @return The maximum price among the array elements
     */
    public static int findMaximumPrice(int[] prices) {
        int max = prices[0];  // initialize with the first element
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
     */
    public static int countOccurrences(int[] prices, int targetPrice) {
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
     */
    public static ArrayList<Integer> computeCumulativeSum(ArrayList<Integer> pricesList) {
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
        // Example array of stock prices
        int[] stockPricesArray = {100, 200, 150, 300, 250};

        // Convert the array into an ArrayList for the cumulative sum function
        ArrayList<Integer> stockPricesList = new ArrayList<>();
        for (int price : stockPricesArray) {
            stockPricesList.add(price);
        }

        double averagePrice = calculateAveragePrice(stockPricesArray);
        int maximumPrice = findMaximumPrice(stockPricesArray);
        int targetPrice = 150;
        int occurrenceCount = countOccurrences(stockPricesArray, targetPrice);
        ArrayList<Integer> cumulativeSum = computeCumulativeSum(stockPricesList);

        // Output the results
        System.out.println("Average Stock Price: " + averagePrice);
        System.out.println("Maximum Stock Price: " + maximumPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrenceCount);
        System.out.println("Cumulative Sum: " + cumulativeSum);
    }
}
