/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    private static int findPeak(MountainArray arr){
        int start=0, end = arr.length()-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr.get(mid)>arr.get(mid+1)){
                end= mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }


    private int LeftRightBinarySearch(MountainArray arr, int start, int end, int target, boolean reverse){
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr.get(mid)>target){
                if(reverse){
                    start=mid+1;
                }
                else{
                    end= mid-1;
                }
            }
            else if(arr.get(mid)<target){
                if(reverse){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int left = LeftRightBinarySearch(mountainArr, 0, peak, target, false);
        int right = LeftRightBinarySearch(mountainArr, peak+1, mountainArr.length()-1, target, true);
        if(left!=-1){
            return left;
        }
        else{
            return right;
        }

    }
}