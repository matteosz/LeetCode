# Repeated DNA Sequences

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

### Example 1:
```ruby
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
```
### Example 2:
```ruby
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
```
### Constraints:

- 1 <= s.length <= 10^5
- s[i] is either 'A', 'C', 'G', or 'T'.
