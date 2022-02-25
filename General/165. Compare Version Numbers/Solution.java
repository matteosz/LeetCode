class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l1 = v1.length, l2 = v2.length;
        
        for (int i=0; i < Math.min(l1,l2); i++) {
            int x1 = Integer.parseInt(v1[i]), x2 = Integer.parseInt(v2[i]);
            if (x1 > x2)
                return 1;
            if (x1 < x2)
                return -1;
        }

        String[] x = l1 > l2? v1 : v2;
        for (int i=Math.min(l1,l2); i < Math.max(l1,l2); i++)
            if (Integer.parseInt(x[i]) != 0)
                return l1 > l2? 1 : -1;
        return 0;
    }
}