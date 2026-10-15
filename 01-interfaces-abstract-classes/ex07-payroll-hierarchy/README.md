# 1.7 Payroll hierarchy

**Topic:** Interfaces and abstract classes · **Level:** Core  
**Module:** `01-interfaces-abstract-classes/ex07-payroll-hierarchy` · **Package:** `com.javacore.interfaces.ex07`

## Goal

Design a hierarchy that mixes interfaces and abstract classes, and justify each choice.

## Task

Model the people a company pays and calculate monthly payroll.

## Requirements

- `interface Payable { BigDecimal monthlyPay(); }`.
- `abstract class Employee implements Payable` with `id`, `name`, `hireDate` and `monthlySalary` (`BigDecimal`).
- `Engineer extends Employee`: pay = salary.
- `Manager extends Employee` with a list of direct reports: pay = salary + 5% of salary per report, with the bonus capped at 25%.
- `Contractor implements Payable` (not an employee): pay = hourly rate × hours worked this month.
- `Intern implements Payable`: a fixed monthly stipend.
- All pay values have scale 2 with `RoundingMode.HALF_EVEN`.
- `Payroll.total(List<? extends Payable> people)` returns the sum. `Payroll.longServing(List<? extends Employee> employees, LocalDate today, int years)` returns employees with at least that many full years of service.

## Example

```java
new Contractor("Ann", new BigDecimal("25.50"), 40).monthlyPay(); // 1020.00
// Manager with salary 4000 and 3 reports -> 4600.00
// Manager with salary 4000 and 6 reports -> 5000.00 (capped)
```

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/interfaces/ex07`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Contractor: 40 hours at 25.50 gives `1020.00`.
- [ ] Manager with 0, 3 and 6 reports (6 reports hits the cap).
- [ ] `total` over a mix of all four types.
- [ ] `longServing` includes someone hired exactly `years` ago and excludes someone one day short.
- [ ] Compare `BigDecimal` values with `isEqualByComparingTo`, and also check the scale is 2.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why is `Payable` an interface while `Employee` is an abstract class?
2. If contractors also needed an `id` and `name`, would you make `Contractor` extend `Employee`? What would you do instead?
3. Why `BigDecimal` and not `double` for money?

## Run

```bash
mvn -pl 01-interfaces-abstract-classes/ex07-payroll-hierarchy -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(1.7): payroll hierarchy`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
