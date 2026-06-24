class Solution {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int max = 0;

        for(int i = 0; i <= gain.length-1; i++){
            current += gain[i];
            max = Math.max(max, current);
        }
        return max;
    }
}