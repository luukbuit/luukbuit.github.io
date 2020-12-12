# Test automation with Java

- [Introduction](#introduction)
- [Something else](#something-else)

## Introduction

This is a limited and opinionated approach to test automation.

1. The only programming language used is Java (with a bit of SQL).
2. The automated tests are targeted at web applications with a REST API and a relational database.
3. A well-matched set of tools and libraries is used.
4. The design of the test code keeps everything clear and maintainable.



```java
import java.time.LocalDate;
import java.util.Objects;

class ExampleOfSomething {
    private static String getEnv(String environmentVariable, LocalDate defaultValue) {
        String env = System.getenv(environmentVariable);
        return Objects.requireNonNullElseGet(env, () -> defaultValue.toString());
    }
}

```


## Something else
