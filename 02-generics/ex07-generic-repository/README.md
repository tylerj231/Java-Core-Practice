# 2.7 Generic repository

**Topic:** Generics · **Level:** Core  
**Module:** `02-generics/ex07-generic-repository` · **Package:** `com.javacore.generics.ex07`

## Goal

Use generics to write data-access code once for any entity type, the same idea as Spring Data's `CrudRepository<T, ID>`.

## Task

Build an in-memory repository that works for any entity with an id.

## Requirements

- `interface Identifiable<ID> { ID id(); }` (named `id()` so records implement it naturally).
- `interface Repository<T, ID>` with `T save(T entity)`, `Optional<T> findById(ID id)`, `List<T> findAll()`, `boolean deleteById(ID id)` and `long count()`.
- `class InMemoryRepository<T extends Identifiable<ID>, ID> implements Repository<T, ID>`, backed by a `LinkedHashMap` so `findAll` returns entities in insertion order.
- `save` replaces an existing entity with the same id (keeping its original position). Saving an entity with a `null` id throws `IllegalArgumentException`.
- `findAll` returns an unmodifiable copy.
- Two entities with different id types: `record User(Long id, String email) implements Identifiable<Long>` and `record Product(String sku, String name) implements Identifiable<String>` (its `id()` returns `sku`).

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/generics/ex07`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] Save, find, count and delete for `User`.
- [ ] The same for `Product` with `String` ids.
- [ ] Saving the same id twice replaces the entity and keeps the count and order.
- [ ] `findAll` is in insertion order and can't be modified.
- [ ] `deleteById` of a missing id returns `false`.
- [ ] A `null` id throws.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why does `InMemoryRepository` need the bound `T extends Identifiable<ID>` but `Repository` doesn't?
2. Look up Spring Data's `CrudRepository` and `ListCrudRepository`. Which methods match yours?

## Run

```bash
mvn -pl 02-generics/ex07-generic-repository -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(2.7): generic repository`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
