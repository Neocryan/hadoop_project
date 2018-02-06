package cs.bigdata.Q28;

import java.io.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.FileSystem;

public class DisplayContent {
	
public static void main(String[] args) throws IOException {

		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);

		InputStream in = fs.open(new Path("\\isd-history.txt"));
		
		int numeroline=0;
		
		try{
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			// read line by line
			String line = br.readLine();
			
			while (line !=null){
				if(numeroline>=22){
				// Process of the current line
				System.out.print("USAF Code: "+line.substring(0,6));
				System.out.print(",  Station's name: "+line.substring(13,42));
				System.out.print(",  FIPS Country ID: "+line.substring(43,45));
				System.out.println(",  Altitude: "+line.substring(74,81));

				}
				numeroline++;
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
