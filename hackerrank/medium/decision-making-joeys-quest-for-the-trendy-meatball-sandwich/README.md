# Decision Making - Joey's Quest for the Trendy Meatball Sandwich

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Joey Tribbiani, a huge fan of sandwiches, spots an irresistible offer at his favorite sandwich shop. The shop promises free sandwiches for life to anyone who can identify whether a given number is a "Trendy Number." Joey, excited at the prospect, wants to check various numbers to see if they qualify. A "Trendy Number" is defined as a 3-digit number where the middle digit is divisible by 3. Can you help Joey write a program that determines whether a given number is a "Trendy Number"?

Write a program that takes an integer n as input and checks the following:

- If the number is not a 3-digit number, it should print "Invalid Number".
- If the number is a 3-digit number and its middle digit is divisible by 3, it should print "Trendy Number".
- If the number is a 3-digit number but its middle digit is not divisible by 3, it should print "Not a Trendy Number".

 **Input Format** 

A single integer, n, representing the given number.

 **Constraints** 

NA

 **Output Format** 

- Print "Trendy Number" if the input satisfies the trendy number conditions.
- Print "Not a Trendy Number" if it’s a 3-digit number but doesn’t satisfy the middle-digit divisibility rule.
- Print "Invalid Number" if the input number is not a 3-digit number.

 **Sample Input 0** 

```
791

```

 **Sample Output 0** 

```
Trendy Number

```

 **Explanation 0** 

The input number 791 is a 3-digit number, and its middle digit 9 is divisible by 3, making it a "Trendy Number."

 **Sample Input 1** 

```
275

```

 **Sample Output 1** 

```
Not a Trendy Number

```

 **Explanation 1** 

The input number 275 is a 3-digit number, but its middle digit 7 is not divisible by 3, so it’s "Not a Trendy Number".

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-06-25T17:12:38.403Z  

```cpp
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n < 100 || n > 999) {
            System.out.println("Invalid Number");
        } else {
            int middleDigit = (n / 10) % 10;

            if (middleDigit % 3 == 0) {
                System.out.println("Trendy Number");
            } else {
                System.out.println("Not a Trendy Number");
            }
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/decision-making-joeys-quest-for-the-trendy-meatball-sandwich/problem)