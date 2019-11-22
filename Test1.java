给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int area=0;
        for(int i=0;i<heights.length;i++){
            int num=1;
            int tmp=i-1;
            while(tmp>=0&&heights[tmp]>=heights[i]){
                num++;
                tmp--;
            }
            tmp=i+1;
            while(tmp<heights.length&&heights[tmp]>=heights[i]){
                num++;
                tmp++;
            }
            maxArea=Math.max(maxArea,num*heights[i]);
        }
        return maxArea;
    }
}

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。
lass Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]+i>=n){
                n=i;
            }
        }
        return n==0;
    }
}

给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
class Solution {
    public int firstMissingPositive(int[] nums) {
         for(int i=0;i<nums.length;i++){
            if(nums[i]<=0){
                nums[i]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<nums.length;i++){
            int abs=Math.abs(nums[i]);
            if(abs<=nums.length&&nums[abs-1]>0){
                nums[abs-1]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}



