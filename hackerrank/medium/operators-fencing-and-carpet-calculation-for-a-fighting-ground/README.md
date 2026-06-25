# Operators - Fencing and Carpet Calculation for a Fighting Ground

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In Westeros, the King Bran Stark plans to prepare a rectangular fighting ground for the upcoming tournament. To ensure the safety of the participants and the audience, he wants to build a sturdy fence around the fighting ground. Additionally, to protect the ground from rain and maintain its quality, he wants to cover it with a thick carpet during the rainy season.

King Bran has tasked his royal engineer with calculating the necessary length of rope for the fence and the area of carpet needed to cover the entire ground. He wants to ensure that the amounts he orders are exact, so no extra materials are wasted.

The program will compute:

- The length of the rope needed to cover the perimeter of the rectangular ground.
- The area of the carpet needed to completely cover the rectangular fighting ground.

 **Input Format** 

The program takes two integer inputs:

- The length of the ground (in meters).
- The breadth of the ground (in meters).

 **Constraints** 

NA

 **Output Format** 

The program should output the following:

- The required length of the rope in meters.
- The required area of the carpet in square meters (sqm).

 **Sample Input 0** 

```
50
20

```

 **Sample Output 0** 

```
The required length is 140 m
The required area of carpet is 1000 sqm

```

 **Explanation 0** 

The user inputs 50 for the length and 20 for the breadth. This means the fighting ground is 50 meters long and 20 meters wide.

Perimeter (Length of Rope): Perimeter = 2 × (Length + Breadth) = 2 × (50 + 20) = 2 × 70 = 140 meters Area (Carpet Area): Area = Length × Breadth = 50 × 20 = 1000 square meters

The required length is 140 m" indicating the length of the rope needed for the fence. The required area of carpet is 1000 sqm" indicating the area that the carpet should cover.

 **Sample Input 1** 

```
30
15

```

 **Sample Output 1** 

```
The required length is 90 m
The required area of carpet is 450 sqm

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-06-25T17:08:20.850Z  

```cpp
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int b = sc.nextInt();
        
        int perimeter = 2*(l+b);
        int area = l*b;
        
        System.out.println("The required length is "+perimeter+" m");
        System.out.println("The required area of carpet is "+area+" sqm");

    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/operators-fencing-and-carpet-calculation-for-a-fighting-ground/problem)