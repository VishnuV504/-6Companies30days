//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}
// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
        Node merge(Node a, Node b)
    {
        // if first linked list is empty then second
        // is the answer
        if (a == null)
            return b;
 
        // if second linked list is empty then first
        // is the result
        if (b == null)
            return a;
 
        // compare the data members of the two linked lists
        // and put the larger one in the result
        Node result;
 
        if (a.data < b.data) {
            result = a;
            result.bottom= merge(a.bottom, b);
        }
 
        else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
 
        result.next = null;
        return result;
    }
 
    Node flatten(Node root)
    {
        // Base Cases
        if (root == null || root.next == null)
            return root;
 
        // recur for list on right
        root.next = flatten(root.next);
 
        // now merge
        root = merge(root, root.next);
 
        // return the root
        // it will be in turn merged with its left
        return root;
    }
 
    /* Utility function to insert a node at beginning of the
       linked list */
    Node push(Node head_ref, int data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(data);
 
        /* 3. Make next of new Node as head */
        new_node.bottom = head_ref;
 
        /* 4. Move the head to point to new Node */
        head_ref = new_node;
 
        /*5. return to link it back */
        return head_ref;
    }

}