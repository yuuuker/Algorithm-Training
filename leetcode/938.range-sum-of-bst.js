/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
var rangeSumBST = function(root, L, R) {
    if (!root) {
        return 0
    }
    if (root.val >= L && root.val <= R) {
        // console.log(root.val)
        return (
            root.val +
            rangeSumBST(root.left, L, R) +
            rangeSumBST(root.right, L, R)
        )
    }
    return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R)
}
