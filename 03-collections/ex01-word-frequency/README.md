# 3.1 Word frequency

**Topic:** Collections · **Level:** Warm-up  
**Module:** `03-collections/ex01-word-frequency` · **Package:** `com.javacore.collections.ex01`

## Goal

Count with a map, and know the ordering guarantees of `HashMap`, `TreeMap` and `LinkedHashMap`.

## Task

Count how often each word appears in a text and present the counts in different orders.

## Requirements

- `static Map<String, Integer> count(String text)`: lowercase the text, split on anything that isn't a letter (regex `\P{L}+`, written `"\\P{L}+"` in Java, so Ukrainian and other non-Latin words work), and ignore empty tokens.
- Use `Map.merge` to count. No `containsKey` + `put`.
- `static SortedMap<String, Integer> alphabetical(String text)` backed by a `TreeMap`.
- `static Map<String, Integer> firstSeenOrder(String text)` backed by a `LinkedHashMap`.
- `static List<Map.Entry<String, Integer>> topN(String text, int n)`: by count descending, ties alphabetically.
- A `null` text throws `NullPointerException`. An empty or punctuation-only text gives an empty result.

## Example

```java
count("The cat and the hat.");      // {the=2, cat=1, and=1, hat=1} (any order)
firstSeenOrder("b a b");             // {b=2, a=1}
topN("b a b c c c", 2);              // [c=3, b=2]
```

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex01`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Counts are case-insensitive and ignore punctuation.
- [ ] Non-Latin text: `"Привіт, світ! Привіт"` gives `привіт=2, світ=1`.
- [ ] `alphabetical` keys are sorted. `firstSeenOrder` keeps first-appearance order (check with `containsExactly`).
- [ ] `topN` breaks ties alphabetically, and `n` larger than the number of words returns all.
- [ ] Empty text and `null`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. What ordering does each of `HashMap`, `TreeMap` and `LinkedHashMap` guarantee, and at what cost?
2. Why is relying on `HashMap` iteration order a bug even if your test passes today?

## Run

```bash
mvn -pl 03-collections/ex01-word-frequency -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.1): word frequency`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
