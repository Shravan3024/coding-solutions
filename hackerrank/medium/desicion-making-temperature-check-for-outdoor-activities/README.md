# Decision Making - Temperature Check for Outdoor Activities

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are organizing an outdoor event and need to decide whether it's safe for participants to go outside based on the current temperature. Temperatures below zero degrees Celsius are considered too cold and unsafe, while temperatures above zero are suitable for outdoor activities. Write a program to check if the given temperature is positive or negative.

 **Input Format** 

A single integer input representing the current temperature in degrees Celsius.

 **Constraints** 

The temperature can be any integer (positive, negative, or zero).

 **Output Format** 

- If the given temperature is positive, print "Safe for outdoor activities."
- If the temperature is negative or zero, print "Too cold for outdoor activities."

 **Sample Input 0** 

```
15

```

 **Sample Output 0** 

```
Safe for outdoor activities

```

 **Explanation 0** 

The given temperature is 15 degrees Celsius, which is above zero. Hence, the output is "Safe for outdoor activities."

 **Sample Input 1** 

```
-5

```

 **Sample Output 1** 

```
Too cold for outdoor activities

```

 **Explanation 1** 

The given temperature is -5 degrees Celsius, which is below zero. Hence, the output is "Too cold for outdoor activities."

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-06-25T17:09:14.398Z  

```cpp
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int temperature = sc.nextInt();

        if (temperature > 0) {
            System.out.println("Safe for outdoor activities");
        } else {
            System.out.println("Too cold for outdoor activities");
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/desicion-making-temperature-check-for-outdoor-activities/problem)