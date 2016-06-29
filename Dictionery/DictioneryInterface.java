import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class DictioneryInterface extends JFrame
{
  public static final String wfile = "dict.txt";
  
  private JTextField inputField, answerField;
  private JButton addWord , search,delete,similar,clear;
  private JPanel contentPanel,textPanel,buttonPanel;
  private JTextArea textBox;
  private JLabel headLabel,defLabel;
  
  
  public DictioneryInterface()
  {
    super("2014/CS/067");
    
    //action listners
    Word word = new Word();
    Search searchClass = new Search();
    
    //dimentions 
     Dimension dimButton = new Dimension(120,30);
    
    //buttons
    addWord = new JButton("Add Word");
    search = new JButton("Search");
    delete = new JButton("Delete");
    similar = new JButton("Synonyms");
    clear = new JButton("clear");
    
    addWord.setPreferredSize(dimButton);
    search.setPreferredSize(dimButton);
    delete.setPreferredSize(dimButton);
    similar.setPreferredSize(dimButton);
    clear.setPreferredSize(dimButton);
    
    //textbox
    textBox = new JTextArea(12,40);
    textBox.setPreferredSize(new Dimension(10,40));
    textBox.setLineWrap(true);
    textBox.setWrapStyleWord(true);
    textBox.setFont(new Font("Sans",Font.ITALIC,12));
    textBox.setEditable(true);
    
    //labels
    headLabel = new JLabel("Enter your word");
    headLabel.setForeground(Color.white);
    headLabel.setFont(new Font("Serif",Font.BOLD,14));

    defLabel = new JLabel("Definition");
    defLabel.setForeground(Color.white);
    defLabel.setFont(new Font("Serif",Font.BOLD,14));
    //text fields
    inputField = new JTextField(null,40);
    inputField.setEditable(true);
    inputField.setFont(new Font("Sans",Font.PLAIN,11));
    
    //panel
    contentPanel = new JPanel(new FlowLayout());
    textPanel =  new JPanel(new GridBagLayout());
    buttonPanel = new JPanel(new GridBagLayout());
    contentPanel.setBackground(Color.DARK_GRAY);
    textPanel.setBackground(Color.DARK_GRAY);
    buttonPanel.setBackground(Color.DARK_GRAY);
    GridBagConstraints g = new GridBagConstraints();
    contentPanel.add(textPanel,BorderLayout.EAST);
    contentPanel.add(buttonPanel,BorderLayout.WEST);
    
    
    g.insets = new Insets(10,10,10,10);
    g.gridx=0;
    g.gridy=0;
    buttonPanel.add(search,g);
    g.gridx=0;
    g.gridy=1;
    buttonPanel.add(addWord,g);
    g.gridx=0;
    g.gridy=2;
    buttonPanel.add(search,g);
    g.gridx=0;
    g.gridy=3;
    buttonPanel.add(delete,g);
    g.gridx=0;
    g.gridy=4;
    buttonPanel.add(similar,g);
    g.gridx=0;
    g.gridy=5;
    buttonPanel.add(clear,g);
    
    g.gridx=1;
    g.gridy=0;
    textPanel.add(inputField,g);
    g.gridx=1;
    g.gridy=1;
    textPanel.add(textBox,g);
    g.gridx=0;
    g.gridy=0;
    textPanel.add(headLabel,g);
    g.gridx=0;
    g.gridy=1;
    textPanel.add(defLabel,g);
    
    //buttonPanel.add(addWord);
    //buttonPanel.add(delete);
    //buttonPanel.add(similar);
    //buttonPanel.add(clear);
    //contentPanel.add(answerField);
    
    
    
    
    addWord.addActionListener(word);
    search.addActionListener(searchClass);
    delete.addActionListener(searchClass);
    similar.addActionListener(searchClass);
    clear.addActionListener(searchClass);
    this.setContentPane(contentPanel);
  }//end constructor
  
  //word class implement to process after button click
  class Word implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
        BinarySearchTree myBSTAr[] = BST_Manager.create();
        BinarySearchTree myBST = myBSTAr[0];
      try{
        FileWriter writer = new FileWriter(wfile,true);
        BufferedWriter b_writer = new BufferedWriter(writer);
        JButton src = (JButton) event.getSource();
       
        
        if(src.equals(addWord))
        {
          String getWord = inputField.getText().toLowerCase();
          
          String getDefinition = textBox.getText().toLowerCase();
          
          if(getWord.isEmpty() || getDefinition.isEmpty())
          {
            textBox.setText(null);
            JOptionPane.showMessageDialog(contentPanel,"Please enter a word.od definition");
            
            
          }else
          {
             Node n = myBST.findNode(getWord.trim());
             if(n == null)
             {
               int out = JOptionPane.showConfirmDialog(contentPanel, "Are you sure to add this word to dictionary ?","",JOptionPane.YES_NO_OPTION);
               if(out == JOptionPane.YES_OPTION)
               {
                 writer.write("\n"+getWord.trim()+" - "+getDefinition.trim());
                 JOptionPane.showMessageDialog(contentPanel,"Word successfully added to the file.");
               }
             }else
             {
               JOptionPane.showMessageDialog(contentPanel,"This word already in the file.","Error",JOptionPane.ERROR_MESSAGE);
             }
          }
          b_writer.close();
          writer.close();
        }
      }catch(Exception e)
        {
            e.printStackTrace();
            textBox.insert("error",1);
            JOptionPane.showMessageDialog(contentPanel,"Sorry!! something wrong in your adding.","Error",JOptionPane.ERROR_MESSAGE);
           // answerField.setText("error");
        }
      
    }//end actionPerformed
  }//end Word class
  
  //search class to do the search after clicking search button
  class Search implements ActionListener
  {
    public void actionPerformed(ActionEvent event) 
    {
      
        JButton src = (JButton) event.getSource();
        BinarySearchTree myBSTAr[] = BST_Manager.create();
        BinarySearchTree myBST = myBSTAr[0];
        BinarySearchTree anotherTree = myBSTAr[1];
        
        if(src.equals(search))
        {
          
          //myBST.inOrderTraversal(myBST.root);
          String getWord = null;
          getWord = inputField.getText().toLowerCase();
          System.out.println(getWord);
          if(getWord.isEmpty())
          {
            textBox.setText(null);
            JOptionPane.showMessageDialog(contentPanel,"Please enter your word.");
            return;
          }
          //System.out.println(getWord);
          Node temp = myBST.findNode(getWord.trim()); 
          
          if(temp == null){
            textBox.setText(null);
            JOptionPane.showMessageDialog(contentPanel,"Unable to find this word..","Error",JOptionPane.ERROR_MESSAGE);
            //answerField.setText("Cannot find");
          }
          else{
            textBox.setText(null);
            
            textBox.insert(temp.getDefinition(),0);
            //answerField.setText(temp.getDefinition());
          }
        }//end if
        
        if(src.equals(delete))
        {
          try
          {
           
            
            String getWord = null;
            getWord = inputField.getText().toLowerCase();
            Node tempNode = myBST.findNode(getWord.trim());
            if(getWord.isEmpty())
            {
              textBox.setText(null);
              
              JOptionPane.showMessageDialog(contentPanel,"Please enter your word.");
              return;
            }else if(tempNode== null)
            {
             textBox.setText(null);
             JOptionPane.showMessageDialog(contentPanel,"Unable to find this word..","Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
              int out = JOptionPane.showConfirmDialog(contentPanel, "Are you sure to delete "+getWord+" ?","",JOptionPane.YES_NO_OPTION);
              if(out == JOptionPane.YES_OPTION)
              {
                 FileWriter printWriter = new FileWriter(wfile);
                printWriter.write("");
                myBST.remove(getWord.trim());
                
                textBox.setText(null);
                textBox.insert(getWord.trim()+" deleted",0);
                myBST.inOrderPrint(myBST.root);
                 printWriter.close();
                
              }
             
                
             
            }
          }
           catch(Exception e)
           {
             e.printStackTrace();
           }
        }//end if
        
        if(src.equals(similar))
        {
          
          String currentWord = inputField.getText().toLowerCase();
          Node tempNode = myBST.findNode(currentWord.trim());
          String definition = tempNode.getDefinition();
          if(currentWord.isEmpty())
          {
            textBox.setText(null);
            JOptionPane.showMessageDialog(contentPanel,"Please enter your word.");
            return;
          }
          //System.out.println(getWord);
          ArrayList<Node> tempAr = anotherTree.findSimilar(anotherTree.root,definition.trim()); 
          
          if(tempAr.size() == 0 ||tempAr.size() == 1)
          {
            textBox.setText(null);
            JOptionPane.showMessageDialog(contentPanel,"There's no similar words.");
          }else
          {
            textBox.setText(null);
            int size= tempAr.size();
            for(int i=0;i<size;i++)
            {
              Node n = tempAr.get(i);
              //System.out.println(n.getDefinition());
              if(currentWord.equals(n.getDefinition()))
              {
                continue;
              }else
              {
                textBox.insert(n.getDefinition()+"\n",0);
                //answerField.setText(temp.getDefinition());
              }
            }//end for loop
          }//end outer else
          
        }//end if similar
        
        if(src.equals(clear))
        {
          textBox.setText(null);
          inputField.setText(null);
        }
        
      
    }//end actionPerformed
  }//end class
  
}//end DictioneryInterface