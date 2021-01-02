class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        if(s == null || s.length() == 0){
            return len;
        }
        boolean found = true;
        for(int i = s.length() - 1; i >=0; i--){
            if(s.charAt(i) != ' '){
                len++;
                found = false;
            } else if(!found){
                break;
            }
        }
        return len;
    }
}