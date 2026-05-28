package Rebalance;

import org.testng.Assert;
import org.testng.annotations.Test;

import Rebalancer.Rebalancer;

/*
 * 
 *  Portfolio rebalance calculations
 */

public class RebalancerTest {

    /*
     * Verify BUY calculation
     */
    @Test
    public void testIBMBuy() {

        String result =
                Rebalancer.calculateShares(
                        100000,
                        20,
                        10,
                        150);

        Assert.assertEquals(
                result,
                "BUY 67 shares");
    }

    /*
     * Verify SELL calculation
     */
    @Test
    public void testORCLSell() {

        String result =
                Rebalancer.calculateShares(
                        100000,
                        20,
                        30,
                        220);

        Assert.assertEquals(
                result,
                "SELL 45 shares");
    }

    /*
     * Verify HOLD calculation
     */
    @Test
    public void testMSFTHold() {

        String result =
                Rebalancer.calculateShares(
                        100000,
                        20,
                        20,
                        90);

        Assert.assertEquals(
                result,
                "HOLD 0 shares");
    }

    /*
     * Verify invalid unit price
     */
    @Test
    public void testInvalidPrice() {

        String result =
                Rebalancer.calculateShares(
                        100000,
                        20,
                        10,
                        0);

        Assert.assertEquals(
                result,
                "Invalid unit price");
    }

    /*
     * Verify invalid total asset
     */
    @Test
    public void testInvalidAsset() {

        String result =
                Rebalancer.calculateShares(
                        0,
                        20,
                        10,
                        150);

        Assert.assertEquals(
                result,
                "Invalid total asset");
    }
}