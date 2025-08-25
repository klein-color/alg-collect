package org.example;
// 基础二分查找类题目:搜索插入位置
public class LeetCode35 {

    /**
     * 搜索插入位置
     * 在有序数组中查找目标值的索引，如果不存在则返回应该插入的位置
     * 使用二分查找算法，时间复杂度为 O(log n)
     * 
     * @param nums 有序数组
     * @param target 目标值
     * @return 目标值在数组中的索引或应该插入的位置
     */
    public static int searchInsert(int[] nums, int target) {
        // 初始化二分查找的左右边界
        int left = 0, right = nums.length - 1;
        
        // 当左指针小于等于右指针时继续查找
        while(left <= right) {
            // 计算中间位置，避免整数溢出
            int mid = (left + right) / 2;
            
            // 找到目标值，直接返回索引
            if(nums[mid] == target) {
                return mid;
            } 
            // 中间值小于目标值，说明目标在右半部分
            else if(nums[mid] < target) {
                left = mid + 1;  // 将左边界移到中间位置的右侧
            } 
            // 中间值大于目标值，说明目标在左半部分
            else {
                right = mid - 1;  // 将右边界移到中间位置的左侧
            }
        }
        
        // 循环结束时，left 指向的是第一个大于等于 target 的位置
        // 这正是 target 应该插入的位置
        return left;
    }

    public static void main(String[] args) {
        //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        //
        //请必须使用时间复杂度为 O(log n) 的算法。
        //
        //示例 1:
        //输入: nums = [1,3,5,6], target = 5
        //输出: 2
        int[] nums = new int[4];
        nums[0] = 1;
        nums[1] = 3;
        nums[2] = 5;
        nums[3] = 6;
        int i = searchInsert(nums, 5);
        System.out.println(i);

        //示例 2:
        //输入: nums = [1,3,5,6], target = 2
        //输出: 1
        int j = searchInsert(nums, 2);
        System.out.println(j);

        //示例 3:
        //输入: nums = [1,3,5,6], target = 7
        //输出: 4
        int k = searchInsert(nums, 7);
        System.out.println(k);





    }
}
