package org.example;

import java.util.Arrays;

//边界查找-在排序数组中查找元素的第一个和最后一个位置
public class LeetCode34 {


    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solutions/504484/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



    public static void main(String[] args) {

        //给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
        //
        //如果数组中不存在目标值 target，返回 [-1, -1]。
        //
        //你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
        //
        //
        //
        //示例 1：
        //输入：nums = [5,7,7,8,8,10], target = 8
        //输出：[3,4]

        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums,8)));


        //示例 2：
        //输入：nums = [5,7,7,8,8,10], target = 6
        //输出：[-1,-1]
        System.out.println(Arrays.toString(searchRange(nums,6)));

        //示例 3：
        //输入：nums = [], target = 0
        //输出：[-1,-1]
        System.out.println(Arrays.toString(searchRange(nums,0)));




        //数组初始化
        //int[] nums = {1, 3, 5, 6};  一维数组
        //int[][] matrix = {{1,2},{3,4}};  二维数组

        //数组打印
        //Arrays.toString()一维数组推荐
        //Arrays.deepToString()（多维数组专用）
        //适用场景打印二维及以上数组（如 [[3,4],[5,6]]）





    }
}
