# Unique Binary Search Trees

Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

### Example 1:
```ruby
Input: n = 3
Output: 5
```
### Example 2:
```ruby
Input: n = 1
Output: 1
```
### Constraints:

- 1 <= n <= 19

## Solution explained (Math based)

Let's call $B(n)$ the function that returns the number of unique BSTs given the number of nodes n as parameter.
To explore all possibilities, we can take every node as root and find the consequencial combinations.
Let's call $R(i,n)$ the function that returns the number of unique BSTs, given the number of nodes n and the fixed root $i$ ($1 <= i <= n$).
$ B(n) = \sum_{i=1}^{n} R(i,n) $
Taking the node $i^{th}$ as root, we'll have on the left side $i-1$ nodes to place and on the right side $n-i$ nodes. The total combinations are, for the chain rule of events, the product of the combinations on the two sides.
$ R(i,n) = B(i-1) * B(n-i) $
Then, if we make the substitution in the $B(n)$ expression, we get:
$ B(n) = \sum_{i=1}^{n} (B(i-1)*B(n-i)) $

Finally, we can use memoization to save time.

