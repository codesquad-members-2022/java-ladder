## 사다리 게임

![](img.png)

# TIL

### str.matches()
```java
str.matches("\\d+")
```
위와 같이 사용하여 `String str`이 **한자리 또는 그 이상의 숫자 형태인지** 여부를 확인할 수 있다.

regex를 알아두면 확실히 편할 것 같다.
### String.join()
```java
.map(arr -> Arrays.toString(arr)
.replace(", ", "")
.replace("[", "")
.replace("]", ""))
```
위 코드를
```java
.map(arr -> String.join("",arr))
```
이렇게 바꿀 수 있다.
