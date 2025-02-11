package dfs.binaryTree

/**
 * LEETCODE #100. Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 */
class SameTree {
    // My Solution
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p?.`val` == null && q?.`val` == null) return true
        if (p?.`val` != q?.`val`) return false
        /**
         * Tip : Base case 가 위처럼 여러가지 일 수 있음
         */

        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}