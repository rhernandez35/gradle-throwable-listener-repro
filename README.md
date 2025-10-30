### 35220 reproducer


To run:

```
# fails in the expected way
./gradlew :repro:exception

# does not fail at all, and the error log goes to daemon stderr
./gradlew :repro:error
```
