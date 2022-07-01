public class Solution {
    public static double median(int[] nums1, int[] nums2) {
        
    	int low = (int)-1e9, high = (int)1e9 ;
        
        int n = nums1.length, m = nums2.length ;
        
        int totalLen = n + m ;
        
        int pos = totalLen/2 ;
        
        while (low <= high)
        {
            int mid = low + ((high-low)>>1) ;   
            int ub = upperBound(nums1, mid) + upperBound(nums2, mid) ;
             
            if (ub <= pos) low = mid + 1 ;
            else high = mid - 1 ;
        }
        
  
        double ans = low ;
        
        if ((totalLen)%2 == 0)
        {
            pos-- ;
            low = (int)-1e9; high = (int)1e9 ;
            while (low <= high)
            {
               int mid = low + ((high-low)>>1) ;   
               int ub = upperBound(nums1, mid) + upperBound(nums2, mid) ;
               
               if (ub <= pos) low = mid + 1 ;
               else high = mid - 1 ;
            }
            
            ans = (ans + low*1.0)/2 ;
        }
        
        return ans ;
    }
    
    
    public static int upperBound(int[] arr, int key)
    {
        int low = 0, high = arr.length ;
        
        while (low < high)
        {
            int mid = low + ((high-low)>>1) ;
            
            if (arr[mid] <= key)
                low = mid + 1 ;
            else high = mid ;
        }
        
        return low ;
    }
  
}
