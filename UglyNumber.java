//https://leetcode.com/problems/ugly-number-ii/
//Ugly Number Two

//Too slow!
public class UglyNumber {

	public int nthUglyNumber(int n) {
        
        boolean nthFound = false;   
        int nth = 0;
        int index = 1;
        
        while(!nthFound) {
            
            boolean determined = false;
            int tempIndex = index;
            while(!determined) {
                
                int tempIndexAtStartOfPass = tempIndex;
                tempIndex = uglyTwo(tempIndex);
                tempIndex = uglyThree(tempIndex);
                tempIndex = uglyFive(tempIndex);
                
                if(tempIndex == 1) {
                    nth++;
                    if(nth == n)
                        return index;
                    determined = true;
                    index++;
                }
                else if(tempIndex == tempIndexAtStartOfPass){
                    determined = true;
                    index++;
                }
            }
        }
        
        return 0;
    }
    
	public int uglyTwo(int n) {
        
        int remainder;
        
        if(n == 1)
            return 1;
        else if(n % 2 == 0)
            remainder = n / 2;
        else return n;
            
        remainder = uglyTwo(remainder);
        return remainder;
    }
    
        public int uglyThree(int n) {
        
        int remainder;
        
        if(n == 1)
            return 1;
        else if(n % 3 == 0)
            remainder = n / 3;
        else return n;
            
        remainder = uglyThree(remainder);
        return remainder;
    }
    
        public int uglyFive(int n) {
        
        int remainder;
        if(n == 1)
            return 1;
        else if(n % 5 == 0)
            remainder = n / 5;
        else return n;
            
        remainder = uglyFive(remainder);
        return remainder;
    }


}