import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/*=====================================================start Binary search ======================================================================*/

class BinarySearchTree
{
  public static final String wfile = "dict.txt";
  Node root = null;
  
  /*----------------------------------------------------------------add method----------------------------------------------------------------- */
  public void addNode(Node givenNode)
  {
    //System.out.println(givenNode.getWord());
    if(this.root == null)
    {
      //System.out.println("root:"+givenNode.getWord());
      this.root = givenNode;
      return;
    }else
    {
      Node focusNode = this.root;
      Node parent = null;
      //System.out.println(givenNode.getWord());
      while(true)
      {
        parent = focusNode;
        int flag = StringCheaker.check(parent.getWord() , givenNode.getWord());
        
        if(flag ==-1)
        {
          focusNode = focusNode.rightChild;
          
          if(focusNode == null)
          {
            parent.setRightChild(givenNode);
            return;
          }
        
        }else if(flag == 1)
        {
          focusNode = focusNode.leftChild;
           if(focusNode == null)
          {
            parent.setLeftChild(givenNode);
            return;
          }
        }else
          System.out.println("Add error..");
        
      }//end while
      
    }//end else
    
  }//end addNode
  /*-------------------------end add--------------------------------start findNode------------------------------------------------------------------------*/
  
  //find node function
  public Node findNode(String givenWord)
  {
    Node focusNode = this.root;
    while(!((focusNode.getWord()).equals(givenWord)))
    {
      int flag = StringCheaker.check(focusNode.getWord(),givenWord);
      
      if(flag == 1)
      {
        focusNode = focusNode.leftChild;
      }
      else
      {
        focusNode = focusNode.rightChild;
      }
      if(focusNode == null)
        return null;
    }//end while
    return focusNode;
  }//end findNode
  /*------------------------------end findNode--------------------------------start findSimilar-----------------------------------------------------*/
  ArrayList<Node> array=new ArrayList<Node>(); 
  int i=0;
  public ArrayList<Node> findSimilar(Node givenNode,String s )
  {
      //FileWriter myWriter = new FileWriter("output.txt");
      if(givenNode != null)
      {
        //System.out.println("S"+s);
        findSimilar(givenNode.leftChild,s);
        //System.out.println("s"+givenNode.getWord());
        //myWriter.write(focusNode.getWord());
        if((givenNode.getWord()).equals(s))
        {
          //System.out.println("a"+givenNode.getDefinition());
          array.add(givenNode);
          i++;
        }
        findSimilar(givenNode.rightChild,s);
        
      }//end if
      
      return array;
  }//end findNode
   /*------------------------------end findSimilar--------------------------------start inOrderTravesal-----------------------------------------------------*/
  
  //in order travesal
  public void inOrderTraversal(Node focusNode)
  {
    
      //FileWriter myWriter = new FileWriter("output.txt");
      if(focusNode != null)
      {
        inOrderTraversal(focusNode.leftChild);
        System.out.println(focusNode.getWord());
        //myWriter.write(focusNode.getWord());
        inOrderTraversal(focusNode.rightChild);
        
      }//end if
    
  }//end inOrderTravesal
  
  /*----------------------------------------------------end inOrderTravesal---------------------------start inOrderPrint--------------------------------------------*/
 
  public void inOrderPrint(Node focusNode)
  {
    
    
    try
    {
      FileWriter fileWriter = new FileWriter(wfile,true);
      if(focusNode != null)
      {
        inOrderPrint(focusNode.leftChild);
        String inputString = focusNode.getWord()+" "+focusNode.getDefinition();
        //System.out.println(inputString);
        fileWriter.write(inputString +"\n");
        inOrderPrint(focusNode.rightChild);
      }
      fileWriter.close();
    } catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  /*----------------------------------------------------end inOrderprint---------------------------start remove--------------------------------------------*/
  public boolean remove(String str)
  {
    Node focusNode = root;
    Node parent = root;
    
    boolean isItLeftChild = true;
    
    while(!((focusNode.getWord()).equals( str)))
    {
      parent = focusNode;
      
      int flag = StringCheaker.check(focusNode.getWord(),str);
      //System.out.println(flag);
      if(flag == 1)
      {
        isItLeftChild =true;
        focusNode = focusNode.leftChild;
      }else
      {
        isItLeftChild =false;
        focusNode = focusNode.rightChild;
      }
      
      //don't find focus node
      if(focusNode == null)
        return false;
      
      
        
    }//end while
    
    //node doesn't have children
      if(focusNode.leftChild == null && focusNode.rightChild == null)
      {
        //focusNode ==root
        if(focusNode == root)
        {
          root =null;
        }
        else if(isItLeftChild) //focus node in left side of parent
        {
          parent.leftChild = null;
        }
        else //focus node in right side of parent
        {
          parent.rightChild = null;
        }
        
      }//end outer if
      else if(focusNode.rightChild == null)
      {
        if(focusNode == root)
          root = focusNode.leftChild;
        else if(isItLeftChild)
          parent.leftChild = focusNode.leftChild;
        else
          parent.rightChild = focusNode.leftChild;
        
      }//end outer else if 1
      else if(focusNode.leftChild == null)
      {
        if(focusNode == root)
          root = focusNode.rightChild;
        else if(isItLeftChild)
          parent.leftChild = focusNode.rightChild;
        else
          parent.rightChild = focusNode.leftChild;
      }//end else if 2
      else //if both children of focus node not null
      {
        Node replacement = getReplacementNode(focusNode);
        
        if(focusNode == root)
          root = replacement;
        else if(isItLeftChild)
          parent.leftChild = replacement;
        else
          parent.rightChild = replacement;
        
        replacement.leftChild = focusNode.leftChild;
        
      }//end outer else
      
      return true;
    
  }//end remove

  /*-------------------------------------------------end of remove--------------------start replacement--------------------------------------------------------*/
  
  public Node getReplacementNode(Node replacedNode)
  {
    Node replacementParent = replacedNode;
    Node replacement = replacedNode;
    
    Node focusNode = replacedNode.rightChild;
    
    while(focusNode != null)
    {
      replacementParent = replacement;
      
      replacement = focusNode;
      
      focusNode = focusNode.leftChild;
    }//end while
    
    if(replacement != replacedNode.rightChild)
    {
      replacementParent.leftChild = replacement.rightChild;
      replacement.rightChild = replacedNode.rightChild;
    }//end if
    
    return replacement;
    
  }//end getReplacementNode
  
  /*-------------------------------------------------end of replacement--------------------start main--------------------------------------------------------*/ 
  //main function
  /*public static void main(String args[])
  {
    BinarySearchTree bst = new BinarySearchTree();
   
    try
    {
      
      String reader = null;
      
      FileReader myReader = new FileReader("words.txt");
      
      
      BufferedReader bufferReader = new BufferedReader(myReader);
      
      while((reader = bufferReader.readLine()) != null)
      {
        StringTokenizer tokenizer = new StringTokenizer(reader," ");
        //System.out.println(reader);
        
        String tempWord = tokenizer.nextToken();
        String tempDefinition = tokenizer.nextToken();
        //System.out.println(tempWord);
        //System.out.println(tempDefinition);
        Node tempNode = new Node(tempWord,tempDefinition);
        
        bst.addNode(tempNode);
        
      }
      bufferReader.close();
      myReader.close();
      
    }catch(Exception e)
        {
            e.printStackTrace();
        }

    
    bst.inOrderTraversal(bst.root);
    bst.remove("girl");
    bst.remove("cat");
    bst.inOrderTraversal(bst.root);
    Node temp=null;
    //temp = bst.findNode("buddhi");
    if(temp == null)
      System.out.println("not");
    else
      System.out.println(temp.getDefinition());
  }*/
//end main
  
}//end BinarySearchTree

/*===============================================================class of node===================================================================*/
//class a node
class Node
{
  private String word = null;
  private String definition = null;
  private int key = 0;
  
  Node leftChild = null;
  Node rightChild = null;
  
  //constructor
  Node (String w,String def)
  {
    this.word = w;
    this.definition = def;
  }
  
  //get and set methods
  
  public String getWord()
  {
    return word;
  }
  
  public String getDefinition()
  {
    return definition;
  }
  
  public void setRightChild(Node right)
  {
    this.rightChild = right;
  }
  
  public void setLeftChild(Node left)
  {
    this.leftChild = left;
  }
}

/*================================================================end node class=========================================================*/

/* Note : return 1 for add left side
 *        return -1 for add rigth side
 * 
 * if(1) => goto left
 * if(-1)=> goto right
 * 
 * */
