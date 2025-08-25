package org.example;
//二分查找
public class LeetCode704 {


    //二分查找的做法是，定义查找的范围 [left,right]，初始查找范围是整个数组。
    // 每次取查找范围的中点 mid，比较 nums[mid] 和 target 的大小，
    // 如果相等则 mid 即为要寻找的下标，
    // 如果不相等则根据 nums[mid] 和 target 的大小关系将查找范围缩小一半。
    //
    //由于每次查找都会将查找范围缩小一半，因此二分查找的时间复杂度是 O(logn)，其中 n 是数组的长度。
    //
    //二分查找的条件是查找范围不为空，即 left≤right。
    // 如果 target 在数组中，二分查找可以保证找到 target，返回 target 在数组中的下标。
    // 如果 target 不在数组中，则当 left>right 时结束查找，返回 −1
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/binary-search/solutions/980494/er-fen-cha-zhao-by-leetcode-solution-f0xw/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    /**
     * 二分查找算法
     * 在有序数组中查找目标值，如果存在则返回索引，否则返回-1
     * 时间复杂度：O(log n)，其中n是数组长度
     * 空间复杂度：O(1)
     */
    public static int search(int[] nums, int target) {
        // 初始化左指针为数组起始位置
        int left = 0, 
            // 初始化右指针为数组末尾位置
            right = nums.length - 1;
        
        // 当左指针小于等于右指针时，继续查找
        while (left <= right) {
            // 计算中间位置，避免整数溢出的写法
            int mid = (right - left) / 2 + left;
            // 获取中间位置的元素值
            int num = nums[mid];
            
            // 如果中间元素等于目标值，找到了目标，返回索引
            if (num == target) {
                return mid;
            } 
            // 如果中间元素大于目标值，说明目标在左半部分，调整右边界
            else if (num > target) {
                right = mid - 1;
            } 
            // 如果中间元素小于目标值，说明目标在右半部分，调整左边界
            else {
                left = mid + 1;
            }
        }
        
        // 循环结束仍未找到目标，返回-1表示不存在
        return -1;
    }


    public static void main(String[] args) {
        //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
        // 写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
        //
        //你必须编写一个具有 O(log n) 时间复杂度的算法。
        //
        //
        //示例 1:
        //输入: nums = [-1,0,3,5,9,12], target = 9
        //输出: 4
        //解释: 9 出现在 nums 中并且下标为 4

        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums,9));



        //示例 2:
        //输入: nums = [-1,0,3,5,9,12], target = 2
        //输出: -1
        //解释: 2 不存在 nums 中因此返回 -1
        //
        System.out.println(search(nums,2));





    }
}
