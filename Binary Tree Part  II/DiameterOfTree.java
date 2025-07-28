public class DiameterOfTree{

   static  class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;            
            this.left=null;
            this.right=null;
        }

       static int i=-1;
        public  Node Build(int arr[]){
            i++;
            if (arr[i]==-1) {
                return null;
            }

            Node newNode=new Node(arr[i]);
            newNode.left=Build(arr);
            newNode.right=Build(arr);

            return newNode;


        }

        public  void PreOrder(Node root){
          if(root==null){
            return;
          }
          System.out.println(root.data);
          PreOrder(root.left);
          PreOrder(root.right);
          return;
        }
    }
    public static void main(String[] args) {
        // int arr[]={1,2,4,9,10,-1,-1,-1,-1,5,-1,6-1,7,-1,-1,3,-1,-1};
           int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node n=new Node(0);
        Node root=n.Build(arr);
        System.out.println(root.data);
        n.PreOrder(root);

        // Diameter
        System.out.println("diameter of Binary Tree is: "+diameter(root));
        Info i=new Info(0, 0);
         System.out.println("diameter of Binary Tree is: "+i.DiameterTree(root).d);

    }

    // Approach 1
    public static int diameter(Node root){
        if (root==null) {
            return 0;
            
        }
        int leftDiameter=diameter(root.left);
         int rightDiameter=diameter(root.right);

         int leftheight=height(root.left);
         int rightheight=height(root.right);

         return Math.max(leftDiameter,Math.max(rightDiameter,leftheight+rightheight+1));

    }
    public static int height(Node root){
        if (root==null) {
            return 0;      
        }
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        
        return Math.max(leftheight,rightheight)+1;
    }

    // Approach 2

    static class Info{
        int h;
        int d;
        Info(int d,int h){
            this.d=d;
            this.h=h;
        }

        public Info DiameterTree(Node root){

             if (root==null) {
            return (new Info(0, 0));
            
        }
        Info leftDiameter=DiameterTree(root.left);
         Info rightDiameter=DiameterTree(root.right);

         int height=Math.max(leftDiameter.h,rightDiameter.h)+1;
        int selfDiameter= Math.max(leftDiameter.d,Math.max(rightDiameter.d, leftDiameter.h + rightDiameter.h+1));
       

         return (new Info(selfDiameter, height));

        }
    }

}