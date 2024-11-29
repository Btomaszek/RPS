/**
   * rpsGUI --- Creating the buttons for the RPS class
   * @author Brianne Tomaszek
   */

import javax.swing.*; //Import needed to use JFrame
import java.awt.*; //Import needed to use JPanel layout
import java.awt.event.*; //Import ActionListener


public class rpsGUI implements ActionListener {

   private JFrame mainF;
   
   private JPanel panel1;
   private JPanel panel2;
   private JPanel panel3;
   private JPanel instructP;
   
   
   private JLabel label1;
   private JLabel label1a;
   private JLabel label2;
   private JLabel label3;
   private JLabel instructL;
   
   private JButton instructB;
   private JButton startB;
   private JButton exitB;
   
   ImageIcon rpsIcon = new ImageIcon(new ImageIcon("RPS1.jpeg").getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT));
   
   mainGame main = new mainGame();
   
//================================ Frame ==========================================
   public rpsGUI() {
   
      mainF = new JFrame(); //Constructor creates new frame box
      mainF.setSize(500,500);
      mainF.setTitle("Rock, Paper, Scissors ");
      mainF.setResizable(false);
      mainF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//================================== Title =======================================
      label1 = new JLabel(rpsIcon);
//============================ Title Buttons ==========================================     
      
      panel2 = new JPanel(); //Construct new panel
      panel2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));             
      
      startB = new JButton("Start");
      startB.setFont(new Font(null, Font.BOLD,20));
      startB.addActionListener(this);
      
      exitB = new JButton("Exit");
      exitB.setFont(new Font(null, Font.BOLD,20));
      exitB.addActionListener(this);
      
      instructB = new JButton("Instructions");
      instructB.setFont(new Font(null, Font.BOLD,20));
      instructB.addActionListener(this);
      
      
      panel2.add(label1);
      panel2.add(startB);
      panel2.add(exitB);
      panel2.add(instructB);
            
      mainF.add(panel2);
      
      mainF.setVisible(true);
      
   }   
//================================= Override ==========================================  
      public void actionPerformed (ActionEvent e) {
  
         if(e.getSource() == exitB) {
       
            System.exit(0);
         }
         
         
         if(e.getSource() == startB) {
         
         mainF.remove(panel2);
         mainF.repaint();
         main.gameStart();
         mainF.dispose();
         
         }
      
         if(e.getSource() == instructB) {
      
         JFrame instructF = new JFrame(); //Constructor creates new frame box
         instructF.setSize(400,400);
         instructF.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
         instructF.setResizable(false);
         instructF.setTitle("Instructions");
         
         instructP = new JPanel();
         JTextArea instructT = new JTextArea(100,20);
         
         String text = ("Press start to play this game. You will be playing against the computer. \nClick either rock, paper, or scissors and the computer choice will be randomly generated. \n Rock beats scissors, paper beats rock, and scissors beats paper!\nThe score will be located at the bottom of the screen and a scores.txt file with be generated in your java files. \nHave fun and good luck!");
         instructT.setText(text);
         instructT.setFont(new Font(null,Font.BOLD,20));
         instructT.setEditable(false);
         instructT.setLineWrap(true);
         instructT.setWrapStyleWord(true);
         
         
         instructP.add(instructT);
         instructF.add(instructP);        
         
         instructF.setVisible(true);
      
      }
   }
}