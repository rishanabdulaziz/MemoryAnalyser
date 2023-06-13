/*
 * MemoryAnalyserMainForm.java
 *
 * Memory Analyser - main program.
 *
 * An instance of this class displays the screen that allows the user
 * to set the parameters for the strings to be displayed.  
 *
 */
package uk.ac.gre.wg05.memory;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author wg05
 */
public class MemoryAnalyserMainForm extends javax.swing.JFrame {
    
    //Declare memorisingScreeen JDialog
    private JDialog memorisingScreen;
    
    //Declare memoryAnalyserIcon Icon
    private Icon memoryAnalyserIcon = new ImageIcon(getClass().getResource("/Memory Analyser Icon.png"));
    
    //Declare menuBar JMenuBar
    private JMenuBar menuBar;
    
    //Declare optionsMenu JMenu
    private JMenu optionsMenu;
    
    //Declare helpMenuItem, aboutMenuItem and exitMenuItem JMenuItems
    private JMenuItem helpMenuItem, aboutMenuItem, exitMenuItem;
    
    //Contents of helpMenuItem
    private String helpStr = "MEMORY ANALYSER HELP"
            + "\n\nHow to Carry Out Memory Test?\n"
            + "\n"
            + ".      Set your desired font size for the contents.\n"
            + ".      Select Red, Green or Blue font colour for the contents.\n"
            + ".      Select number of seconds to view the contents.\n"
            + ".      Select Digits, Upper Case, Lower Case and/or Symbols as\n"
            + "       the string type for the contents.\n"
            + ".      Set your desired number of strings for the contents.\n"
            + ".      Set your desired length of strings for the contents.\n"
            + ".      After you had finalised your selection, then click\n"
            + "       'Start Test' button.\n"
            + ".      A window will pop up which will display random\n"
            + "       content of strings according to your selection.\n"
            + ".      Try to memorise all the displayed contents within the\n"
            + "       selected number of seconds.\n"
            + ".      You may click 'Finished' button if you had memorised the\n"
            + "       displayed content of strings before the selected number\n"
            + "       of seconds.\n"
            + ".      After that, the window will disappear and MemoryAnalyser\n "
            + "      Answer Form will appear. In this, try to select your\n"
            + "       memorised contents from the list.\n"
            + ".      Click '>>' button to select and '<<' button to deselect\n"
            + "       your memorised contents.\n"
            + ".      After you had finalised your selection, click 'Finished'\n"
            + "       button to check for the correct answers."
            + "\n\nCopyright © 2014 RichTech Solutions Pvt. Ltd.\n";
    
    //Contents of aboutMenuItem
    private String aboutStr = "ABOUT MEMORY ANALYSER"
            + "\n\nMemory Analyser is a program that people can use"
            + "\nto carry out psychological tests on their memory.\n"
            + "\nProgrammed by : Rishan bin Abdul Aziz."
            + "\n\nCopyright © 2014 RichTech Solutions Pvt. Ltd.\n";
    
    //Create keystroke objects
    KeyStroke helpKey = KeyStroke.getKeyStroke("F1");
    KeyStroke aboutKey = KeyStroke.getKeyStroke("F2");
    KeyStroke exitKey = KeyStroke.getKeyStroke("F4");
    
    //Create action listener object
    private actionHandler aH = new actionHandler();
    
    /**
     * Creates new form MemoryAnalyserMainForm
     */
    public MemoryAnalyserMainForm() {
        initComponents();
        customiseScreen();
        addMenu();
    }
    
    //A. Improvements of Appearance
    private void customiseScreen()
    {
        /*  ----------JFrame Codings----------  */
        
        //Set JFrame Icon
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/Memory Analyser Icon.png"));
        //Set JFrame Title
        setTitle("COMP1549 : Memory Analyser");
        //Center JFrame on screen
        setLocationRelativeTo(null);
        //Set JFrame resizable to false
        setResizable(false);
        //
        setSize(new Dimension(650,501));
        
        //Set JLabel layout as BorderLayout
        setLayout(new BorderLayout());
        //Set JLabel background image
        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/Memory Analyser Background.png")));
        //Add JLabel as background
        add(background);
        //Set JLabel layout as FlowLayout
        background.setLayout(new FlowLayout());
        //Set JLabel size
        background.setSize(650,450);
        
        /*  ----------JPanel Codings----------  */
        
        //Set panAppearance background to transparent
        panAppearance.setBackground(new Color(0,0,0,0));
        //Set panColour background to transparent
        panColour.setBackground(new Color(0,0,0,0));
        
        //Set panSlider background to transparent
        panSlider.setBackground(new Color(0,0,0,0));
        //Set jPanel1 background to transparent
        jPanel1.setBackground(new Color(0,0,0,0));
        //Set jPanel2 background to transparent
        jPanel2.setBackground(new Color(0,0,0,0));
        
        //Set panContentOfStrings background to transparent
        panContentOfStrings.setBackground(new Color(0,0,0,0));
        
        //Set panNumberAndLength background to transparent
        panNumberAndLength.setBackground(new Color(0,0,0,0));
        
        /*  ----------JRadioButton Codings----------    */
        
        //Set radRed JRadioButton font to BOLD
        radRed.setFont(new Font("Tahoma",Font.BOLD,13));
        //Add ActionListener to radRed JRadioButton
        radRed.addActionListener(aH);
        
        //Set radGreen JRadioButton font to BOLD
        radGreen.setFont(new Font("Tahoma", Font.BOLD,13));
        //Add ActionListener to radGreen JRadioButton
        radGreen.addActionListener(aH);
        
        //Set radBlue JRadioButton font to BOLD
        radBlue.setFont(new Font("Tahoma", Font.BOLD,13));
        //Add ActionListener to radBlue JRadioButton
        radBlue.addActionListener(aH);
    }
    
    //B. Improvements to behaviour
    private void addMenu()
    {
        /*  ----------JMenuBar Coding----------  */
        
        //Create JMenuBar object and add it to the JFrame
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        /*  ----------JMenu Coding----------    */
        
        //Create optionsMenu JMenu
        optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic('O');
        
        //Add JMenu to JMenuBar
        menuBar.add(optionsMenu);
        
        /*  ----------JMenuItem Codings----------   */
        
        //Create Help JMenuItem
        helpMenuItem = new JMenuItem("Help");
        helpMenuItem.setAccelerator(helpKey);
        helpMenuItem.setMnemonic('H');
        helpMenuItem.addActionListener(aH);
        
        //Create About JMenuItem
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setAccelerator(aboutKey);
        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.addActionListener(aH);
        
        //Create Exit JMenuItem
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setAccelerator(exitKey);
        exitMenuItem.setMnemonic('x');
        exitMenuItem.addActionListener(aH);
        
        //Add JMenuItem to optionsMenu
        optionsMenu.add(helpMenuItem);
        optionsMenu.addSeparator();
        optionsMenu.add(aboutMenuItem);
        optionsMenu.addSeparator();
        optionsMenu.add(exitMenuItem);     
    }
    
    //B. Improvements to the behaviour
    class actionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //Show Help window if helpMenuItem is clicked
            if (e.getSource() == helpMenuItem)
            {
                JOptionPane.showMessageDialog(null, helpStr, "HELP : Memory Analyser", JOptionPane.INFORMATION_MESSAGE, memoryAnalyserIcon);
            }
            
            //Show About window if aboutMenuItem is clicked
            if (e.getSource() == aboutMenuItem)
            {
                JOptionPane.showMessageDialog(null, aboutStr, "ABOUT : Memory Analyser", JOptionPane.INFORMATION_MESSAGE, memoryAnalyserIcon);
            }
            
            //Exit the program if exitMenuItem is clicked
            if (e.getSource() == exitMenuItem)
            {
                System.exit(0);
            }
            
            //C. Additional feature : Change JRadioButtons font colour according to colour name if clicked.
            if (e.getSource() == radRed)
            {
                //Set radRed foreground to RED colour
                radRed.setForeground(Color.RED);
                //Set radGreen foreground to BLACK colour
                radGreen.setForeground(Color.BLACK);
                //Set radBlue foreground to BLACK colour
                radBlue.setForeground(Color.BLACK);
            }
            
            if(e.getSource() == radGreen)
            {
                //Set radGreen foreground to GREEN colour
                radGreen.setForeground(Color.GREEN);
                //Set radRed foreground to BLACK colour
                radRed.setForeground(Color.BLACK);
                //Set radBlue foreground to BLACK colour
                radBlue.setForeground(Color.BLACK);
            }
            
            if(e.getSource() == radBlue)
            {
                //Set radBlue foreground to BLUE colour
                radBlue.setForeground(Color.BLUE);
                //Set radRed foreground to BLACK colour
                radRed.setForeground(Color.BLACK);
                //Set radGreen foreground to BLACK colour
                radGreen.setForeground(Color.BLACK);
            }
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpColours = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panAppearance = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFontSize = new javax.swing.JTextField();
        panColour = new javax.swing.JPanel();
        radRed = new javax.swing.JRadioButton();
        radGreen = new javax.swing.JRadioButton();
        radBlue = new javax.swing.JRadioButton();
        panSlider = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnDown = new javax.swing.JButton();
        sldNumberOfSecs = new javax.swing.JSlider();
        jPanel2 = new javax.swing.JPanel();
        btnUp = new javax.swing.JButton();
        panContentOfStrings = new javax.swing.JPanel();
        chkDigits = new javax.swing.JCheckBox();
        chkUpperCase = new javax.swing.JCheckBox();
        chkLowerCase = new javax.swing.JCheckBox();
        chkSymbols = new javax.swing.JCheckBox();
        panNumberAndLength = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumberOfItems = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLengthOfStrings = new javax.swing.JTextField();
        btnStartTest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 501));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Memory Analyser Icon.png"))); // NOI18N
        getContentPane().add(jLabel5);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Memory Analyser.png"))); // NOI18N
        getContentPane().add(jLabel6);

        panAppearance.setBorder(javax.swing.BorderFactory.createTitledBorder("Appearance of Strings"));
        panAppearance.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Font Size:");
        panAppearance.add(jLabel4);

        txtFontSize.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtFontSize.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFontSize.setText("14");
        txtFontSize.setPreferredSize(new java.awt.Dimension(25, 25));
        panAppearance.add(txtFontSize);

        panColour.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        grpColours.add(radRed);
        radRed.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radRed.setText("Red");
        panColour.add(radRed);

        grpColours.add(radGreen);
        radGreen.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radGreen.setText("Green");
        panColour.add(radGreen);

        grpColours.add(radBlue);
        radBlue.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        radBlue.setText("Blue");
        panColour.add(radBlue);

        panAppearance.add(panColour);

        getContentPane().add(panAppearance);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Number of seconds to view:");
        panSlider.add(jLabel2);

        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        btnDown.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Left Arrow.png"))); // NOI18N
        btnDown.setMargin(new java.awt.Insets(1, 2, 1, 3));
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });
        jPanel1.add(btnDown);

        panSlider.add(jPanel1);

        sldNumberOfSecs.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        sldNumberOfSecs.setMajorTickSpacing(20);
        sldNumberOfSecs.setMaximum(120);
        sldNumberOfSecs.setMinorTickSpacing(5);
        sldNumberOfSecs.setPaintLabels(true);
        sldNumberOfSecs.setPaintTicks(true);
        sldNumberOfSecs.setSnapToTicks(true);
        sldNumberOfSecs.setValue(20);
        sldNumberOfSecs.setPreferredSize(new java.awt.Dimension(300, 50));
        panSlider.add(sldNumberOfSecs);

        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        btnUp.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Right Arrow.png"))); // NOI18N
        btnUp.setMargin(new java.awt.Insets(1, 3, 1, 3));
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });
        jPanel2.add(btnUp);

        panSlider.add(jPanel2);

        getContentPane().add(panSlider);

        panContentOfStrings.setBorder(javax.swing.BorderFactory.createTitledBorder("Content of Strings"));

        chkDigits.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        chkDigits.setText("digits");
        chkDigits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDigitsActionPerformed(evt);
            }
        });
        panContentOfStrings.add(chkDigits);

        chkUpperCase.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        chkUpperCase.setText("uppercase");
        chkUpperCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUpperCaseActionPerformed(evt);
            }
        });
        panContentOfStrings.add(chkUpperCase);

        chkLowerCase.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        chkLowerCase.setSelected(true);
        chkLowerCase.setText("lowercase");
        panContentOfStrings.add(chkLowerCase);

        chkSymbols.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        chkSymbols.setText("symbols");
        panContentOfStrings.add(chkSymbols);

        getContentPane().add(panContentOfStrings);

        panNumberAndLength.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Number of Strings:");
        panNumberAndLength.add(jLabel1);

        txtNumberOfItems.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNumberOfItems.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNumberOfItems.setText("5");
        txtNumberOfItems.setPreferredSize(new java.awt.Dimension(25, 25));
        txtNumberOfItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumberOfItemsActionPerformed(evt);
            }
        });
        panNumberAndLength.add(txtNumberOfItems);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Length of Strings:");
        panNumberAndLength.add(jLabel3);

        txtLengthOfStrings.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLengthOfStrings.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtLengthOfStrings.setText("3");
        txtLengthOfStrings.setPreferredSize(new java.awt.Dimension(25, 25));
        panNumberAndLength.add(txtLengthOfStrings);

        getContentPane().add(panNumberAndLength);

        btnStartTest.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnStartTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Start Test Button.png"))); // NOI18N
        btnStartTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTestActionPerformed(evt);
            }
        });
        getContentPane().add(btnStartTest);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkDigitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDigitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkDigitsActionPerformed
    // move slider down to next Major Tick Value
    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        int currentVal = sldNumberOfSecs.getValue();
        int majorTickVal = sldNumberOfSecs.getMajorTickSpacing();
        int newVal  = ((currentVal-1) / majorTickVal) * majorTickVal;
        sldNumberOfSecs.setValue(newVal);
    }//GEN-LAST:event_btnDownActionPerformed
    // move slider up to next Major Tick Value
    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        int currentVal = sldNumberOfSecs.getValue();
        int majorTickVal = sldNumberOfSecs.getMajorTickSpacing();
        int newVal  = (((currentVal+1) / majorTickVal) * majorTickVal) + majorTickVal;
        sldNumberOfSecs.setValue(newVal);
    }//GEN-LAST:event_btnUpActionPerformed
    // User has clicked the button to start the memory test
    private void btnStartTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartTestActionPerformed
       // Get the parameters entered by the user - length of items etc
        int numberOfItems = Integer.parseInt(txtNumberOfItems.getText());
        int lengthOfStrings = Integer.parseInt(txtLengthOfStrings.getText());
        int numberOfSecs = sldNumberOfSecs.getValue();
        int fontSize = Integer.parseInt(txtFontSize.getText());
        boolean useDigits = chkDigits.isSelected();
        boolean useUpperCase = chkLowerCase.isSelected();
        boolean useLowerCase = chkUpperCase.isSelected();
        boolean useSymbols = chkSymbols.isSelected();
        Color fontColour = Color.RED;
        if (radBlue.isSelected()) {
            fontColour = Color.BLUE;
        } else if (radGreen.isSelected()) {
            fontColour = Color.GREEN;
        }

        // Create the dialog to display the items to be memorised
        // to the user.  Pass the parameters (length of time etc).
        memorisingScreen = new JDialog(this, "Memorise these items");
        DisplayStringsDialog memDialog = new DisplayStringsDialog(this,
                useLowerCase,
                useUpperCase,
                useDigits,
                useSymbols,
                numberOfItems,
                lengthOfStrings,
                numberOfSecs,
                fontSize,
                fontColour);
        memorisingScreen.add(memDialog);
        memorisingScreen.setModal(true);
        memorisingScreen.pack();
        memorisingScreen.setLocation(300, 200);
        memorisingScreen.setVisible(true);
    }//GEN-LAST:event_btnStartTestActionPerformed

    private void txtNumberOfItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumberOfItemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberOfItemsActionPerformed

    private void chkUpperCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUpperCaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkUpperCaseActionPerformed
 // User has returned from the memorising screen
    public void finishedMemorising(MemoryDataGenerator mdg) {
        memorisingScreen.dispose();

        // Create dialog for the screen where the user attempts
        // to choose the items they memorised from a list.
        JDialog answeringScreen = new JDialog(this, "Select items you remember");
        MemoryAnalyserAnswerForm answerDialog = new MemoryAnalyserAnswerForm(this, mdg);
        answeringScreen.add(answerDialog);
        answeringScreen.setModal(true);
        answeringScreen.pack();
        answeringScreen.setLocation(300, 200);
        answeringScreen.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemoryAnalyserMainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnStartTest;
    private javax.swing.JButton btnUp;
    private javax.swing.JCheckBox chkDigits;
    private javax.swing.JCheckBox chkLowerCase;
    private javax.swing.JCheckBox chkSymbols;
    private javax.swing.JCheckBox chkUpperCase;
    private javax.swing.ButtonGroup grpColours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panAppearance;
    private javax.swing.JPanel panColour;
    private javax.swing.JPanel panContentOfStrings;
    private javax.swing.JPanel panNumberAndLength;
    private javax.swing.JPanel panSlider;
    private javax.swing.JRadioButton radBlue;
    private javax.swing.JRadioButton radGreen;
    private javax.swing.JRadioButton radRed;
    private javax.swing.JSlider sldNumberOfSecs;
    private javax.swing.JTextField txtFontSize;
    private javax.swing.JTextField txtLengthOfStrings;
    private javax.swing.JTextField txtNumberOfItems;
    // End of variables declaration//GEN-END:variables
}
