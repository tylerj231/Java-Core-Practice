# 3.3 Choose the right collection

**Topic:** Collections · **Level:** Warm-up  
**Module:** `03-collections/ex03-choose-the-collection` · **Package:** `com.javacore.collections.ex03`

## Goal

Pick collections by the operations a feature needs, and back each choice with Big-O.

## Task

Build three small components. For each, choose the backing collection and justify it.

## Requirements

- `RecentSearches(int capacity)`: `add(String query)`, `List<String> list()` with the most recent first. No duplicates: re-adding moves the query to the front. When full, the oldest entry is evicted.
- `Leaderboard`: `submit(String player, int score)` keeps only each player's best score. `List<String> top(int n)` orders by score descending, then name ascending. `OptionalInt rankOf(String player)` is 1-based and empty for unknown players.
- `UndoHistory<T>`: `push(T state)`, `Optional<T> undo()`, `Optional<T> redo()`. A new `push` clears the redo history. Use `ArrayDeque`, not `Stack`.
- In Notes, fill in this table from memory first, then check against the JDK docs: the complexity of `get(index)`, `add` (at end), `remove(Object)` and `contains` for `ArrayList`, `LinkedList`, `HashSet`, `TreeSet`, `HashMap` (by key) and `ArrayDeque`. Write `n/a` where the operation doesn't exist.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex03`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] `RecentSearches` with capacity 3: order, moving a repeated query to the front, eviction.
- [ ] `Leaderboard`: a lower later score doesn't replace a better one, ties ordered by name, `rankOf` for known and unknown players.
- [ ] `UndoHistory`: undo and redo sequence, redo cleared after a new push, undo on empty returns empty.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Justify each backing collection you chose in one or two sentences, with the Big-O of its main operations.
2. Why is `java.util.Stack` discouraged?

## Run

```bash
mvn -pl 03-collections/ex03-choose-the-collection -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.3): choose the right collection`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
