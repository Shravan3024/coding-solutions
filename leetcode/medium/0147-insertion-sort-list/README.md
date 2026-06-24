# Insertion Sort List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `head` of a singly linked list, sort the list using  **insertion sort**, and return  *the sorted list's head*.

The steps of the  **insertion sort**  algorithm:

- Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
- At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
- It repeats until no input elements remain.

The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

 

 **Example 1:** 

```
Input: head = [4,2,1,3]
Output: [1,2,3,4]

```

 **Example 2:** 

```
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

```

 

 **Constraints:** 

- The number of nodes in the list is in the range [1, 5000].
- -5000 <= Node.val <= 5000

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 88.39%)  
**Memory:** 46.6 MB (beats 18.48%)  
**Submitted:** 2026-06-24T10:43:36.147Z  

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // I don't know how to do this insertion way but here is the  sorting way
        ArrayList<Integer>list=new ArrayList<>();
        ListNode thead=head;
        while(thead!=null){
            list.add(thead.val);
            thead=thead.next;
        }
        list.sort(null);
        thead=head;
        int index=0;
        while(thead!=null){
            thead.val=list.get(index++);
            thead=thead.next;
        }
        return head;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/insertion-sort-list/)