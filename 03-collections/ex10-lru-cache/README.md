# 3.10 LRU cache, two ways

**Topic:** Collections · **Level:** Challenge  
**Module:** `03-collections/ex10-lru-cache` · **Package:** `com.javacore.collections.ex10`

## Goal

Implement a classic interview problem, first with the JDK and then from scratch, and test both with one contract test.

## Task

Build a fixed-size least-recently-used cache.

## Requirements

- `interface Cache<K, V>` with `Optional<V> get(K key)`, `void put(K key, V value)` and `int size()`.
- Both `get` and `put` count as use. When full, inserting a new key evicts the least recently used one. A capacity below 1 throws `IllegalArgumentException`.
- `LinkedHashMapLruCache` extends or wraps a `LinkedHashMap` with `accessOrder = true` and overrides `removeEldestEntry`.
- `ManualLruCache` uses a `HashMap` plus your own doubly linked list, with O(1) `get` and `put`.

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/collections/ex10`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Write an `abstract class CacheContractTest` with `protected abstract Cache<String, Integer> create(int capacity)`, plus two small subclasses, one per implementation. Every test runs against both.
- [ ] Eviction of the least recently used key.
- [ ] `get` refreshes recency. `put` on an existing key updates the value and refreshes recency without growing the size.
- [ ] Capacity 1. Capacity 0 throws.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why does the manual version need a *doubly* linked list and a map?
2. What would you change to make the cache thread-safe?

## Run

```bash
mvn -pl 03-collections/ex10-lru-cache -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(3.10): lru cache, two ways`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
