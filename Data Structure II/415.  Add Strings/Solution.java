class Solution {
    public String addStrings(String num1, String num2) {
        
        int l1 = num1.length(), l2 = num2.length(), carry = 0;
        StringBuilder ans = new StringBuilder();
        
        for (int i=0; i<Math.max(l1,l2); i++){
            int digit;
            
            if (i>=l1 || i>=l2)
                digit = carry + (i>=l1? num2.charAt(l2-i-1) : num1.charAt(l1-i-1)) - '0';
            else
                digit = num1.charAt(l1-i-1) - '0' + num2.charAt(l2-i-1) - '0' + carry;
                
            carry = digit/10 == 0? 0:1;
            if (carry == 1)  digit %= 10;
            ans.insert(0,(char)('0' + digit));
        }
        if (carry == 1)//need one more bit
            ans.insert(0,'1');
        return ans.toString();
    }
}