# Portfolio Rebalancer

## Overview
This is a simple portfolio rebalancing application which calculates whether we need to buy or sell shares based on target vs current allocation.

The goal is to bring all securities back to equal target allocation by adjusting holdings.

---

## Assumptions / Notes
While implementing and testing this, I considered the following assumptions:

- Fractional shares are not allowed, so results are rounded to nearest whole number
- No brokerage/transaction fees are included in calculation
- Portfolio total value is assumed to remain constant during rebalancing
- Prices are assumed to be static during execution
- Percentage values provided are valid inputs for target and current allocation

---

## Manual Test Cases

### Functional Scenarios

TC-FUNC-001 – BUY scenario verification  
Input: IBM (10% → 20%), price = 150  
Expected Result: BUY 67 shares  
Purpose: Validate correct buy calculation when target is higher than current

---

TC-FUNC-002 – SELL scenario verification  
Input: ORCL (30% → 20%), price = 220  
Expected Result: SELL 45 shares  
Purpose: Validate correct sell calculation when current exceeds target

---

TC-FUNC-003 – HOLD scenario
Input: MSFT (20% → 20%)  
Expected Result: HOLD 0 shares  
Purpose: To ensure no trade is generated when portfolio is already balanced

---

TC-FUNC-004 – Full portfolio rebalancing  
Input: All securities together (IBM, MSFT, ORCL, AAPL, HD)  
Expected Result: Correct BUY/SELL/HOLD for all securities  
Purpose: To validate end-to-end portfolio processing

---

TC-FUNC-005 – Extreme imbalance scenario  
Input: One security heavily under/over weighted  
Expected Result: Large buy or sell quantity generated  
Purpose: To validate system behavior under extreme allocation differences



### Boundary Scenarios

TC-BND-001 – Zero portfolio value  
Input: total asset = 0  
Expected Result: System should reject input / show validation error

---

TC-BND-002 – High stock price scenario  
Input: very high unit price (e.g., 1,000,000)  
Expected Result: Calculation should still return valid small share value without errors

---

TC-BND-003 – Very low stock price  
Input: price = 0.01  
Expected Result: Large number of shares calculated correctly  
Purpose: To validate precision handling

---

TC-BND-004 – Very high stock price  
Input: price = 10,000,000  
Expected Result: Small share quantity calculated correctly  
Purpose: To validate division accuracy

---

TC-BND-005 – Decimal percentage values  
Input: 20.5% vs 19.3%  
Expected Result: Accurate proportional calculation  
Purpose: To validate floating-point percentage handling

---

TC-BND-006 – Rounding down case  
Input: 66.4 shares  
Expected Result: 66 shares  
Purpose: To validate rounding logic

---

TC-BND-007 – Rounding up case  
Input: 66.5 shares  
Expected Result: 67 shares  
Purpose: To validate correct rounding behavior




### Negative Scenarios

TC-NEG-001 – Invalid negative price  
Input: price = -150  
Expected Result: Validation error should be shown

---

TC-NEG-002 – Invalid percentage value  
Input: target percentage > 100  
Expected Result: System should not process request and show validation failure

---

TC-NEG-003 – Target percentage greater than 100 
Input: 120%  
Expected Result: Validation failure  
Purpose: To enforce valid allocation constraints

---

TC-NEG-004 – Current percentage greater than 100  
Input: 150%  
Expected Result: Validation failure  
Purpose: To ensure portfolio consistency

---

TC-NEG-005 – Missing input values
Input: null / empty fields  
Expected Result: Error message displayed  
Purpose: To validate required field handling

---

TC-NEG-006 – Non-numeric input
Input: “ABC”  
Expected Result: Input rejected  
Purpose: To validate type safety


## Business Logic Scenarios

TC-BUS-001 – Small variance scenario
Input: 20% → 21%  
Expected Result: Small BUY adjustment  
Purpose: To validate sensitivity to minor allocation changes

---

TC-BUS-002 – High variance scenario  
Input: 10% → 90%  
Expected Result: Large BUY/SELL adjustment  
Purpose: To validate extreme portfolio correction

---

TC-BUS-003 – Floating-point precision check 
Input: 20.0000001 vs 20  
Expected Result: HOLD  
Purpose: To handle precision-related edge cases


## UI Test Scenarios (Selenium)

TC-UI-001 – Valid input submission through UI  
Expected Result: Correct BUY/SELL/HOLD displayed  
Purpose: To validate end-to-end UI flow

---

TC-UI-002 – Empty form submission  
Expected Result: Validation error shown  
Purpose: To validate frontend validation

---

TC-UI-003 – Invalid numeric input in UI fields  
Expected Result: Error message displayed  
Purpose: To validate input constraints on UI layer


## Regression Scenarios

TC-REG-001 – Rebalancing after code changes  
Expected Result: No existing logic breaks  
Purpose: To ensure stability after updates


## Automated Testing Approach

For automation, I have used:

- TestNG framework for unit test execution
- Selenium WebDriver for UI validation
- DataProvider feature in TestNG for data-driven test coverage
- Assertions to validate BUY/SELL/HOLD outputs against expected results