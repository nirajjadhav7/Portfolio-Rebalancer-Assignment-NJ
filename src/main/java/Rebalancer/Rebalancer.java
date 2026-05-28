package Rebalancer;

/*
 * 
 *
 * This class calculates how many shares
 * need to be bought or sold to match
 * the target allocation.
 */

public class Rebalancer {

    /*
     * Method to calculate rebalance action
     */
    public static String calculateShares(

            double totalAsset,
            double targetPercent,
            double currentPercent,
            double unitPrice) {

        /*
         * Validate inputs
         */
        if (totalAsset <= 0) {
            return "Invalid total asset";
        }

        if (unitPrice <= 0) {
            return "Invalid unit price";
        }

        /*
         * Calculate target value
         */
        double targetValue =
                totalAsset * (targetPercent / 100);

        /*
         * Calculate current value
         */
        double currentValue =
                totalAsset * (currentPercent / 100);

        /*
         * Difference between target and current
         */
        double difference =
                targetValue - currentValue;

        /*
         * HOLD condition
         */
        if (difference == 0) {
            return "HOLD 0 shares";
        }

        /*
         * Calculate shares
         */
        int shares =
                (int) Math.round(
                        Math.abs(difference) / unitPrice);

        /*
         * BUY condition
         */
        if (difference > 0) {

            return "BUY " + shares + " shares";
        }

        /*
         * SELL condition
         */
        return "SELL " + shares + " shares";
    }

    /*
     * Main method for quick testing
     */
    public static void main(String[] args) {

        System.out.println(
                calculateShares(
                        100000,
                        20,
                        30,
                        220));
    }
}