	//https://leetcode.com/problems/ugly-number-ii/
//Ugly Number Two

//Too slow!
public class Solution {

	public int nthUglyNumber(int n) {
        
        boolean nthFound = false;   
        int nth = 0;
        int index = 1;
        
        while(!nthFound) {
            boolean determined = false;
            int tempIndex = index;
            
            tempIndex = uglyHelper(tempIndex);

            if(tempIndex == 1) {
                nth++;
                if(nth == n)
                    return index;
               }
               
            index++;
        }
        
        return 0;
    }
    
	public int uglyHelper(int n) {
        
        int remainder;
        
        if(n == 1)
            return 1;
        else if(n % 2 == 0)
            remainder = n / 2;
        else if(n % 3 == 0)
            remainder = n / 3;
         else if(n % 5 == 0)
            remainder = n / 5;
        else return n;
            
        remainder = uglyAll(remainder);
        return remainder;
    }

}