
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class BasicFile {

    File f;
    File select;
    String text;

    public BasicFile() throws FileNotFoundException {
        select =null;
        text = "";
        JFileChooser choose = new JFileChooser(".");
        int status = choose.showOpenDialog(null);
        PrintWriter fout = new PrintWriter("output.log");

        try {
            if (status != JFileChooser.APPROVE_OPTION) {
                throw new IOException();
            }
            f = choose.getSelectedFile();
            
        } catch (FileNotFoundException e) {
            display(e.toString(), "File not found ....");
        } catch (IOException e) {
            display(e.toString(), "Approve option was not selected");
        }
    }

    void display(String msg, String s) {
        JOptionPane.showMessageDialog(null, msg, s, JOptionPane.ERROR_MESSAGE);
    }

    public void backUpFile() throws FileNotFoundException {
        //File backup = new File(f.getName()+".bak");
        PrintWriter fout = new PrintWriter("output.log");
        DataInputStream input = null;
        DataOutputStream output = null;
        try {
            input = new DataInputStream(new FileInputStream(this.f));
            output = new DataOutputStream(new FileOutputStream(this.f+".bak"));
            try {
                while (true) {
                    byte data = input.readByte();
                    output.writeByte(data);
                }

            } catch (EOFException e) {
                JOptionPane.showMessageDialog(null, "Back up "
                        + "successful");
                fout.println("\n Back up successfull ");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "I couldn't"
                    + " find that file"+e.toString());
            fout.println( "I could'nt find that file");

        } finally {
            try {
                input.close();
                output.close();
                fout.close();
            } catch (Exception e) {
                display(e.toString(), "Problem");
            }
        }
    }
    public String getContent()
  	{
  		String s = "";
  	 	try
  	 	{
  	 		BufferedReader bf = new BufferedReader(new FileReader(f));	
  	 		while ((s = bf.readLine()) != null)
  	 			text += s + "\n";
  	 	}
  	 	catch(IOException e)
  	 	{
  	 	}
  	 	return text;
  	}

    public String getFileSize() {
        long size;
        size = f.length();
        
        return size + " Bytes ";
    }

    public String getPath() {
        return f.getAbsolutePath();
    }

    public String getName() {
        return f.getName();
    }
    
    public void Search(String phrase) throws FileNotFoundException
    {
     
     //PrintWriter fout = new PrintWriter("output.log");   
     String word = null,out =null;
     String menu = "What phrase would you be looking for?\n";
     word = JOptionPane.showInputDialog(menu);
     ArrayList<String> arr = new ArrayList<String>();
        try 
        {
            BufferedReader bf = new BufferedReader(new FileReader(f.getAbsoluteFile())); 
        int linecount = 0;
            String line;
            
            // System.out.println("Searching for " + stringSearch + " in file...");
            
            while (( line = bf.readLine()) != null) 
            {
                linecount++;
                int indexfound = line.indexOf(word);
                
                if (indexfound > -1)
                {
                    out = linecount + ": "+line +"\n";
                    arr.add(out);
                }
            }
            String output =null;
            for(int i = 0; i<arr.size();i++)
            {
                output =arr.get(i).toString(); 
            } 
         //   fout.println(output);
            JOptionPane.showMessageDialog(null,output);
         
        }
    catch (IOException e) 
    {
        JOptionPane.showMessageDialog(null,"IO Error Occurred: " + e.toString());
    }
}



        
}

