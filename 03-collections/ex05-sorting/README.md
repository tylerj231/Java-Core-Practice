# 3.5 Comparable and Comparator chains

**Topic:** Collections · **Level:** Core  
**Module:** `03-collections/ex05-sorting` · **Package:** `com.javacore.collections.ex05`

## Goal

Build multi-level sort orders with `Comparator` combinators, and avoid the `reversed()` trap.

## Task

Sort employees for a report.

## Requirements

- `record Employee(long id, String name, String department, BigDecimal salary, LocalDate hireDate) implements Comparable<Employee>`, with natural order by `id`.
- `static Comparator<Employee> reportOrder()`: department ascending with `null` departments last, then salary descending, then name ascending.
- `static List<Employee> sortForReport(List<Employee> employees)` returns a new sorted list and never modifies the input.
- `static List<Employee> topEarners(List<Employee> employees, int n)`: salary descending, ties by earlier hire date.
- Use `Comparator.comparing`, `thenComparing`, `Comparator.reverseOrder()` and `Comparator.nullsLast`. No hand-written `compare` bodies.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex05`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] A fixture of about 8 employees across 3 departments plus one with a `null` department: `containsExactly` on ids in the expected order.
- [ ] The input list is unchanged.
- [ ] Natural order sorts by id.
- [ ] `topEarners` tie-break by hire date.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. What does `comparing(Employee::department).thenComparing(Employee::salary).reversed()` actually do? Why is it a common bug?
2. When should a class implement `Comparable`, and when should you pass a `Comparator`?

## Run

```bash
mvn -pl 03-collections/ex05-sorting -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.5): comparable and comparator chains`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
