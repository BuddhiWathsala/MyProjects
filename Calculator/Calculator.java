import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calculator extends JFrame
{
  private JTextField answerField;
  private JButton one, two, three, four, five, six, seven, eight, nine, zero, add, sub, mult, div, equals, clear,sqrt,sqr,decimal,negative,back,fib,fact,power,sin,cos,tan,log;
  private String stemp1, stemp2, sanswer;
  private double answer = 0.0;
  private JPanel contentPanel;
  private boolean equalsClicked = false, opChosen = false;
  char operation = ' ';
  
  public Calculator()
  {
    //call the constructor of JFrame
    
    super("Buddhi\'s Calculator");
    //.....................................................................................
    
    //set text field to display answer or get inputs
    
    answerField = new JTextField(null,20);
    answerField.setEditable(false);
    //....................................................................................
    
    //set number buttons
    
    one = new JButton("1");
    two = new JButton("2");
    three = new JButton("3");
    four = new JButton("4");
    five = new JButton("5");
    six = new JButton("6");
    seven = new JButton("7");
    eight = new JButton("8");
    nine = new JButton("9");
    zero = new JButton("0");
    add = new JButton("+");
    sub = new JButton("-");
    mult = new JButton("*");
    div = new JButton("/");
    equals = new JButton("=");
    clear = new JButton("clear");
    sqrt = new JButton("√");
    sqr = new JButton("sqr");
    decimal = new JButton(".");
    negative = new JButton("+/-");
    back = new JButton("back");
    fib = new JButton("fib");
    fact =new JButton("fact");
    power = new JButton("pow");
    sin = new JButton("sin"); 
    cos = new JButton("cos");
    tan = new JButton("tan");
    log = new JButton("log");
    //set dimentions to each button
    
    Dimension dim = new Dimension(75,25);
    
    one.setPreferredSize(dim);
    two.setPreferredSize(dim);
    three.setPreferredSize(dim);
    four.setPreferredSize(dim);
    five.setPreferredSize(dim);
    six.setPreferredSize(dim);
    seven.setPreferredSize(dim);
    eight.setPreferredSize(dim);
    nine.setPreferredSize(dim);
    zero.setPreferredSize(dim);
    equals.setPreferredSize(dim);
    add.setPreferredSize(dim);
    sub.setPreferredSize(dim);
    mult.setPreferredSize(dim);
    div.setPreferredSize(dim);
    clear.setPreferredSize(dim);
    sqrt.setPreferredSize(dim);
    sqr.setPreferredSize(dim);
    decimal.setPreferredSize(dim);
    negative.setPreferredSize(dim);
    back.setPreferredSize(dim);
    fib.setPreferredSize(dim);
    fact.setPreferredSize(dim);
    power.setPreferredSize(dim);
    sin.setPreferredSize(dim);
    cos.setPreferredSize(dim);
    tan.setPreferredSize(dim);
    log.setPreferredSize(dim);
    
    Numbers num = new Numbers();
    Calc cal = new Calc();
    
    //add actionListeners to numbers
    one.addActionListener(num);two.addActionListener(num);three.addActionListener(num);four.addActionListener(num);
    five.addActionListener(num);six.addActionListener(num);seven.addActionListener(num);eight.addActionListener(num);
    nine.addActionListener(num);zero.addActionListener(num);decimal.addActionListener(num);negative.addActionListener(num);
    
    
    //add actionlisteners to symbols
    add.addActionListener(cal);mult.addActionListener(cal);sub.addActionListener(cal);div.addActionListener(cal);
    equals.addActionListener(cal);clear.addActionListener(cal);sqrt.addActionListener(cal);sqr.addActionListener(cal);
    fib.addActionListener(cal);fact.addActionListener(cal);power.addActionListener(cal);back.addActionListener(cal);
    sin.addActionListener(cal);cos.addActionListener(cal);tan.addActionListener(cal);log.addActionListener(cal);
    
    //set content panel to grab all items in interface
    contentPanel = new JPanel();
    contentPanel.setBackground(Color.BLACK);
    contentPanel.add(answerField,BorderLayout.NORTH);
    contentPanel.setLayout(new FlowLayout());
    
    //add numbers and symbols to GUI
    contentPanel.add(one); contentPanel.add(two); contentPanel.add(three); contentPanel.add(four);
    contentPanel.add(five); contentPanel.add(six); contentPanel.add(seven); contentPanel.add(eight);
    contentPanel.add(nine); contentPanel.add(zero); contentPanel.add(equals); contentPanel.add(add);
    contentPanel.add(mult); contentPanel.add(sub); contentPanel.add(div); contentPanel.add(clear);
    contentPanel.add(sqrt);contentPanel.add(sqr);contentPanel.add(decimal);contentPanel.add(negative);
    contentPanel.add(back);contentPanel.add(fact);contentPanel.add(fib);contentPanel.add(power);
    contentPanel.add(sin);contentPanel.add(cos);contentPanel.add(tan);contentPanel.add(log);
    
    this.setContentPane(contentPanel);
  }

  
  //see wich button is to click
  private class Numbers implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      JButton src = (JButton) event.getSource();
      
      //when click one
      if(src.equals(one))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "1";
          }else
          {
            stemp1 += "1";
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "1";
          }else
          {
            stemp2 += "1";
          }
        }
      }
      
      //when click two
       if(src.equals(two))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "2";
          }else
          {
            stemp1 += "2";
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "2";
          }else
          {
            stemp2 += "2";
          }
        }
      }
       
       //when click three
        if(src.equals(three))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "3";
          }else
          {
            stemp1 += "3";
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "3";
          }else
          {
            stemp2 += "3";
          }
        }
      }
        
        //when click four
         if(src.equals(four))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "4";
          }else
          {
            stemp1 += "4";
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "4";
          }else
          {
            stemp2 += "4";
          }
        }
      }
         
         //when click five
          if(src.equals(five))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "5";
          }else
          {
            stemp1 += "5";
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "5";
          }else
          {
            stemp2 += "5";
          }
        }
      }
          
          //when click six
           if(src.equals(six))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "6";
          }else
          {
            stemp1 += "6";
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "6";
          }else
          {
            stemp2 += "6";
          }
        }
      }
           
           //when click seven
            if(src.equals(seven))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "7";
          }else
          {
            stemp1 += "7";
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "7";
          }else
          {
            stemp2 += "7";
          }
        }
      }
            
         //when click eight
        if(src.equals(eight))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "8";
          }else
          {
            stemp1 += "8";
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "8";
          }else
          {
            stemp2 += "8";
          }
        }
      }
      
      //when click nine
      if(src.equals(nine))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "9";
          }else
          {
            stemp1 += "9";
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "9";
          }else
          {
            stemp2 += "9";
          }
        }
      }
      
      //when click zero
      if(src.equals(zero))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "0";
          }else
          {
            stemp1 += "0";
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "0";
          }else
          {
            stemp2 += "0";
          }
        }
      }
      
      //when click decimal
      if(src.equals(decimal))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "0.";
          }else
          {
            if(stemp1 != null)
            {
              if(stemp1.contains("."))
              {
                System.out.println("You already have a decimal point");
              }else{
                stemp1 += ".";
              }
            }
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "0.";
          }else
          {
            if(stemp2 != null)
            {
              if(stemp2.contains("."))
              {
                System.out.println("You already have a decimal point");
              }else{
                stemp2 += ".";
              }
            }
          }
        }
      }
      
       //when click negative
      if(src.equals(negative))
      {
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            stemp1 = "-";
          }else
          {
            if(stemp1 != null && stemp1.startsWith("-"))
            {
              stemp1 = stemp1.substring(1);
            }else{
              stemp1 = "-" + stemp1;
            }
          }
        }else
        {
          if(stemp2 == null)
          {
            stemp2 = "-";
          }else
          {
            if(stemp2 != null && stemp2.startsWith("-"))
            {
              stemp2 = stemp2.substring(1);
            }else{
              stemp2 = "-" + stemp2;
            }
          }
        }
      }
      
      
      
      //others
      if(equalsClicked == false)
      {
        if(opChosen == false)
        {
          answerField.setText(stemp1);
        }else
        {
          answerField.setText(stemp2);
        }
      }
      
      if(opChosen == false)
      {
        answerField.setText(stemp1);
      }else
      {
        answerField.setText(stemp2);
      }
      
      
    }
  }
  class Calc implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      JButton src = (JButton) event.getSource();
      
      //when click add button
      if(src.equals(add))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          if(stemp1 != null && stemp2 == null)
          {
            opChosen = true;
            operation = '+';
          }else
          {
            if(stemp1 != null && stemp2 != null)
            {
              double d1 = Double.parseDouble(stemp1);
              double d2 = Double.parseDouble(stemp2);
              
              answer = d1+d2;
              sanswer = Double.toString(answer);
              stemp1 = sanswer;
              stemp2 = null;
              answerField.setText(sanswer);
              
            }
          }
        }
      }
      
      //when click mult button
      if(src.equals(mult))
      {
        System.out.println("qqqq");
        if(stemp1 == null)
        {
          System.out.println("coose your number first!!");
        }else
        {
          if(stemp1 != null && stemp2 == null)
          {
            opChosen = true;
            operation = '*';
          }else
          {
            if(stemp1 != null && stemp2 != null)
            {
              if(stemp1 != null && stemp2 != null)
            {
              double d1 = Double.parseDouble(stemp1);
              double d2 = Double.parseDouble(stemp2);
              
              answer = d1*d2;
              sanswer = Double.toString(answer);
              stemp1 = sanswer;
              stemp2 = null;
              answerField.setText(sanswer);
              opChosen = true;
            }
          }
        }
        }}
      
      //when click sub button
      if(src.equals(sub))
      {
        System.out.println("qqqq");
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          if(stemp1 != null && stemp2 == null)
          {
            opChosen = true;
            operation = '-';
          }else
          {
            if(stemp1 != null && stemp2 != null)
            {
              double d1 = Double.parseDouble(stemp1);
              double d2 = Double.parseDouble(stemp2);
              System.out.println(d1);
              answer = d1-d2;
              sanswer = Double.toString(answer);
              stemp1 = sanswer;
              stemp2 = null;
              answerField.setText(sanswer);
              
            }
          }
        }
      }
      
      //when click div button
      if(src.equals(div))
      {
        //System.out.println("qqqq");
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          if(stemp1 != null && stemp2 == null)
          {
            opChosen = true;
            operation = '/';
          }else
          {
            if(stemp1 != null && stemp2 != null)
            {
              double d1 = Double.parseDouble(stemp1);
              double d2 = Double.parseDouble(stemp2);
              //System.out.println(d1);
              if(d2==0.0){
                answerField.setText("can't divide by zero");
              }else{
              answer = d1/d2;
              sanswer = Double.toString(answer);
              stemp1 = sanswer;
              stemp2 = null;
              answerField.setText(sanswer);
              }
            }
          }
        }
      }
      
      //when click sqrt button
      if(src.equals(sqrt))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          double d1 = Double.parseDouble(stemp1);
          
          if(d1<0)
          {
            answerField.setText("Can't find negative sqrt!!");
          }else{
          answer = Math.sqrt(d1);
          sanswer = Double.toString(answer);
          answerField.setText(sanswer);
          }
        }
        
      }
      
      
      //when click sqr button
      if(src.equals(sqr))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          double d1 = Double.parseDouble(stemp1);
          
          stemp1 = Double.toString(answer);
          answer = Math.pow(d1,2);
          sanswer = Double.toString(answer);
          answerField.setText(sanswer);
          
        }
        
      }
      
      //when click sin button
      if(src.equals(sin))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          double d1 = Double.parseDouble(stemp1);
          
         
         
          answer = Math.sin(d1);
          sanswer = Double.toString(answer);
          answerField.setText(sanswer);
          
        }
        
      }
      
      //when click cos button
      if(src.equals(cos))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          double d1 = Double.parseDouble(stemp1);
          
         
         
          answer = Math.cos(d1);
          sanswer = Double.toString(answer);
          answerField.setText(sanswer);
          
        }
        
      }
      
      
      //when click tan button
      if(src.equals(tan))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          double d1 = Double.parseDouble(stemp1);
          
         
         
          answer = Math.tan(d1);
          sanswer = Double.toString(answer);
          answerField.setText(sanswer);
          
        }
        
      }
      
      
      //when click log button
      if(src.equals(log))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          double d1 = Double.parseDouble(stemp1);
          
          if(d1<0)
          {
            answerField.setText("Can't find negative sqrt!!");
          }else{
          answer = Math.log(d1);
          sanswer = Double.toString(answer);
          answerField.setText(sanswer);
          }
        }
        
      }
      
      
      //when click fib button
      if(src.equals(fib))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          StringTokenizer s = new StringTokenizer(stemp1,".");
          stemp1 = s.nextToken();
          int num = Integer.parseInt(stemp1);
          
          
          int answer1 = My_Math.fibonacci(num);
          stemp1 = Integer.toString(answer1);
          sanswer = Integer.toString(answer1);
          answerField.setText(sanswer);
          
        }
        
      }
      
      //when click fact button
      if(src.equals(fact))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          StringTokenizer s = new StringTokenizer(stemp1,".");
          stemp1 = s.nextToken();
          int num = Integer.parseInt(stemp1);
          
          
          int answer1 = My_Math.factorial(num);
          sanswer = Integer.toString(answer1);
          stemp1 = Integer.toString(answer1);
          answerField.setText(sanswer);
          
        }
        
      }
      
     //when click power button
       if(src.equals(power))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          if(stemp1 != null && stemp2 == null)
          {
            opChosen = true;
            operation = 'p';
          }else
          {
            if(stemp1 != null && stemp2 != null)
            {
              double d1 = Double.parseDouble(stemp1);
              int d2 = Integer.parseInt(stemp2);
              
              answer = Math.pow(d1,d2);
              sanswer = Double.toString(answer);
              stemp1 = sanswer;
              stemp2 = null;
              answerField.setText(sanswer);
              
            }
          }
        }
      }
      
     //when click Equal button
      if(src.equals(equals))
      {
        if(stemp1 == null)
        {
          answerField.setText("choose your number first!!");
        }else
        {
          if(stemp1 != null && stemp2 == null)
          {
            answerField.setText("choose your both number first!!");
          }else
          {
            if(stemp1 != null && stemp2 != null)
            {
              double d1=0.0, d2 = 0.0;
              
              d1 = Double.parseDouble(stemp1);
              d2 = Double.parseDouble(stemp2);
              stemp1=null;
              stemp2=null;
              
              switch(operation)
              {
                case('+'):
                  answer = d1 + d2;
                  break;
                case('-'):
                  answer = d1 - d2;
                  break;
                case('*'):
                  answer = d1 *d2;
                  break;
                 case('/'):
                   if(d2 == 0.0)
                 {
                   answer = 0;
                   answerField.setText("cannot divide by zero");
                   break;
                 }else{
                   answer = d1 / d2;
                   break;
                 }
                case('p'):
                  int pwr = Integer.parseInt(stemp2);
                  answer = Math.pow(d1,pwr);
                default:
                answerField.setText("unknown");
                break;
              }
              stemp1 = Double.toString(answer);
              sanswer = Double.toString(answer);
              answerField.setText(sanswer);
            }
          }
        }
      }
      
      //when click clear button
      if(src.equals(clear))
      {
        stemp1 = null;
        stemp2 = null;
        equalsClicked = false;
        opChosen = false;
        operation = ' ';
        answerField.setText(null);
        sanswer = null;
      }
      
      //when click back button
      if(src.equals(back))
      {
        
        if(opChosen == false)
        {
          if(stemp1 == null)
          {
            answerField.setText("NOTHING TO DELETE!!");
          }else
          {
            stemp1 = stemp1.substring(0,stemp1.length()-1);
            answerField.setText(stemp1);
          }
        }else
        {
          if(stemp2 == null && stemp1 == null)
          {
            answerField.setText("NOTHING TO DELETE!!");
          }else if(stemp2 != null && stemp1 == null)
          {
            stemp2 = stemp2.substring(0,stemp2.length()-1);
            answerField.setText(stemp2);
          }else
          {
            stemp1 = stemp1.substring(0,stemp1.length()-1);
            answerField.setText(stemp1);
            System.out.println(stemp1);
          }
        }
      }
      
      
    }
  }
}


  
  