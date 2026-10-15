# 3.6 Fail-fast iterators

**Topic:** Collections · **Level:** Core  
**Module:** `03-collections/ex06-fail-fast` · **Package:** `com.javacore.collections.ex06`

## Goal

Understand `ConcurrentModificationException`, its strange edge case, and the safe ways to remove while iterating.

## Task

Remove even numbers from a list: one broken way and three correct ways.

## Requirements

- `static void removeEvensBroken(List<Integer> list)` removes inside a for-each loop.
- `static void removeEvensWithIterator(List<Integer> list)` uses `Iterator.remove`.
- `static void removeEvensWithRemoveIf(List<Integer> list)`.
- `static void removeEvensFromCopy(List<Integer> list)` iterates over a copy and removes from the original.
- All methods modify the given list in place.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex06`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `removeEvensBroken` on a mutable `[1, 2, 3, 4, 5, 6]` throws `ConcurrentModificationException`.
- [ ] `removeEvensBroken` on `[1, 2, 3]` does **not** throw, and the list becomes `[1, 3]`. Assert this surprising behavior, and explain it in Notes.
- [ ] The three correct methods give `[1, 3, 5]`, and handle an empty list and an all-even list.
- [ ] Passing `List.of(...)` throws `UnsupportedOperationException`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. How does the iterator detect modification (`modCount`)?
2. Why does removing `2` from `[1, 2, 3]` not throw, and why is element `3` never visited?
3. Is the fail-fast check a guarantee? What does the Javadoc say?

## Run

```bash
mvn -pl 03-collections/ex06-fail-fast -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.6): fail-fast iterators`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
