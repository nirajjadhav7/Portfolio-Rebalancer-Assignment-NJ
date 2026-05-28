# Portfolio Rebalancer Project

## Project Description
This application calculates buy/sell shares to rebalance a portfolio.

---

## Assumptions
- No fractional shares
- Rounded to nearest integer
- No transaction fees
- Static prices

---

## Manual Test Cases

### Functional Test Cases

TC-FUNC-001: Verify BUY scenario
Input: IBM 10% → 20%, price = 150  
Expected: BUY 67 shares

---

TC-FUNC-002: Verify SELL scenario
Input: ORCL 30% → 20%, price = 220  
Expected: SELL 45 shares

---

### Boundary Test Cases

TC-BND-001: Zero portfolio value  
Expected: Validation error

TC-BND-002: Very high stock price  
Expected: Correct calculation without overflow

---

### Negative Test Cases

TC-NEG-001: Negative price  
Expected: Error message

TC-NEG-002: Invalid percentage (>100)  
Expected: Validation failure

---

## Automated Tests
- TestNG used for unit testing
- Selenium used for UI validation
- DataProvider used for data-driven testing