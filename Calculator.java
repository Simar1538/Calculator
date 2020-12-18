package myswing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
public class Calculator extends JFrame implements ActionListener{
	
	 String s0="";
	 String s1="";
	 String s2="";
	 JTextField t1;
	Calculator()
	{
		
		t1=new JTextField("");
	    t1.setBounds(55,100,250,30);
		add(t1);
		JButton b0=new JButton("+");
		b0.setBounds(50,150,50,30);
		JButton b1=new JButton("-");
		b1.setBounds(120,150,50,30);
		JButton b2=new JButton("*");
		b2.setBounds(190,150,50,30);
		JButton b3=new JButton("/");
		b3.setBounds(260,150,50,30);
		JButton b4=new JButton("1");
		b4.setBounds(50,200,50,30);
		JButton b5=new JButton("2");
		b5.setBounds(120,200,50,30);
		JButton b6=new JButton("3");
		b6.setBounds(190,200,50,30);
		JButton b7=new JButton("4");
		b7.setBounds(260,200,50,30);
		
		JButton b8=new JButton("5");
		b8.setBounds(50,250,50,30);
		JButton b9=new JButton("6");
		b9.setBounds(120,250,50,30);
		JButton b10=new JButton("7");
		b10.setBounds(190,250,50,30);
		JButton b11=new JButton("8");
		b11.setBounds(260,250,50,30);
		
		
		JButton b12=new JButton("9");
		b12.setBounds(50,300,50,30);
		JButton b13=new JButton("0");
		b13.setBounds(120,300,50,30);
		JButton b14=new JButton("=");
		b14.setBounds(190,300,50,30);
		JButton b15=new JButton("C");
		b15.setBounds(260,300,50,30);
		add(b0);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b10);
		add(b11);
		add(b12);
		add(b13);
		add(b14);
		add(b15);
		  	b0.addActionListener(this); 
	        b1.addActionListener(this); 
	        b2.addActionListener(this); 
	        b3.addActionListener(this); 
	        b4.addActionListener(this); 
	        b5.addActionListener(this); 
	        b6.addActionListener(this); 
	        b7.addActionListener(this); 
	        b8.addActionListener(this); 
	        b9.addActionListener(this); 
	        b10.addActionListener(this); 
	        b11.addActionListener(this); 
	        b12.addActionListener(this); 
	        b13.addActionListener(this);
	        b14.addActionListener(this);
	        b15.addActionListener(this);
		setSize(400,400);
		setLayout(null);
		setVisible(true);
	}
	  public void actionPerformed(ActionEvent e) {
	      String command = e.getActionCommand();
	      if (command.charAt(0) == 'C') {                      
	         t1.setText("");
	      }else if (command.charAt(0) == '=') {                    
	         t1.setText(evaluate(t1.getText()));
	      }
	      else if(command.charAt(0) >= '0' && command.charAt(0) <= '9')
	      {         
	    	  t1.setText(t1.getText()+command);
	      }
	      else
	      {
	    	  t1.setText(t1.getText()+" "+ command+" ");
	      }
	   }
	  static int checkPrecedence(String ch)
	  {
	    switch (ch)
	    {
	      case "+":
	      case "-":      return 1;
	      case "*":
	      case "/":      return 2;
	      case "^":      return 3;
	    }
	    return -1;
	  }
	   public static String evaluate(String exp) {
	      String[] arr = exp.split(" ");
	      Stack<String> s=new Stack<>();
	      
	      int i=0;
	      String c; 
	      String out=new String();
	      for(i=0;i<arr.length;i++)
	      {
	        c = arr[i];
	        if(!c.contentEquals("+")&& !c.contentEquals("-")&& !c.contentEquals("*")&& !c.contentEquals("/"))
	        {

	   	          out+=c+" ";
	        }
	        else
	        {
	   	       while (!s.isEmpty() && checkPrecedence(c) <= checkPrecedence(s.peek()))
		             out+=s.pop()+" ";
		          s.push(c);
	        }
	      }

	      while (!s.isEmpty())
	        out+=s.pop()+" ";
	      
	      return result(out);
	   }    
      static String result(String str)
      {
    	  Stack<Integer> s=new Stack<>();
    	  int i, op1, op2;
    	  String exp[]=str.split(" ");
    	    for (i = 0; i < exp.length; ++i)
    	    {
    	      String c=exp[i];
    	      if (!c.contentEquals("+")&& !c.contentEquals("-")&& !c.contentEquals("*")&& !c.contentEquals("/"))
    	        s.push(Integer.parseInt(c));
    	      else
    	      {
    	        op2=s.pop();
    	        op1=s.pop();
    	        switch(c)
    	        {
    	          case "+": s.push(op1 + op2); break;
    	          case "-": s.push(op1 - op2); break;
    	          case "*": s.push(op1 * op2); break;
    	          case "/": s.push(op1 / op2); break;
    	        }
    	      }
    	    }
    	  return String.valueOf(s.pop());
      }
	public static void main(String[] args) {
		new Calculator();
	}
}
