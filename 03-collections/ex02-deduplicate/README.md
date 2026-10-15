# 3.2 Deduplicate

**Topic:** Collections · **Level:** Warm-up  
**Module:** `03-collections/ex02-deduplicate` · **Package:** `com.javacore.collections.ex02`

## Goal

Choose the right `Set` for the ordering you need, and see how a comparator defines equality in a `TreeSet`.

## Task

Remove duplicates from a list in four different ways.

## Requirements

- `static List<String> keepOrder(List<String> items)`: first occurrence order (`LinkedHashSet`).
- `static List<String> sorted(List<String> items)`: natural order (`TreeSet`).
- `static Set<String> anyOrder(List<String> items)` (`HashSet`).
- `static List<String> ignoreCaseKeepFirst(List<String> items)`: `"Java"` and `"JAVA"` are duplicates, keep the first spelling, keep first-occurrence order.
- None of the methods modify the input. `null` elements are allowed in `keepOrder` and `anyOrder` but not in `sorted` (document what happens in Notes).

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex02`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Each method on `["b", "a", "b", "c", "a"]`.
- [ ] `ignoreCaseKeepFirst(["Java", "kotlin", "JAVA", "Kotlin"])` gives `["Java", "kotlin"]`.
- [ ] The input list is unchanged after each call.
- [ ] `sorted` with a `null` element throws `NullPointerException`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. `new TreeSet<>(String.CASE_INSENSITIVE_ORDER)` treats `"A"` and `"a"` as the same element even though `"A".equals("a")` is false. Why? What does the `TreeSet` Javadoc say about comparators consistent with equals?
2. Why can't `ignoreCaseKeepFirst` simply use that `TreeSet`?

## Run

```bash
mvn -pl 03-collections/ex02-deduplicate -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.2): deduplicate`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
