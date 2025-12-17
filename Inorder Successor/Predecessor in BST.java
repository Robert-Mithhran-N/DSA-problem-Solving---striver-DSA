/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    Node succ=null;
    Node pred=null;
    public void getSuccessor(Node root, int key){
        while(root!=null){
            if(key>=root.data)
                root=root.right;
            else{
                if(succ!=null && root.data<succ.data)
                    succ=root;
                if(succ==null)
                    succ=root;
                root=root.left;
            }
        }
    }
    
    public void getPredecessor(Node root, int key){
        while(root!=null){
            if(key<=root.data)
                root=root.left;
            else{
                if(pred!=null && root.data>pred.data)
                    pred=root;
                if(pred==null)
                    pred=root;
                root=root.right;
            }
        }
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> ans = new ArrayList<>();
        getSuccessor(root,key);
        getPredecessor(root,key);
        ans.add(pred);
        ans.add(succ);
        return ans;
    }
}
