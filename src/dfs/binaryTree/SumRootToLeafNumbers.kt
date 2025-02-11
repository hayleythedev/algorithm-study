package dfs.binaryTree

/**
 * LeetCode #129. Sum Root to Leaf Numbers
 *
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 */
class SumRootToLeafNumbers {
    fun sumNumbers(root: TreeNode?): Int {

        fun dfs(node: TreeNode?, current: Int): Int {
            if (node == null) return 0
            val next = current * 10 + node.`val`

            if (node.left == null && node.right == null) return next

            return dfs(node.left, next) + dfs(node.right, next)
        }

        return dfs(root, 0)
    }

    /**
     *    4
     *   9 0
     *  5 1
     *
     * dfs(<4>, 0)
     * = dfs(<9>, 0 * 10 + 4 = 4) + dfs(<0>, 0 * 10 + 4 = 4)
     * = dfs(<5>, 4 * 10 + 9 = 49) + dfs(<1>, 4 * 10 + 9 = 49) + (4 * 10 = 40)
     * = (49 * 10 + 5 = 495)  + (49 * 10 + 1 = 491) + 40
     */
}