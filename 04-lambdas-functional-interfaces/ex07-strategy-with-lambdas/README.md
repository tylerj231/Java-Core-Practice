# 4.7 Strategy pattern with lambdas

**Topic:** Lambdas and functional interfaces · **Level:** Core  
**Module:** `04-lambdas-functional-interfaces/ex07-strategy-with-lambdas` · **Package:** `com.javacore.lambdas.ex07`

## Goal

Replace a class-per-strategy design with functions, and know when not to.

## Task

Implement pricing rules as lambdas held in an enum.

## Requirements

- `@FunctionalInterface interface PricingRule { BigDecimal total(BigDecimal unitPrice, int quantity); }`.
- `enum Pricing` whose constants each pass a lambda to the constructor: `NONE` (price × quantity), `PERCENT_10` (10% off), `FIXED_5_OFF` (5.00 off the order, never below zero) and `BUY_2_GET_1` (every third item is free: pay for `quantity - quantity / 3`).
- `BigDecimal Pricing.apply(BigDecimal unitPrice, int quantity)`: results have scale 2, `HALF_UP`. A negative quantity or price throws `IllegalArgumentException`.
- `static Pricing fromCode(String code)` is case-insensitive and throws `IllegalArgumentException` for unknown codes.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/lambdas/ex07`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Each rule with unit price 10.00 and quantities 0, 1, 3 and 7. `BUY_2_GET_1` with 7 items pays for 5.
- [ ] `FIXED_5_OFF` never goes below zero.
- [ ] `fromCode` with mixed case and with an unknown code.
- [ ] Invalid arguments throw.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. When would a class per strategy be better than a lambda? Think about state, complex logic, testing and Spring dependency injection.
2. What does holding lambdas in an enum give you over a `Map<String, PricingRule>`?

## Run

```bash
mvn -pl 04-lambdas-functional-interfaces/ex07-strategy-with-lambdas -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(4.7): strategy pattern with lambdas`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
