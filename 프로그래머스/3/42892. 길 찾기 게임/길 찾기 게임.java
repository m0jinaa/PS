import java.util.*;

class Solution {
    class Node implements Comparable<Node>{
        int x,y,c;
        
        Node left,right;
        
        public Node(int x, int y, int c){
            this.x = x;
            this.y = y;
            this.c = c;
        }
        
        @Override
        public int compareTo(Node node){
            if(this.y == node.y){
                return this.x-node.x;
            }
            else{
                return node.y-this.y;
            }
        }
    }
    
    class Tree{
        Node root;
        
        int[] preOrder,postOrder;
        int preInd,postInd;
        
        public Tree(Node root, int n){
            this.root = root;
            this.preOrder = new int[n];
            this.postOrder = new int[n];
            this.preInd = 0;
            this.postInd = 0;
            
        }
        
        public void insert(Node now, Node node){
            if(node.x < now.x){
                if(now.left == null){
                    now.left = node;
                }
                else{
                    insert(now.left,node);
                }
            }
            else {
                if(now.right == null){
                    now.right = node;
                }
                else{
                    insert(now.right, node);
                }
            }
        }
        
        public void align(Node node){
            //전위순회
            preOrder[this.preInd++] = node.c;
            
            if(node.left != null){
                align(node.left);
            }
            
            if(node.right != null){
                align(node.right);
            }
            
            //후위순회
            postOrder[this.postInd++] = node.c;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        
        int n = nodeinfo.length;
        
        Node[] nodes = new Node[n];
        
        for(int i = 0;i<n;i++){
            nodes[i] = new Node(nodeinfo[i][0],nodeinfo[i][1],i+1);
        }
        
        //y 높은순 -> x 낮은순으로 정렬
        Arrays.sort(nodes);
        
        Tree tree = new Tree(nodes[0],n);
        
        //트리에 하나씩 삽입
        for(int i = 1;i<n;i++){
            tree.insert(tree.root, nodes[i]);
        }
        
        //전위순회, 후위순회 구하기
        tree.align(tree.root);
        
        return new int[][] {tree.preOrder,tree.postOrder};
    }
}