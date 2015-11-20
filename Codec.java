/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

 //too slow!
public class Codec {
    
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null)
            return "EMPTY";

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Double> nullQueue = new LinkedList<Double>();
        HashMap<Integer, Boolean> nullMap = new HashMap<Integer, Boolean>();

        String str = "";
        q.add(root);
        double level = 0;
        double nodesCheckedAtThisLevel = 0;
        int totalNodesChecked = 0;

        while(!q.isEmpty()) {

            if (nodesCheckedAtThisLevel == Math.pow(2, level)) {
                level++;
                nodesCheckedAtThisLevel = 0;
            }

            totalNodesChecked++;
            nodesCheckedAtThisLevel++;

            if(nullMap.get(totalNodesChecked) != null) {
                str += "Null,";
                int nullLeftChild = (totalNodesChecked * 2);
                nullMap.put(nullLeftChild, true);
                nullMap.put(nullLeftChild + 1, true);
            } else {
                TreeNode t = q.remove();
                str += t.val + ",";

                if(t.left != null)
                    q.add(t.left);
                else {
                    int nodesUntilNullInsert = (totalNodesChecked * 2);
                    nullMap.put(nodesUntilNullInsert, true);
                }

                if(t.right != null)
                    q.add(t.right);
                else {
                    int nodesUntilNullInsert = (totalNodesChecked * 2) + 1;
                    nullMap.put(nodesUntilNullInsert, true);
                }
            }
        }

        return str;
    }

    public TreeNode deserialize(String data) {
        if(data.equals("EMPTY"))
            return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean nodeAdded = true;
        HashMap<Integer, TreeNode> nodeMap = new HashMap<Integer, TreeNode>();
        nodeMap.put(1, root);

        int i = 1;
        while(i < nodes.length) {

            if(!nodes[i].contains("Null")) {
                TreeNode node = nodeMap.get((i + 1)/2);
                TreeNode childNode = new TreeNode((Integer.valueOf(nodes[i])));
                nodeMap.put(i + 1,childNode);
                node.left = childNode;
            } 

            i++; 

            if(i < nodes.length) {
                if (!nodes[i].contains("Null")) {
                    TreeNode node = nodeMap.get((i + 1)/2);
                    TreeNode childNode = new TreeNode((Integer.valueOf(nodes[i])));
                    nodeMap.put(i + 1,childNode);
                    node.right = childNode;
                } 
            }

            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

