import java.io.*;
import java.util.*;

class Rebuild_tree { 

public void read() { 

try { 
	  String target_path = "/home/razvan/Desktop/File-Archiver/File Archiver/output.huf";
	  File my_file = new File(target_path);
	  byte[] buffer = new byte[(int)(my_file.length())];
      FileInputStream inputStream = new FileInputStream(my_file);

          int total = 0;
          int nRead = 0;
	        
          while((nRead = inputStream.read(buffer)) != -1)
	    {
	       for (int i = 0; i < nRead; i++) {
	        		
	       String bin=Integer.toBinaryString(0xFF & buffer[i] | 0x100).substring(1);
               System.out.println(bin) ;
	       }
	        	
	            total += nRead;
	    }
	        
	        inputStream.close();
	        //System.out.println(total);
	        
	    }
	    catch(FileNotFoundException ex)
	    {
	        System.out.println("File not found.");
	    }
	    catch(IOException ex)
	    {
	        System.out.println(ex);
	    }

}
}

class decode  { 

public static void main(String[] args) { 

	Rebuild_tree p = new Rebuild_tree();
    p.read();

}

}
