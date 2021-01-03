//Problem statement
/*
Non Repeating Character
Given a string S consisting of lowercase Latin Letters. Find the first non-repeating character in S.
*/
class Repeatation
{
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        Map<Character, Integer> t = new LinkedHashMap();
         for(char c : S.toCharArray()) {
             if(t.containsKey(c)){
                 Integer x = t.get(c) + 1;
                 t.put(c, x);
             } else{
                 t.put(c, 1);
             }
         }
         for(Character key : t.keySet()){
             if(t.get(key) == 1){
                 return key;
             }
         }
         return '$';
    }
}