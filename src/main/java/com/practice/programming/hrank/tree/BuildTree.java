/**
 * 
 */
package com.practice.programming.hrank.tree;

/**
 * @author vyomr
 *
 */
import java.util.Scanner;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
class BuildTree
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int ino[] = new int[n];
            int pre[] = new int[n];
            for(int i = 0; i < n; i++)
              ino[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            GfG gfg = new GfG(0);
            root = GfG.buildTree(ino, pre, 0, n-1);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/


class GfG
{
    public static int preIndex;
    GfG(int ind)
    {
        preIndex = ind;
    }
    
  public static Node buildTree(int ino[], int pre[], int st, int end)
    {
	  if (st > end) {
		  return null;
	  }
	  Node tNode = new Node(pre[preIndex++]);
	  
	  if (st == end) {
		  return tNode;
	  }
	  
	  for (int i=st;i<=end;i++) {
		  if (!(ino[i]==tNode.data))
			  continue;
		  int inIndex = i;		  
		  tNode.left = buildTree(ino, pre, st, inIndex-1);
		  tNode.right = buildTree(ino, pre, inIndex+1, end);
	  }
	  System.out.println("returning Node with value : "+ tNode.data);
		return tNode;
       // add your code here
    }
}