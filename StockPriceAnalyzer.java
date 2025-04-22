import java.util.ArrayList;

public class StockPriceAnalyzer {

    /**
     * Method to calculate the average stock price.
     * 
     * @param stockPrices An array of integers representing stock prices.
     * @return The average stock price as a double.
     */
    public static double calculateAveragePrice(int[] stockPrices) {
        double sum = 0;
        for (int price : stockPrices) {
            sum += price; // Summing up all stock prices
        }
        return sum / stockPrices.length; // Returning the average
    }

    /**
     * Method to find the maximum stock price.
     * 
     * @param stockPrices An array of integers representing stock prices.
     * @return The maximum stock price as an integer.
     */
    public static int findMaximumPrice(int[] stockPrices) {
        int maxPrice = stockPrices[0]; // Initialize with the first price
        for (int price : stockPrices) {
            if (price > maxPrice) {
                maxPrice = price; // Update maxPrice if a higher price is found
            }
        }
        return maxPrice; // Returning the maximum price
    }

    /**
     * Method to count occurrences of a specific price.
     * 
     * @param stockPrices An array of integers representing stock prices.
     * @param targetPrice The price to count occurrences of.
     * @return The count of occurrences of the target price.
     */
    public static int countOccurrences(int[] stockPrices, int targetPrice) {
        int count = 0;
        for (int price : stockPrices) {
            if (price == targetPrice) {
                count++; // Increment count if the price matches the target
            }
        }
        return count; // Returning the count of occurrences
    }

    /**
     * Method to compute the cumulative sum of stock prices.
     * 
     * @param stockPrices An ArrayList of integers representing stock prices.
     * @return An ArrayList containing the cumulative sum of prices.
     */
    public static ArrayList<Integer> computeCumulativeSum(ArrayList<Integer> stockPrices) {
        ArrayList<Integer> cumulativeSum = new ArrayList<>();
        int sum = 0;
        for (int price : stockPrices) {
            sum += price; // Update the cumulative sum
            cumulativeSum.add(sum); // Add the current cumulative sum to the list
        }
        return cumulativeSum; // Returning the cumulative sum list
    }

    public static void main(String[] args) {
        // Sample data
        int[] stockPricesArray = {100, 200, 150, 300, 250};
        ArrayList<Integer> stockPricesList = new ArrayList<>();
        for (int price : stockPricesArray) {
            stockPricesList.add(price); // Converting array to ArrayList
        }

        // Calculate average price
        double averagePrice = calculateAveragePrice(stockPricesArray);
        System.out.println("Average Stock Price: " + averagePrice);

        // Find maximum price
        int maxPrice = findMaximumPrice(stockPricesArray);
        System.out.println("Maximum Stock Price: " + maxPrice);

        // Count occurrences of a specific price
        int targetPrice = 150;
        int occurrences = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("Occurrences of " + targetPrice + ": " + occurrences);

        // Compute cumulative sum
        ArrayList<Integer> cumulativeSum = computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulativeSum);
    }
}