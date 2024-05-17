import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.undo.UndoManager;

    public class PandaPad extends JFrame implements ActionListener {
        JTextArea textArea;
        String text;
        UndoManager undoManager;
        JMenuBar fontMenu;

        PandaPad() {
        setTitle("Panda Pad");
        setSize(900,500);
        setLocation(110,110);

        undoManager= new UndoManager();
        JMenuBar menuBar= new JMenuBar();  
        textArea = new JTextArea();
        menuBar.setBackground(Color.LIGHT_GRAY);
        
        JMenu fileMenu,editMenu, formatMenu, FontMenu, viewMenu, colorMenu, fontSizeMenu, aboutMenu, countMenu ;
        fileMenu = new JMenu("File");     //file
        fileMenu.setFont(new Font("Arial", Font.PLAIN, 14));

        JMenuItem newItem, openItem, saveItem, printItem, exitItem;
        newItem = new JMenuItem("New");
        newItem.addActionListener(this);
        openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        printItem = new JMenuItem("Print");
        printItem.addActionListener(this);
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        printItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, ActionEvent.CTRL_MASK));
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(printItem);
        fileMenu.add(exitItem);
 
        editMenu = new JMenu("Edit");    //edit
        editMenu.setFont(new Font("Arial", Font.PLAIN, 14));

        JMenuItem undoItem, redoItem, cutItem, copyItem, pasteItem, findItem, findItem2, replaceItem, selectAllItem;
        undoItem = new JMenuItem("Undo");
        undoItem.addActionListener(this);
        redoItem = new JMenuItem("Redo");
        redoItem.addActionListener(this);
        cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(this);
        copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(this);
        pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(this);
        findItem = new JMenuItem("Find");
        findItem.addActionListener(this);
        findItem2 = new JMenuItem("Find Next");
        findItem2.addActionListener(this);
        replaceItem = new JMenuItem("Replace");
        replaceItem.addActionListener(this);
        selectAllItem = new JMenuItem("Select All");
        selectAllItem.addActionListener(this);
        undoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        redoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        findItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        replaceItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        selectAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        editMenu.add(undoItem);
        editMenu.add(redoItem);
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.add(findItem);
        editMenu.add(findItem2);
        editMenu.add(replaceItem);
        editMenu.add(selectAllItem);

        JMenuItem wrapItem;
        formatMenu = new JMenu("Format");    //format
        formatMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        wrapItem = new JMenuItem("Word Wrap: Off");
        wrapItem.addActionListener(this);
        formatMenu.add(wrapItem);

        JMenuItem fontItem, sizeItem;
        FontMenu= new JMenu();
        FontMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        fontItem= new JMenuItem("");
        fontSizeMenu= new JMenu("Font Size");
        fontSizeMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        sizeItem= new JMenuItem("");

        
        FontMenu.add(fontItem);
        FontMenu.add(sizeItem);

        viewMenu = new JMenu("View");    //view
        viewMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        JMenuItem zoomItem = new JMenuItem("Zoom In");
        zoomItem.addActionListener(this);
        JMenuItem zoomOutItem = new JMenuItem("Zoom Out");
        zoomOutItem.addActionListener(this);
        viewMenu.add(zoomItem);
        viewMenu.add(zoomOutItem);

       
        colorMenu = new JMenu("Color");    //color
        colorMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        JMenuItem colourItem, colourItem2, colourItem3, colourItem4, colourItem5, colourItem6, colourItem7;
        colourItem = new JMenuItem("Black");
        colourItem.addActionListener(this);
        colourItem2 = new JMenuItem("White");
        colourItem2.addActionListener(this);
        colourItem3 = new JMenuItem("Pink");
        colourItem3.addActionListener(this);
        colourItem4 = new JMenuItem("Blue");
        colourItem4.addActionListener(this);
        colourItem5 = new JMenuItem("Orange");
        colourItem5.addActionListener(this);
        colourItem6 = new JMenuItem("Yellow");
        colourItem6.addActionListener(this);
        colourItem7 = new JMenuItem("Gray");
        colourItem7.addActionListener(this);
        colorMenu.add(colourItem);
        colorMenu.add(colourItem2);
        colorMenu.add(colourItem3);
        colorMenu.add(colourItem4);
        colorMenu.add(colourItem5);
        colorMenu.add(colourItem6);
        colorMenu.add(colourItem7);

        JMenu textMenu = new JMenu("Font Style");    //edit
        textMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        JMenuItem textItem, textItem2, textItem3;
        textItem = new JMenuItem("Bold");
        textItem.addActionListener(this);
        textItem2 = new JMenuItem("Italic");
        textItem2.addActionListener(this);
        textItem3 = new JMenuItem("Normal");
        textItem3.addActionListener(this);
        textMenu.add(textItem);
        textMenu.add(textItem2);
        textMenu.add(textItem3);


        countMenu = new JMenu("Word Count");    //count
        countMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        JMenuItem count = new JMenuItem("Word Count");
        count.addActionListener(this);
        countMenu.add(count);
        
        aboutMenu = new JMenu("About");     //about
        aboutMenu.setFont(new Font("Arial", Font.PLAIN, 14));
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(this);
        aboutMenu.add(aboutItem);
        

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(viewMenu);
        menuBar.add(colorMenu);
        menuBar.add(textMenu);
        menuBar.add(countMenu);
        menuBar.add(aboutMenu);
        
        textArea.setForeground(Color.BLACK);        //textarea
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 15));
        textArea.setMargin(new Insets(5, 5, 5, 5));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane);

        textArea.getDocument().addUndoableEditListener(e -> {
            undoManager.addEdit(e.getEdit());
            
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
        private static int countWords(String text) {
            if (text.isBlank()) return 0;
            String[] words = text.trim().split("\\s+");
            return words.length;
        }
        
        private void findText(String query, boolean forward) {
            String textContent = textArea.getText();
            int currentIndex = textArea.getCaretPosition();
            int index = -1;
            if (forward==true) {
                index = textContent.indexOf(query, currentIndex + 1);
            } 
            else {
                index = textContent.lastIndexOf(query, currentIndex - 1);
            }
            if (index != -1) {
                textArea.requestFocusInWindow();
                textArea.select(index, index + query.length());
            } 
        }

    @Override 
    public void actionPerformed(ActionEvent ae)   //new
    {   if(ae.getActionCommand()=="New") {
        textArea.setText(" ");
    }
        else if(ae.getActionCommand()=="Open") {     //open
            JFileChooser chooser= new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            int action= chooser.showOpenDialog(this);
            if(action!= JFileChooser.APPROVE_OPTION) {
               return;
            }
            File file= chooser.getSelectedFile();
            try{
                BufferedReader reader= new BufferedReader(new FileReader(file));
                textArea.read(reader, null);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getActionCommand()=="Save") {    //save
            JFileChooser saveas= new JFileChooser();
            saveas.setApproveButtonText("Save");
            int action= saveas.showOpenDialog(this);
            if(action!= JFileChooser.APPROVE_OPTION) {
                return;
             }
             File file= new File(saveas.getSelectedFile()+".txt");
             BufferedWriter write= null;
             try{
                write = new BufferedWriter(new FileWriter(file));
                textArea.write(write);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getActionCommand()=="Print") {    //print
            try{
                textArea.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getActionCommand()=="Exit") {   //exit
           System.exit(0);
        }
        else if(ae.getActionCommand()=="Undo") {   //undo
                undoManager.undo(); 
        }
        else if(ae.getActionCommand()=="Redo") {   //redo
            undoManager.redo();
    }
        else if(ae.getActionCommand()=="Cut") {    //cut
            text= textArea.getSelectedText();
            textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
        }
        else if(ae.getActionCommand()=="Copy") {   //copy
            text= textArea.getSelectedText();
        }
        else if(ae.getActionCommand()=="Paste") {   //paste
            textArea.insert(text, textArea.getCaretPosition());
        }
        else if(ae.getActionCommand()=="Select All") {   //select all
            textArea.selectAll();
        }

        if (ae.getActionCommand()=="Find") {        //find
            String query = JOptionPane.showInputDialog(this, "Find:");
            if (query != null) {
                String text = textArea.getText();
                int index = text.indexOf(query);
                if (index != -1) {
                    textArea.setCaretPosition(index);
                    textArea.setSelectionStart(index);
                    textArea.setSelectionEnd(index + query.length());
                } else {
                    JOptionPane.showMessageDialog(this, "Text not found: " + query);
                }
            }
        } 
        else if (ae.getActionCommand().equals("Find Next")) {   //find next
            String query = JOptionPane.showInputDialog(this, "Find Next:");
            if (query != null) {
                findText(query, true);
            }
        } 
                
        else if (ae.getActionCommand()=="Replace") {         //replace
            String findQuery = JOptionPane.showInputDialog(this, "Find:");
            if (findQuery != null) {
                String replaceQuery = JOptionPane.showInputDialog(this, "Replace with:");
                if (replaceQuery != null) {
                    String text = textArea.getText();
                    String newText = text.replace(findQuery, replaceQuery);
                    textArea.setText(newText);
                }
            }
        }

        else if(ae.getActionCommand()=="Black") {      //color
            textArea.setBackground(Color.BLACK);
            textArea.setForeground(Color.WHITE);
        }
        else if(ae.getActionCommand()=="White") {
            textArea.setBackground(Color.WHITE);
            textArea.setForeground(Color.BLACK);
        }
        else if(ae.getActionCommand()=="Pink") {
            textArea.setBackground(Color.PINK);
            textArea.setForeground(Color.BLACK);
        }
        else if(ae.getActionCommand()=="Blue") {
            textArea.setBackground(Color.BLUE);
            textArea.setForeground(Color.WHITE);
        }
        else if(ae.getActionCommand()=="Orange") {
            textArea.setBackground(Color.ORANGE);
            textArea.setForeground(Color.BLACK);
        }
        else if(ae.getActionCommand()=="Yellow") {
            textArea.setBackground(Color.YELLOW);
            textArea.setForeground(Color.BLACK);
        }
        else if(ae.getActionCommand()=="Green") {
            textArea.setBackground(Color.GREEN);
            textArea.setForeground(Color.BLACK);
        }
        else if(ae.getActionCommand()=="Gray") {
            textArea.setBackground(Color.GRAY);
            textArea.setForeground(Color.WHITE);
        }

        else if (ae.getActionCommand()=="Zoom In") {    //zoom in
            Font currentFont = textArea.getFont();
            float newSize = currentFont.getSize() + 2; // Increase font size by 2 points
            textArea.setFont(currentFont.deriveFont(newSize));
        } 
        else if (ae.getActionCommand()=="Zoom Out") {   //zoom out
            Font currentFont = textArea.getFont();
            float newSize = currentFont.getSize() - 2; // Decrease font size by 2 points
            textArea.setFont(currentFont.deriveFont(newSize));
        }

        else if (ae.getActionCommand()=="Word Wrap: On") {   //word wrap-off
            textArea.setLineWrap(false);
            textArea.setWrapStyleWord(false);
            JMenuItem item = (JMenuItem) ae.getSource();
            item.setText("Word Wrap: Off");
        }
        else if (ae.getActionCommand()=="Word Wrap: Off") {   //word wrap-on
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JMenuItem item = (JMenuItem) ae.getSource();
            item.setText("Word Wrap: On");
        }

        else if(ae.getActionCommand()=="Bold") {   //bold
            text= textArea.getSelectedText();
            if (text != null) {
                Font boldFont = new Font(textArea.getFont().getFamily(), Font.BOLD, textArea.getFont().getSize()); 
                textArea.setFont(boldFont); 
            }
         }
         else if(ae.getActionCommand()=="Italic") {   //italic
            text= textArea.getSelectedText();
            if (text != null) {
                Font italicFont = new Font(textArea.getFont().getFamily(), Font.ITALIC, textArea.getFont().getSize());
                textArea.setFont(italicFont); 
            }
         }
         else if(ae.getActionCommand()=="Normal") {   //normal
            text= textArea.getSelectedText();
            if (text != null) {
                Font defaultFont = new Font(textArea.getFont().getFamily(), Font.PLAIN, textArea.getFont().getSize());
                textArea.setFont(defaultFont); 
            }
         }
        else if (ae.getActionCommand().equals("Word Count")) {     //word count
            String textContent = textArea.getText();
            int words = countWords(textContent);
            JOptionPane.showMessageDialog(this, "Word count: " + words, "Word Count", JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if(ae.getActionCommand().equals("About")) {       //about
            new About();
        }
        
    }

    public static void main(String[] args) {
       PandaPad obj= new PandaPad();
    }
    }
