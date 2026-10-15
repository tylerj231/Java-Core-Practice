# 1.9 Payment plugins

**Topic:** Interfaces and abstract classes · **Level:** Challenge  
**Module:** `01-interfaces-abstract-classes/ex09-payment-plugins` · **Package:** `com.javacore.interfaces.ex09`

## Goal

Design an extension point where new behavior is added without changing existing code.

## Task

Build a checkout that works with any payment method, including ones that don't exist yet.

## Requirements

- `interface PaymentMethod` with `String id()`, `default BigDecimal fee(BigDecimal amount)` returning zero, and `default Optional<BigDecimal> maxAmount()` returning empty (no limit).
- `Card`: fee 2% of the amount, maximum amount 10,000.
- `BankTransfer`: flat fee of 1.50, no limit.
- `Crypto`: fee 1% with a minimum of 0.50.
- All fees have scale 2 with `RoundingMode.HALF_UP`.
- `record Receipt(BigDecimal amount, BigDecimal fee, BigDecimal total, String methodId)`.
- `Checkout.pay(BigDecimal amount, PaymentMethod method)` returns a `Receipt`. It throws `IllegalArgumentException` for amounts of zero or less, or above the method's maximum.
- `PaymentMethods` registry: `register(PaymentMethod)`, `Optional<PaymentMethod> find(String id)`. Registering a duplicate id throws `IllegalStateException`.
- `Checkout` must not contain any `if`, `switch` or `instanceof` on the method type.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/interfaces/ex09`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Fees: card on 100.00 is 2.00, transfer is always 1.50, crypto on 20.00 is 0.50 (minimum) and on 200.00 is 2.00.
- [ ] Receipt total is amount + fee.
- [ ] Card payment above 10,000 throws. Bank transfer of 1,000,000 works.
- [ ] Zero and negative amounts throw.
- [ ] A `GiftCard` method defined only in the test class works with `Checkout` without changing it.
- [ ] Registry lookup, missing id, and duplicate registration.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Which SOLID principle does this demonstrate, and how?
2. Why use `default` methods for `fee` and `maxAmount` rather than an abstract base class?
3. How would Spring let you inject all `PaymentMethod` beans into the registry automatically?

## Run

```bash
mvn -pl 01-interfaces-abstract-classes/ex09-payment-plugins -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(1.9): payment plugins`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
