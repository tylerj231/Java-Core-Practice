# 3.9 Build your own HashMap

**Topic:** Collections · **Level:** Challenge  
**Module:** `03-collections/ex09-my-hashmap` · **Package:** `com.javacore.collections.ex09`

## Goal

Understand hashing, buckets, collisions and resizing by implementing them.

## Task

Implement a hash map with separate chaining.

## Requirements

- `class MyHashMap<K, V>` with `V put(K key, V value)` (returns the previous value or `null`), `V get(Object key)`, `V remove(Object key)`, `boolean containsKey(Object key)` and `int size()`.
- An array of buckets, each a singly linked list of nodes storing key, value, hash and next.
- Initial capacity 16, always a power of two. Pick the bucket with `(capacity - 1) & hash`. Spread the hash like the JDK does: `h ^ (h >>> 16)`.
- When `size` exceeds `capacity × 0.75` after an insertion, double the capacity and rehash every node.
- Support one `null` key, like `java.util.HashMap`.
- A package-private `int capacity()` for tests.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex09`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Put, get, overwrite (returns the old value), remove, `containsKey` and size.
- [ ] `null` key.
- [ ] Capacity is 16 after 12 entries and 32 after 13.
- [ ] 10,000 random entries match a `java.util.HashMap` given the same operations.
- [ ] A `BadKey` class whose `hashCode()` always returns 1 still works correctly (just slowly).

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why must the capacity be a power of two for `(capacity - 1) & hash` to work?
2. What does Java 8+ `HashMap` do when one bucket gets too many nodes? (Look up `TREEIFY_THRESHOLD` and `MIN_TREEIFY_CAPACITY`.)
3. Why should keys be immutable?

## Run

```bash
mvn -pl 03-collections/ex09-my-hashmap -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.9): build your own hashmap`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
