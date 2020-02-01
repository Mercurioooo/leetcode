/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 *
 * https://leetcode-cn.com/problems/first-bad-version/description/
 *
 * algorithms
 * Easy (34.89%)
 * Likes:    127
 * Dislikes: 0
 * Total Accepted:    33.6K
 * Total Submissions: 93.1K
 * Testcase Example:  '5\n4'
 *
 * 
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version
 * 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 
 * 示例:
 * 
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * 
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * 
 * 所以，4 是第一个错误的版本。 
 * 
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//1,2,3,4,5
class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l <= r) {// l==r的时候也要判断,结束条件为l=r+1
            int m = l + (r - l) / 2;
            if (isBadVersion(m))
                r = m - 1;
            else
                l = m + 1;
        }
        return l;
    }

    public int firstBadVersion1(int n) {
        int l = 1, r = n;
        // 12345
        while (l < r) {// 结束条件为l=r,
            int m = l + (r - l) / 2;
            if (isBadVersion(m))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}
// @lc code=end
