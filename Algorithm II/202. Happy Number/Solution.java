class Solution {
    public boolean isHappy(int n) {
        HashSet<String> path = new HashSet<>();
        String num = Integer.toString(n);
        
        while (!num.equals("1")) {
            
            if (!path.add(num))
                return false;
            
            int x = 0;
            for (int i=0; i<num.length(); i++)
                x += (num.charAt(i) - '0') * (num.charAt(i) - '0');
            /* Possibility without strings 
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                x += d * d;
            } */
            
            num = Integer.toString(x);
        }
        
        return true;
    }
}