# 6. Capstone: in-memory expense tracker

**Topics:** all five · **Level:** Capstone
**Module:** `06-capstone-expense-tracker` · **Package:** `com.javacore.capstone`

## Goal

Combine interfaces, generics, collections, lambdas and streams in one small but realistic application. Keep it: this domain model becomes your portfolio project, moving next to JDBC, then Hibernate, then Spring.

## Requirements

### Model
- Records `Account(Long id, String name, Currency currency)`, `Category(Long id, String name)` and `Transaction(Long id, long accountId, long categoryId, TransactionType type, BigDecimal amount, LocalDate date, String note)`.
- `enum TransactionType { INCOME, EXPENSE }`. Amounts are always positive; the type gives the direction.
- All three records implement an `Identifiable<ID>` interface (reuse the idea from exercise 2.7).

### Storage
- A generic `Repository<T, ID>` and `InMemoryRepository` (copy and adapt your exercise 2.7).
- Assign ids on save when the id is `null`.
- `TransactionRepository` adds `List<Transaction> findByAccount(long accountId)` in O(1) lookup time, using an index kept up to date on save and delete.

### Rules
- `interface TransactionRule { Optional<String> check(Transaction tx, LedgerView ledger); }`, where an empty result means the rule passes.
- Rules: an expense may not take the account balance below zero, no future dates, and the note is at most 140 characters.
- Rules are combined so that all violations are reported together, not just the first.
- Saving a transaction that breaks a rule throws a `RuleViolationException` listing every message.

### Import
- `CsvImporter.importFrom(Path file)` reads lines like `2026-10-01,Main account,Groceries,EXPENSE,42.50,Weekly shop`.
- Invalid lines (bad dates, unknown accounts, broken rules) are skipped and returned in an `ImportReport` with the line number and reason. Valid lines are saved.
- Use your checked-exception wrapper from exercise 4.8 where it fits.

### Reports (streams only)
- Balance per account.
- Spending per category per month (`SortedMap<String, Map<YearMonth, BigDecimal>>`).
- The top 5 expenses in a given month.
- Months where spending exceeded income.
- Average daily spending per category over a date range.

## Required tests

- [ ] Repository: id assignment, find, delete, and the account index staying correct after deletes
- [ ] Each rule on its own, plus a transaction breaking two rules reports both messages
- [ ] CSV import with a mix of valid and invalid lines (use `@TempDir`), checking the `ImportReport`
- [ ] Every report on one fixed, hand-checked data set
- [ ] Money compared with `isEqualByComparingTo`, always scale 2

## Explain

Answer in the **Notes** section below.

1. For every interface vs. abstract class choice, every generic bound and every collection type in your design, write one sentence on why.
2. What will have to change when this moves to a real database with JDBC?

## Run

```bash
mvn -pl 06-capstone-expense-tracker test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Pushed to GitHub, with CI green

## Notes

_Your design decisions and answers._
