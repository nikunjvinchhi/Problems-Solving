/**
202. Happy Number
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
*/
class Solution {
    // using hashSet.
    // public boolean isHappy(int n) {
    //     Set<Integer> c = new HashSet<>();
    //     c.add(n);
    //     while(n != 1){
    //         int x = n;
    //         int sum =0;
    //         int r =0;
    //         while(x!=0){
    //             r = x % 10;
    //             x = x /10;
    //             sum = sum + (r*r);
    //         }
    //         if(c.contains(sum))
    //             return false;
    //         n = sum;         
    //         c.add(n);
    //     }
    //     return true;
    // }
    //we can use linked list cycle approach to detect cycle.
    //2->4->16->37->58->89->145->42->20->4(again cycle will repect so similar to linked list contains cycle or not.)
    public boolean isHappy(int n) {
        int s = n;
        int f = getNext(n);
        while(s != f){
            s = getNext(s);
            f = getNext(getNext(f));
        }
        if(s == 1)
            return true;
        else
            return false;
    }
    public int getNext(int n){
        int sum =0;
        int r =0;
        while(n!=0){
            r = n % 10;
            n = n /10;
            sum = sum + (r*r);
        }
        return sum;
    }
}