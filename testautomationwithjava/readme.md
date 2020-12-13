# Test automation with Java

- [Introduction](#introduction)
- [Test Design](#test-design)
- [IDE](#ide)
- [Maven](#maven)
- [JUnit 5 and AssertJ](#junit-5-and-assertj)
- [Jdbi](#jdbi)
- [REST Assured](#rest-assured)
- [Selenide](#selenide)
- [Allure Framework](#allure-framework)

## Introduction

This is a limited and opinionated approach to test automation.

- The only programming language used is Java (with a bit of SQL).
- The scope is limited to web applications with a REST API and a relational database (for now).
- Tools and libraries work well together.
- Test code is clear, consistent and maintainable.
- Beautiful test reports are important.
- Domain experts do not write tests.

Why?

Imagine that you are a test automation engineer in a project with a Java backend. Domain experts are deeply involved,
but not interested in writing test specifications: that is your job. You really like to involve stakeholders with nice
test reports. The developers in your team are fluent in Java and not interested losing themselves in tools
like [FitNesse](http://fitnesse.org/) or [Robot Framework](https://robotframework.org/).

If you are not afraid to improve your Java skills, and if you like to work together with the developers in your team on
the test automation tasks, why not go Java all the way? The tools are perfect, the libraries well maintained, the test
reports beautiful, and you can work on it with the whole team.

What about [Cucumber](https://cucumber.io/)?

If you have domain experts who want to write feature files in Gherkin syntax, then you are really lucky. In that case it
is definitely a good choice to invest in coding Cucumber step definitions. If you do not have such domain experts,
adding Cucumber to your project is just overhead.

## Test Design

Easy to read and easy to maintain, that are the important characteristics of well-designed tests. These best practices
helps you to achieve exactly that.

### Separate steps from assertions

Every test contains one or more steps and on or more assertions. A step is an action in a test scenario implemented as a method on a Page object, or an Api object. Assertions are utility methods to support asserting conditions in tests. Maybe it is best to show an example.

```java
import java.util.List;

public class SearchPageObject {

    public List<String> searchFor(String term) {
        // TODO write code that opens the webpage and does a search
        return null;
    }
}
``` 

```java
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {
    SearchPageObject search = new SearchPageObject();

    @Test
    void searchForSong() {
        List<String> result = search.searchFor("blue suede shoes performing artist");  // 1.
        assertThat(result).containsAnyOf("Elvis Presley"); // 2.
    }
}
```

1. A step is performed by calling a method on the page object.
2. Assert a condition by using a utility method from AssertJ.

The term page object is [described by Martin Fowler](https://www.martinfowler.com/bliki/PageObject.html). 

### Write simple steps

A page object can have multiple little methods that do something on a webpage or part of the webpage. Note that the underlying technology (in this case maybe a Selenium call) is hidden from the unit test. The page object does not do any assertions, that is the responsibility of the unit test.

There can be another kind of objects that contain steps, for example an API object that is responsible for calling the REST API with an HTTP client.

By creating simple steps, they are easy to maintain, read and reuse.

### Write self-contained tests

To promote the maintainability of the unit tests, it is important that the tests are self-contained. Every test can be run individually and is not dependent of other test, or a specific test order.  A change in one test, does not lead to breaking changes in other tests.

Always try to do test setup as much as possible in the unit test method itself.

## IDE

## Maven

## JUnit 5 and AssertJ

## Jdbi

## REST Assured

## Selenide

## Allure Framework

<br /><br /><br />
<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br />
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons
Attribution-NonCommercial-ShareAlike 4.0 International License</a>.

