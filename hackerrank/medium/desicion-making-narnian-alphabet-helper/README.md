# Decision Making - Narnian Alphabet Helper

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In Narnia, Jeni is trying to help the young children learn the English alphabet while she is away. Since many of the Narnian children are new to English, Jeni wants a program that will help them identify whether a given character is a vowel, consonant, or not an English alphabet letter at all. This program will help children practice on their own and gain confidence in recognizing vowels and consonants.

Write a program that takes a single character as input and determines if it is a:

- Vowel (letters 'a', 'e', 'i', 'o', 'u' in both uppercase and lowercase),
- Consonant (any other English alphabet letter), or
- Not an alphabet (if the character is not an English letter).

 **Input Format** 

A single character (either lowercase or uppercase, or any other symbol).

 **Constraints** 

NA

 **Output Format** 

Print one of the following outputs based on the character input:

- "Vowel" if the character is a vowel.
- "Consonant" if the character is a consonant.
- "Not an alphabet" if the character is not a valid English alphabet letter.

 **Sample Input 0** 

```
e

```

 **Sample Output 0** 

```
Vowel

```

 **Explanation 0** 

The input character e is a vowel, so the output is "Vowel".

 **Sample Input 1** 

```
Z

```

 **Sample Output 1** 

```
Consonant

```

 **Explanation 1** 

The input character Z is a consonant, so the output is "Consonant".

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-06-25T17:10:27.723Z  

```cpp
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char ch = sc.next().charAt(0);

        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                System.out.println("Vowel");
            } else {
                System.out.println("Consonant");
            }
        } else {
            System.out.println("Not an alphabet");
        }

        sc.close();
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/desicion-making-narnian-alphabet-helper/problem)