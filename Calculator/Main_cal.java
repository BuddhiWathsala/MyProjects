import javax.swing.*;

public class Main_cal
{
  public static void main(String args[])
  {
    /*Calculator g = new Calculator();
    g.setSize(250,400);
    g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    g.setVisible(true);
    g.setResizable(false);*/
    
    DictioneryInterface dic = new DictioneryInterface();
    dic.setSize(1000,4000);
    dic.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    dic.setVisible(true);
    dic.setResizable(false);
  }
}