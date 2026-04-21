class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """

        c=x
        y=0
        while(x>0):
            rem=x%10
            y=(y*10)+rem
            x=x//10
        if(c==y):
            return True
        return False
    
        