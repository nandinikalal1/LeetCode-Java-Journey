package SubTreeofAnotherTree;

public class subtree {
    // Tree node definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
        }
        TreeNode(int v, TreeNode l, TreeNode r) {
            val = v;
            left = l;
            right = r;
        }
    }

        // DFS-1 : traverses the BIG tree
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {

            // if there is no node left in big tree to check
            if (root == null) {
                return false;
            }

            // try matching subRoot starting at this node
            if (isSameTree(root, subRoot)) {
                return true;
            }

            // otherwise continue traversal
            return isSubtree(root.left, subRoot)
                    || isSubtree(root.right, subRoot);
        }

        // DFS-2 : compares two trees completely
        private boolean isSameTree(TreeNode a, TreeNode b) {

            // both trees ended at the same time
            if (a == null && b == null) {
                return true;
            }

            // one tree ended before the other
            if (a == null || b == null) {
                return false;
            }

            // values are different
            if (a.val != b.val) {
                return false;
            }

            // compare left and right subtrees
            return isSameTree(a.left, b.left)
                    && isSameTree(a.right, b.right);
        }
    
    public static void main(String[] args) {

        /*
            Big tree (root)

                    3
                   / \
                  4   5
                 / \
                1   2
        */

        TreeNode root =
                new TreeNode(3,
                        new TreeNode(4,
                                new TreeNode(1),
                                new TreeNode(2)),
                        new TreeNode(5)
                );

        /*
            subRoot

                    4
                   / \
                  1   2
        */

        TreeNode subRoot =
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2)
                );

        subtree sol = new subtree();

        boolean result = sol.isSubtree(root, subRoot);

        System.out.println("Is subRoot a subtree of root? -> " + result);
    }
}
