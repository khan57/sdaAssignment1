/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SDA;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.swing.*;



public class Gui extends JFrame  implements ActionListener {
    
     JFrame frame =new JFrame();
     
     JPanel  mainpanel= new JPanel ();

     JTextArea allfilesarea = new JTextArea ();
     JTextArea allfilesarea2 = new JTextArea ();
     JLabel fullpath;
     
    JMenuItem OF,CF,Exit;
     
  
    String allfiles="";
    String javafiles="";
 
    
    String ext="",name="";
    //
    ArrayList<String> list = new ArrayList<>();
     ArrayList<String> javalist = new ArrayList<>();
    
 public void  display(){
     
    fullpath=new JLabel("Directory/FOlder full Path: ");
            this.add(mainpanel);
            mainpanel.setLayout(null);
            fullpath.setBackground(Color.red);
              
     fullpath.setBounds(0, 0, 400, 50);
     
     mainpanel.add(fullpath);
            mainpanel.setBackground(Color.white);
           mainpanel.add(fullpath);
            allfilesarea.setBounds(2, 50, 250, 250);
             allfilesarea.setSize(200,600);
          
     mainpanel.add(allfilesarea);
     
     
            allfilesarea2.setBounds(280, 50, 250, 250);
             allfilesarea2.setSize(200,600); 
     mainpanel.add(allfilesarea2);
   
    
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
             JMenuBar bar = new JMenuBar();
             JMenu menu = new JMenu("File"); 
             JMenu menuTwo = new JMenu("About");  
             bar.add(menu);     
             bar.add(menuTwo); 
 
            
            
              OF =new JMenuItem("Open folder");
              CF =new JMenuItem("Close folder");
              Exit =new JMenuItem("Exit");
             OF.addActionListener(this);
             CF.addActionListener(this);
             Exit.addActionListener(this);
        menu.add(OF);  
        menu.add(new JSeparator());   
        menu.add(CF);  
        menu.add(new JSeparator());     
        menu.add(Exit); 
 
        setJMenuBar(bar);       
        pack();     
        setSize(600, 700); 
        setVisible(true);     
     
 }


 
     @Override
    public void actionPerformed(ActionEvent ae) {


System.out.print(ae.getSource());

if(CF== ae.getSource() ){

allfilesarea.setText("");
allfilesarea2.setText("");
fullpath.setText("Directory/FOlder full Path: ");

}

else if(Exit==ae.getSource()){

System.exit(1);
}
else if(ae.getSource()==OF){    
    JFileChooser fc=new JFileChooser(); 
    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
     fc.setAcceptAllFileFilterUsed(false);
    int i=fc.showOpenDialog(this);    
       if(i==JFileChooser.APPROVE_OPTION){    
        File f=fc.getSelectedFile();    
        String filepath=f.getPath();   
        fullpath.setText(filepath);
     
       
       filesshow(f);
     
    }
    
       
       int num=1;
       
    for (String list1 : list) {
      allfiles+= num+": "+list1+"\n";
      num++;
    }
    num=1;
     for (String list1 : javalist) {
      javafiles+= num+": "+list1+"\n";
      num++;
    }
    allfilesarea.setText(allfiles);
    allfilesarea2.setText(javafiles);  
    
    
 
    
    }
    }


    
    
    public  void filesshow(File dir) {
         
         int i;
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
               
                filesshow(file);
             
        
       
            } else if(file.isFile()) {
                                    
                                    name=file.getName();
                                          i = name.lastIndexOf('.');
                              ext = i > 0 ? name.substring(i + 1) : "";
                              list.add(name);

                              
                                     if("java".equals(ext)){
                                        
                                         javalist.add(name);
                                     }
                                        
            }
        }
	}
    
  
    

}
