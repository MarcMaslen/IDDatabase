package ApplicationProgramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class IDDatabase {


    public static
    class Main extends JFrame {
        private JTextArea showID;
        private JTextArea actions;
        private JTextField inputID;
        private JLabel lable, console;
        private JLabel RBG;
        private JLabel IDb;
        private JLabel Sort;
        private JLabel resets;
        JButton showmessage = null;


        public Main() {

            // ------------------------------------------------------------------
            //
            // This displays the start message at the begining of the program
            //
            // ------------------------------------------------------------------

            JOptionPane.showMessageDialog(showmessage, "Welcome " +
                    "Click OK to continue");


            // --------------------------------------------------
            //
            // This created an ArrayList list to store the ID's in
            //
            // ----------------------------------------------------

            List IDs = new ArrayList<>();
            IDs.add("293743");
            IDs.add("123243");
            IDs.add("924234");
            IDs.add("242342");

                
            
            // ------------------------------------------------------------------
            //
            // This puts the ID's into a textArea and imputs user input into it
            //
            // -----------------------------------------------------------------


            inputID = new JTextField(6);
            showID = new JTextArea(20, 55);
            actions = new JTextArea(3, 55);
            actions.setEditable(false);
            showID.setEditable(false);
            showID.setForeground(new Color(0,0,255));
            for (Object obj : IDs) {
                showID.append(obj.toString() + "\n");
            }
            JButton addID = new JButton("Add ID's");
            addID.addActionListener(
                    new ActionListener() {
                        //implement the action listener for Add ID button
                        public void actionPerformed(ActionEvent e) {

                            try{
                                String add_ID = inputID.getText().trim();
                                Integer.parseInt(add_ID);
                                IDs.add(add_ID);
                                if  (inputID.getText().length() == 6 ) {
                                    showID.append(add_ID + "\n");
                                    actions.setText(null);
                                    actions.append("ID " + add_ID + " has been added to the list" + "\n");
                                } else {
                                    actions.setText(null);
                                    actions.append("The ID '" + add_ID + "' was not added to the list as it is not a valid ID" + "\n");
                                }

                            } catch (Exception ez){
                                actions.setText(null);
                                actions.append("ID has Illegal characters only use 6 Integers" + "\n");
                            }


                        }
                    }
            );

            // ------------------------------------------------------
            //
            // This will be to allow us to remove id from the Jlist
            //
            // ------------------------------------------------------

            JButton removeID = new JButton("Remove ID");
            removeID.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String remove_ID = inputID.getText();
                            System.out.println(IDs);
                            IDs.remove(remove_ID);
                            if (inputID.getText().length() == 6) {
                                IDs.remove(inputID);
                                showID.setText(null);
                                for (int i = 0; i < IDs.size(); i++) {
                                    showID.append(IDs.get(i) + "\n");
                                }
                                actions.setText(null);
                                actions.append("ID has been removed from the list" + "\n");
                            } else {
                                actions.setText(null);
                                actions.append("The ID was not removed from the list as it is not a valid" + "\n");
                            }
                        }

                    }
            );

            //-------------------------------------------
            //
            // This sorts the Array List
            //
            //-------------------------------------------

            JButton sort = new JButton("Sort List");
            sort.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Collections.sort(IDs);
                            showID.setText(null);
                            for (int i = 0; i < IDs.size(); i++) {
                                showID.append((String) IDs.get(i) + "\n");
                            }
                        }
                    }
            );


            //------------------------------------------------------------------------
            //
            // This Resets the ArrayList to No ID's
            //
            //---------------------------------------------------------------------------

            JButton reset = new JButton("Resets List");
            reset.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            IDs.clear();
                            showID.setText(null);
                            for (int i = 0; i < IDs.size(); i++) {
                                showID.append((String) IDs.get(i) + "\n");
                            }
                            actions.setText(null);
                            actions.append("ID have been successfully cleared!" + "\n");
                        }
                    }
            );


            //--------------------------------------------------------
            //
            // This creates the RBG of for the ID's
            //
            //-------------------------------------------------------


            Color color = new Color(0, 0, 255);
            showID.setForeground(color);
            JLabel RL, GL, BL;
            JTextField R, G, B;
            RL = new JLabel("R:");
            R = new JTextField("0", 3);
            GL = new JLabel("G:");
            G = new JTextField("0", 3);
            BL = new JLabel("B:");
            B = new JTextField("255", 3);

            addID.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try{
                                if  (R.getText().length() <= 3 ) {
                                    if  (G.getText().length() <= 3 ) {
                                        if  (B.getText().length() <= 3 ) {
                                            int R1 = Integer.parseInt(R.getText());
                                            int G1 = Integer.parseInt(G.getText());
                                            int B1 = Integer.parseInt(B.getText());
                                            showID.setForeground(new Color(R1, G1, B1));
                                        }
                                    }
                                }

                            } catch (Exception ez){
                                actions.setText(null);
                                actions.append("ID has Illegal characters only use Integers up to 255" + "\n");
                            }
                        }
                    }
            );

            // ------------------------------------------------
            //
            // This is the Jframe GUI panels
            //
            //---------------------------------------------------


            setTitle("ID Database");


            // First Jpanel for the input ID button.
            JPanel panel1 = new JPanel();
            lable = new JLabel("Input New ID (Then click add ID button) : ");
            panel1.add(lable);
            panel1.add(inputID);
            add(panel1, BorderLayout.NORTH);


            // for the colour panel in the JFrame
            JPanel panel2 = new JPanel();
            RBG = new JLabel("Enter colour here (RGB values): ");
            panel2.add(RBG);
            panel2.add(RL);
            panel2.add(R);
            panel2.add(GL);
            panel2.add(G);
            panel2.add(BL);
            panel2.add(B);
            panel2.add(showID);
            panel2.add(actions);


            //This adds the add/remove button
            IDb = new JLabel("Add/Remove buttons for ID : ");
            panel2.add(IDb);
            panel2.add(addID);
            panel2.add(removeID);
            add(panel2);

            //This adds the Reset buttons
            JPanel panel3 = new JPanel();
            resets = new JLabel("This resets the ID list:");
            panel3.add(resets);
            panel3.add(reset);

            //This adds the Sort button
            Sort = new JLabel("Sort Order of List:");
            panel3.add(Sort);
            panel3.add(sort);
            add(panel3, BorderLayout.SOUTH);

            // This is for displaying the Jframe
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(820, 545);
            setVisible(true);
            setResizable(false);

        }


        public static void main(String[] args) {
            new Main();
        }
    }
}

