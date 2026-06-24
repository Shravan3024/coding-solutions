# Reverse Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the `head` of a singly linked list, reverse the list, and return  *the reversed list*.

 

 **Example 1:** 

```
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

```

 **Example 2:** 

```
Input: head = [1,2]
Output: [2,1]

```

 **Example 3:** 

```
Input: head = []
Output: []

```

 

 **Constraints:** 

- The number of nodes in the list is the range [0, 5000].
- -5000 <= Node.val <= 5000

 

 **Follow up:**  A linked list can be reversed either iteratively or recursively. Could you implement both?

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 44.2 MB (beats 67.07%)  
**Submitted:** 2026-06-24T10:41:56.626Z  

```java
class Solution {
    public ListNode reverseList(ListNode head) {
    ListNode prev=null;
    ListNode curr=head;
    while(curr!=null){
        ListNode  temp=curr.next;    //step1
        curr.next=prev;              //step2
         prev = curr;                //step3
        curr=temp;                   //step4
    }
    return prev;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-linked-list/)