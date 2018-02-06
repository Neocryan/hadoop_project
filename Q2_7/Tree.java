package cs.bigdata.Q27;


import java.io.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.FileSystem;

public abstract class Tree {
	public static void main(String[] args) throws IOException {
		
		String localSrc = "/home/labhdp/Q2_7/java/arbres.csv";
		//Open the file
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
		int n=0;
		
		try{
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			// read line by line
			String line = br.readLine();
			
			while (line !=null){
				// Process of the current line
				// go to the next line
				String[] arr=line.split(";");
				System.out.println(arr[5]+",  "+arr[6]);

				line = br.readLine();
				
			}
		}
		finally{
			//close the file
			in.close();
			fs.close();
		}
 
	//System.out.print("number of lines: "+n); 	
		
	}
}
