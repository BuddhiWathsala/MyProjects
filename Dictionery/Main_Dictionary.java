import javax.swing.*;

//main method and class
public class Main_Dictionary
{
  public static void main(String args[])
  {
    
    DictioneryInterface dic = new DictioneryInterface();
    dic.setSize(800,400);
    dic.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    dic.setVisible(true);
    dic.setResizable(true);
  }
}