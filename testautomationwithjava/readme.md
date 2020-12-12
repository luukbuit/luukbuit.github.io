# Test automation with Java

```java
private static String getEnv(String environmentVariable, String defaultValue) {
    String env = System.getenv(environmentVariable);
    if (env != null) {
        return env;
    } else {
        return defaultValue;
    }
}
```
