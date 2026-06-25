# Input & Output - Automated System Greeting for New Users

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Imagine a software system that welcomes new users as soon as they register or log in for the first time. The system automatically greets the user by displaying "Hello, World!" as soon as the application starts, without waiting for any input. The greeting message helps make the system feel welcoming and interactive.

In this scenario, the system is designed to immediately greet users with the message "Hello, World!" when they access the software for the first time. This behaviour mimics a system that performs an action (like sending a welcome email or showing a message) right after a user logs in. There’s no need for any input from the user; the system automatically prints the greeting when launched.

 **Sample Output**  Hello, World!

 **Input Format** 

There is no input required from the user. The program runs and outputs the message immediately without interaction.

 **Constraints** 

NA

 **Output Format** 

The system should output the message "Hello, World!", printed exactly once, without extra spaces or characters.

 **Sample Output 0** 

```
Hello, World!

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-06-25T17:03:43.826Z  

```cpp
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    printf("Hello, World!");
    return 0;
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/input-output-automated-system-greeting-for-new-users/problem)