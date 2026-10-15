# 1.5 Template method

**Topic:** Interfaces and abstract classes · **Level:** Core  
**Module:** `01-interfaces-abstract-classes/ex05-template-method` · **Package:** `com.javacore.interfaces.ex05`

## Goal

Use an abstract class to fix an algorithm's structure while letting subclasses fill in the steps.

## Task

Build exporters that turn a list of strings into CSV and HTML.

## Requirements

- `abstract class DataExporter` with `public final String export(List<String> rows)`.
- `export` produces: the `header()` line, then one `formatRow(row)` line per row, then the `footer()` line if it's not empty. Lines are joined with `"\n"`, with no trailing newline.
- Steps: `protected abstract String header()`, `protected abstract String formatRow(String row)`, and a hook `protected String footer()` that returns `""` by default.
- `CsvExporter`: header `"value"`. A row containing a comma, a double quote or a newline is wrapped in double quotes, and inner double quotes are doubled (RFC 4180). Other rows are written as they are.
- `HtmlExporter`: header `"<ul>"`, rows `"  <li>" + escaped + "</li>"`, footer `"</ul>"`. Escape `&`, `<` and `>` as `&amp;`, `&lt;` and `&gt;` (escape `&` first).
- `export(null)` throws `NullPointerException`.

## Example

```java
new CsvExporter().export(List.of("a", "b,c", "say \"hi\""));
// value
// a
// "b,c"
// "say ""hi"""
```

## Required tests

Write these as JUnit 5 tests in `src/test/java/com/javacore/interfaces/ex05`. Use AssertJ for assertions. Add more tests for any edge case you find.

- [ ] CSV with plain rows.
- [ ] CSV row with a comma, with quotes, and with a newline.
- [ ] HTML escaping of `<b>Tom & Jerry</b>` gives `&lt;b&gt;Tom &amp; Jerry&lt;/b&gt;`.
- [ ] Empty list: CSV gives `"value"`, HTML gives `"<ul>\n</ul>"`.
- [ ] `export(null)` throws `NullPointerException`.

## Explain

Answer in your own words in the **Notes** section at the end of this file.

1. Why should `export` be `final`?
2. What's the difference between an abstract step and a hook like `footer()`?
3. Could this be done with interfaces and composition instead? Sketch how.

## Run

```bash
mvn -pl 01-interfaces-abstract-classes/ex05-template-method -am test
```

## Definition of done

- [ ] Every requirement is implemented in `src/main/java`
- [ ] Every required test is written and passing
- [ ] The Explain questions are answered in Notes
- [ ] Committed (for example `feat(1.5): template method`) and pushed to GitHub, with CI green

## Notes

_Your answers to the Explain questions, compiler errors you recorded, and anything you learned._
