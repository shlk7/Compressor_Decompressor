/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author shlok
 */

// About ActionListener
// ActionListener is basically an interface
// it receives the action event
//whatever action is happening it bascially (receives)listens to it
// and performs the action accordingly
// so it is called just after the user performs an action
// it allows us to access the properties of Action event


public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        compressButton=new JButton("Select file to compress");
        compressButton.setBounds(400, 100, 200, 25);
        compressButton.addActionListener(this);
                
        decompressButton=new JButton("Select file to decompress");
        decompressButton.setBounds(400,350,200,25);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.CYAN);
        this.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                } catch (Exception ex) {
//                    Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
                      JOptionPane.showMessageDialog(null,ex.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                } catch (Exception ex) {
                      JOptionPane.showMessageDialog(null,ex.toString());
                }
            }
        }
        
        
        
    }
}
