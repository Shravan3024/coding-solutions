# Looping - Car Speed

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You have an electric car whose speed is derived from the battery percentage

The battery percentage is denoted by an integer value N and the speed is the sum of all the factors of the battery percentage including 1. Your task is to find and return an integer value representing the speed of the car.

 **Input Format** 

An integer value N representing the battery percentage of the car.

 **Constraints** 

NA

 **Output Format** 

Return an integer value representing the speed of the car.

 **Sample Input 0** 

```
12

```

 **Sample Output 0** 

```
28

```

 **Explanation 0** 

Here, the given battery percent is 12 and the factors of 12 are 1, 2, 3, 4, 6, and 12. The sum of all the factors will be 1+2+3+4+6+12=28. Therefore 28 is returned as the output

 **Sample Input 1** 

```
6

```

 **Sample Output 1** 

```
12

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-06-29T17:23:38.366Z  

```cpp
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/looping-car-speed/problem)