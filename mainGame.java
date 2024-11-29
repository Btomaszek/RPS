 /**
   * mainGame --- Creating the buttons for teh RPS class
   * @author Brianne Tomaszek
   */

import javax.swing.*; //Import needed to use JFrame
import java.awt.*; //Import needed to use JPanel layout
import java.awt.event.*; //Import ActionListener
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class mainGame implements ActionListener{

   int rounds = 0;
   int userScore = 0;
   int cpuScore = 0;
   int userInput;
   int cpuInput;
   int ties;
   String winner;
   String finalWinner;
   String nrButton = "Next Round";
   String rButton = "Results";
   
   JFrame f = new JFrame("Rock, Paper, Scissors");
   JFrame resultF = new JFrame();
   
   JPanel panel1;
   JPanel panel1a;
   JPanel panel2;
   JPanel panel3;
   JPanel panel4;
   JPanel panel5;
   JPanel panel6;
   JPanel panel7;  
   JPanel panel8;   
   JPanel panel9;
   JPanel winP;
   JPanel resultP;
   JPanel resultP1;
   JPanel resultP2;
   JPanel resultP3;
   JPanel resultP4;
   
   JLabel label1;
   JLabel label1a;
   JLabel label2;
   JLabel label3;
   JLabel label4; 
   JLabel label4a; 
   JLabel label5; 
   JLabel label5a;
   JLabel label6;
   JLabel label6a;
   JLabel label8a;
   JLabel label8b;
   JLabel label8c;
   JLabel winL;
   JLabel resultL;
   JLabel resultL1;
   JLabel resultL2;
   JLabel resultL3;
   JLabel resultL4;   
   
   JButton backB;
   JButton rockB;
   JButton paperB;
   JButton scissorsB;
   JButton nrB;
   JButton resultsB;
   JButton endB;
   
   ImageIcon rockIcon = new ImageIcon(new ImageIcon("rock.png").getImage().getScaledInstance(180,180, Image.SCALE_DEFAULT));
   ImageIcon paperIcon = new ImageIcon(new ImageIcon("paper.png").getImage().getScaledInstance(180,180, Image.SCALE_DEFAULT));
   ImageIcon scissorIcon = new ImageIcon(new ImageIcon("scissors.png").getImage().getScaledInstance(180,180, Image.SCALE_DEFAULT));


//============================ Game Frame ==========================================   
   public void gameStart() {
      
      f.setSize(550,550);
      f.setTitle("Rock, Paper, Scissors ");
      f.setResizable(false);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
            
   //============================ Rounds label ==========================================      
      
      panel1 = new JPanel();
      panel1.setPreferredSize(new Dimension(400,60));
      panel1.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
      
      label1 = new JLabel();
      label1.setText("ROUND: " + rounds);
      label1.setFont(new Font(null,Font.BOLD,40));
          
      panel1.add(label1); 
   
   //========================== Choose your weapon label ==============================
      
      panel2 = new JPanel();
      panel2.setPreferredSize(new Dimension(400,60));
      panel2.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
      
      label2 = new JLabel();
      label2.setText("CHOOSE YOUR WEAPON:");
      label2.setFont(new Font(null,Font.BOLD,20));
      
      panel2.add(label2);
   
   //============================ RPS buttons ==========================================
      
      panel3 = new JPanel();
      panel3.setPreferredSize(new Dimension(400,60));
      panel3.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
      
      rockB = new JButton("ROCK");
      paperB = new JButton("PAPER");
      scissorsB = new JButton("SCISSORS");
      
      rockB.setFont(new Font(null,Font.BOLD,20));
      paperB.setFont(new Font(null,Font.BOLD,20));
      scissorsB.setFont(new Font(null,Font.BOLD,20));
      
      rockB.addActionListener(this);
      rockB.setFocusable(false);
      paperB.addActionListener(this);
      paperB.setFocusable(false);      
      scissorsB.addActionListener(this);
      scissorsB.setFocusable(false);
      
      panel3.add(rockB);
      panel3.add(paperB);
      panel3.add(scissorsB);
            
   //=====================================================================      
     
      panel4 = new JPanel();
      panel4.setPreferredSize(new Dimension(460,40));
      panel4.setLayout(new FlowLayout(FlowLayout.CENTER,100,0));
      
      label4 = new JLabel();
      label4.setText("USER choice: ");
      label4.setFont(new Font(null,Font.BOLD,20));
      
      label5 = new JLabel();
      label5.setText("CPU choice: ");
      label5.setFont(new Font(null,Font.BOLD,20));      
      
      panel4.add(label4);
      panel4.add(label5);
      
      panel5 = new JPanel();
      panel5.setPreferredSize(new Dimension(460,200));
      panel5.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));
      
      label4a = new JLabel();
      
      label5a = new JLabel();
            
      panel5.add(label4a);
      panel5.add(label5a);
   
   //=====================================================================
      panel6 = new JPanel();
      panel6.setPreferredSize(new Dimension(460,45));
      panel6.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
      
      label6 = new JLabel();
      label6.setText("WINNER: ");
      label6.setFont(new Font(null,Font.BOLD,35)); 
      
      label6a = new JLabel();
      label6a.setFont(new Font(null,Font.BOLD,35));
      
      panel6.add(label6);     
      panel6.add(label6a);
   
   //=====================================================================
      panel8 = new JPanel();
      panel8.setPreferredSize(new Dimension(480,40));
      panel8.setLayout(new FlowLayout(FlowLayout.LEADING,10,0));
      
      label8a = new JLabel();
      label8a.setText("User " +userScore);
      label8a.setFont(new Font(null,Font.BOLD,20)); 
      
      label8b = new JLabel();
      label8b.setText("Cpu "+ cpuScore);
      label8b.setFont(new Font(null,Font.BOLD,20));
      
      label8c = new JLabel();
      label8c.setText("Ties " +ties);
      label8c.setFont(new Font(null,Font.BOLD,20));
      
      nrB = new JButton(nrButton);
      nrB.setFont(new Font(null,Font.BOLD,20));
      nrB.addActionListener(this);
      nrB.setFocusable(false);
      nrB.setEnabled(false);
      
      resultsB = new JButton(rButton);
      resultsB.setFont(new Font(null,Font.BOLD,20));
      resultsB.addActionListener(this);
      resultsB.setFocusable(false);
      
      panel8.add(label8a);   
      panel8.add(label8b);
      panel8.add(label8c); 
      panel8.add(nrB); 
      panel8.add(resultsB);
   
   //=====================================================================                
      f.add(panel1);
      f.add(panel2);
      f.add(panel3);
      f.add(panel4);
      f.add(panel5);
      f.add(panel6);
      f.add(panel8);
      
      f.setVisible(true);
   }

//============================ cpuGen Method ==========================================   

   public void cpuGen() {
   
      Random r  = new Random();
      cpuInput = r.nextInt(3)+1;
      
      switch (cpuInput) {
      
         case 1:
            
            cpuInput = 1;
            label5a.setIcon(rockIcon);
            System.out.println("Cpu chose: rock");
            break;
            
         case 2:
          
            cpuInput = 2;
            label5a.setIcon(paperIcon);
            System.out.println("Cpu chose: paper");
            break;
            
         case 3:
         
            cpuInput = 3;
            label5a.setIcon(scissorIcon);
            System.out.println("Cpu chose: scissors");
            break;
            
      }
   } 

//============================ winCheck Method ==========================================
   
   public void winCheck() {
   
      switch (userInput) {
      
         case 1: 
         
            if(cpuInput == 1) {
            
               String winner = "Tie!";            
               label6a.setText(winner);
               System.out.println("It's a tie!");
               ties++;
               break;
            }
         
            if(cpuInput == 2) {
            
               String winner = "Cpu wins!";
               label6a.setText(winner);
               System.out.println("CPU wins!");
               cpuScore++;
               break;
            }            
                     
            if(cpuInput == 3) {
            
               String winner = "Player wins!";
               label6a.setText(winner);
               System.out.println("You won!");
               userScore++;
               break;
            }
             
         case 2:
         
            if(cpuInput == 1) {
            
               String winner = "Player wins!";
               label6a.setText(winner);
               System.out.println("You won!");
               userScore++;
               break;
            }  
           
            if(cpuInput == 2) {
            
               String winner = "Tie!";
               label6a.setText(winner);
               System.out.println("It's a tie!");
               ties++;
               break;
            }  
           
            if(cpuInput == 3) {
            
               String winner = "Cpu wins!";
               label6a.setText(winner);
               System.out.println("CPU wins!");
               cpuScore++;
               break;
            }      
         
         case 3:
         
            if(cpuInput == 1) {
            
               String winner = "Cpu wins!";
               label6a.setText(winner);
               System.out.println("CPU wins!");
               cpuScore++;
               break;
            } 
          
            if(cpuInput == 2) {
            
               String winner = "Player wins!";
               label6a.setText(winner);
               System.out.println("You won!");
               userScore++;
               break;
            }   
          
            if(cpuInput == 3) {
            
               String winner = "Tie!";
               label6a.setText(winner);
               System.out.println("It's a tie!");
               ties++;
               break;
            }  
      } 
   } 
//============================ resultScreen Method ==========================================  
   public void resultScreen() {
      
      JFrame resultF = new JFrame("Rock, Paper, Scissors Results"); //Constructor creates new frame box
      resultF.setSize(450,450);
      resultF.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
      resultF.setResizable(false);
         
      resultP = new JPanel();
      resultP.setPreferredSize(new Dimension(400,100));
      resultP.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
      
      resultL = new JLabel();
      resultL.setText("RESULTS"); 
      resultL.setFont(new Font(null,Font.BOLD,40));     
      System.out.println("Results: ");    
         
      resultP.add(resultL);
      
      resultP1 = new JPanel();
      resultP1.setPreferredSize(new Dimension(380,60));
      resultP1.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
      
      resultL1 = new JLabel();
      resultL1.setText("ROUNDS: " + rounds);
      resultL1.setFont(new Font(null,Font.BOLD,20));
      System.out.println("Rounds: " + rounds);
      
      resultP1.add(resultL1);
      
      resultP2 = new JPanel();
      resultP2.setPreferredSize(new Dimension(380,60));
      resultP2.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
      
      resultL2 = new JLabel();
      resultL2.setText("User Won: " + userScore);
      resultL2.setFont(new Font(null,Font.BOLD,20));
      System.out.println("User won: " + userScore);
      
      resultP2.add(resultL2);
      
      resultP3 = new JPanel();
      resultP3.setPreferredSize(new Dimension(380,50));
      resultP3.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
      
      resultL3 = new JLabel();
      resultL3.setText("CPU won: " + cpuScore);
      resultL3.setFont(new Font(null,Font.BOLD,20));
      System.out.println("CPU won: " + cpuScore);
      
      resultP3.add(resultL3);
      
      resultP4 = new JPanel();
      resultP4.setPreferredSize(new Dimension(380,50));
      resultP4.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
      
      resultL4 = new JLabel();
      resultL4.setText("Ties: " + ties);
      resultL4.setFont(new Font(null,Font.BOLD,20));
      System.out.println("Ties: " + ties);
      
      resultP4.add(resultL4);
      
      endB = new JButton("End");
      endB.setFont(new Font(null,Font.BOLD,20));
      endB.addActionListener(this);
      endB.setFocusable(false);
      
      resultF.add(resultP);
      resultF.add(resultP1);
      resultF.add(resultP2);
      resultF.add(resultP3);
      resultF.add(resultP4);
      
      winP = new JPanel();
      winP.setPreferredSize(new Dimension(380,50));
      
      winL = new JLabel(); 
      winL.setFont(new Font(null,Font.BOLD,20));                 
         
      winP.add(winL);
      
      resultF.add(winP);
      resultF.add(endB);
      
      if(userScore > cpuScore && userScore > ties) {
         
         String finalWinner = "Congratulations! You win!";
         System.out.println(finalWinner);
         winL.setText(finalWinner);
      
      }
      
      if(cpuScore > userScore && cpuScore > ties) {
         
         String finalWinner = "CPU won! Try again!";
         System.out.println(finalWinner);
         winL.setText(finalWinner);
      
      }       
      
      if(ties > userScore && ties > cpuScore) {
         
         String finalWinner = "Its a tie! Try again!";
         System.out.println(finalWinner);
         winL.setText(finalWinner);
      
      }     
         
      resultF.setVisible(true);
   }
   //============================ Override ==========================================   
   public void actionPerformed(ActionEvent e) { 
      
      //Rock button
      if(e.getSource() == rockB) {
      
         userInput = 1;
         label4a.setIcon(rockIcon);
         System.out.println("You chose rock");
         cpuGen();
         winCheck(); 
         nrB.setEnabled(true);
         rockB.setEnabled(false);
         scissorsB.setEnabled(false);
         paperB.setEnabled(false);        
         
      }
      
      //Paper button
      if(e.getSource() == paperB) {
      
         userInput = 2;
         label4a.setIcon(paperIcon);
         System.out.println("You chose paper");
         cpuGen();
         winCheck();
         nrB.setEnabled(true);
         rockB.setEnabled(false);
         scissorsB.setEnabled(false);
         paperB.setEnabled(false); 
         
         
      }
      //Scissors button
      if(e.getSource() == scissorsB) {
      
         userInput = 3;
         label4a.setIcon(scissorIcon);
         System.out.println("You chose scissors");
         cpuGen();
         winCheck();
         nrB.setEnabled(true);
         rockB.setEnabled(false);
         scissorsB.setEnabled(false);
         paperB.setEnabled(false); 
         
      }
      if(e.getSource() == nrB) {
      //Next round button
         if(rounds < 150) {
         
            rounds++;
            f.remove(panel1);
            f.remove(panel2);
            f.remove(panel3);
            f.remove(panel4);
            f.remove(panel5);
            f.remove(panel6);            
            f.remove(panel8);
            f.repaint();
            gameStart();
           
         }
      }
      
      //Results button
      if(e.getSource() == resultsB ) {
         
         
         f.remove(panel1);
         f.remove(panel2);
         f.remove(panel3);
         f.remove(panel4);
         f.remove(panel5);
         f.remove(panel6);            
         f.remove(panel8);
         resultScreen();
         saveFile(); 
         f.repaint();
         gameStart(); 
      }
      
      //End button
      if(e.getSource() == endB ) {
         
         resultF.setVisible(false);
         resultF.remove(resultP);
         resultF.remove(resultP1);
         resultF.remove(resultP2);
         resultF.remove(resultP3);
         resultF.remove(resultP4);
         System.exit(0); 
      }
   } 
   //============================ saveFile Method ==========================================     
   public void saveFile(){ 
      
      try {          
         
         // write the string on to a file
         File file = new File("scores.txt");
         FileWriter fw = new FileWriter(file);
         PrintWriter pw = new PrintWriter(fw);
         
         if(!file.exists()) {
            
            file.createNewFile();
            pw.println(toString());
         }
         
         if(file.exists()) {
         
            pw.println(toString());
         
         }   
            
         pw.close();
      }
      catch (IOException e) {
         System.out.println("There is an error with the file");
         e.printStackTrace();
      }
   } 
   
   //============================ String Method ======================================   
   public String toString() {
      
      String s = "";
      s = "Rounds: " + rounds + " \nUser won: " + userScore +" \nCPU won: " + cpuScore;
      return s;
   }       
}
