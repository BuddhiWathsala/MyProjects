import java.io.*;
import java.awt.*;
import java.util.*;

/*this is the class with static method to read from file and create thr binary search tree*/
class BST_Manager
{
  public static final String wfile = "dict.txt";
  
  //static method to create BST and return this BST 
  public static BinarySearchTree[] create() 
  {
    BinarySearchTree tempBST = new BinarySearchTree();
    BinarySearchTree myBST = new BinarySearchTree();
    
    
    try
    {
      FileWriter writer = new FileWriter(wfile,true);
      FileReader reader= new FileReader(wfile);
      BufferedReader bufferedReader= new BufferedReader(reader);
      
      String currentLine ;
      
      while((currentLine = bufferedReader.readLine()) != null )
      {
        
        //skip the empty lines
        if(currentLine.trim().length() == 0)
          continue;
        
        //System.out.println(currentLine);
        StringTokenizer tokenizer = new StringTokenizer(currentLine," ");
        String tempWord = tokenizer.nextToken().toLowerCase();
        String tempDefinition1 = tokenizer.nextToken("\n").toLowerCase();
        //System.out.println(tempWord);
        String tempDefinition = tempDefinition1.substring(1);
        
        //System.out.println("word: "+tempWord);
        //System.out.println("definition:"+tempDefinition);
        Node tempNode1 = new Node(tempWord.trim(),tempDefinition.trim());
        Node tempNode2 = new Node(tempDefinition.trim(),tempWord.trim());
        myBST.addNode(tempNode1);
        tempBST.addNode(tempNode2);
      }//end while
      
      bufferedReader.close();
      writer.close();
      reader.close();
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
    
    BinarySearchTree[] array ={myBST,tempBST};
    
    
    return array;
  }//end create
  
}//BST_Manager