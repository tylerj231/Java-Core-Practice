# 5.5 flatMap

**Topic:** Stream API · **Level:** Core  
**Module:** `05-stream-api/ex05-flatmap` · **Package:** `com.javacore.streams.ex05`

## Goal

Flatten nested data with `flatMap`.

## Task

Answer questions that need to look inside orders and sentences.

This exercise uses the shared domain model from [`05-stream-api/shop-model`](../shop-model/README.md). In tests, build small hand-made fixtures so you can assert exact results.

## Requirements

- `static Set<Product> distinctProductsOrdered(List<Order> orders)`.
- `static SortedSet<String> categoriesBoughtBy(List<Order> orders, long customerId)`, using `Collectors.toCollection(TreeSet::new)`. Exclude cancelled orders.
- `static List<String> words(List<String> sentences)`: all words, lowercased, in order.
- `static Map<Long, Set<String>> categoriesPerCustomer(List<Order> orders)`: customer id to all categories they bought.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/streams/ex05`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Products appearing in several orders appear once.
- [ ] `categoriesBoughtBy` is sorted and ignores cancelled orders and other customers.
- [ ] `words` handles extra whitespace.
- [ ] `categoriesPerCustomer` for 2–3 customers.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. What would `map` return instead of `flatMap` in `distinctProductsOrdered`?
2. Java 16 added `mapMulti`. When can it be a better choice than `flatMap`?

## Run

```bash
mvn -pl 05-stream-api/ex05-flatmap -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(5.5): flatmap`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
