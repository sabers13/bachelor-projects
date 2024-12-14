package pack;

import java.io.FileWriter;

public class study {
	String[]studies= {"biology","english","math","chemistry","physics"};
	 public String[] getstudies() {
	        return studies;
	 }
	 {
	 try{    
         FileWriter fw=new FileWriter("C:\\testout.txt");    
         fw.write(studies[2]+"\n"); 
         fw.write(studies[3]);
         fw.close();    
        }catch(Exception e){System.out.println(e);}    
        
	
	
}
}
