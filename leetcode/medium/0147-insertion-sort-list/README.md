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
**Runtime:** 18 ms (beats 76.29%)  
**Memory:** 46.4 MB (beats 35.47%)  
**Submitted:** 2026-06-24T10:42:47.785Z  

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // Base case: if the list is empty or has only one element, it's already sorted 🛑
        if (head == null || head.next == null) {
            return head;
        }
            
        ListNode dummy = new ListNode(0); // Dummy anchor for the sorted list
        ListNode prev = dummy;             // Pointer to search for the insertion point
        ListNode curr = head;              // Runner tracking the unsorted nodes
        ListNode next = null;              // Temporary holder for the next unsorted node

        // Step 1: Iterate through the unsorted linked list 🔄
        while (curr != null) {
            next = curr.next; // Save the future path before altering links
            
            // Step 2: Scan the sorted subset from the beginning to find the insert point 🔎
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            
            // Step 3: Splice 'curr' into its correct position between 'prev' and 'prev.next' ✂️
            curr.next = prev.next;
            prev.next = curr;
            
            // Step 4: Reset search pointer back to dummy and move 'curr' forward
            prev = dummy;
            curr = next;
        }
        
        return dummy.next; // Return the sorted list starting after our dummy node
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/insertion-sort-list/)