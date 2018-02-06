package pack;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class PickHighest {
	   public static class PHMapper extends Mapper<Object, Text, Text, Text> {

	        protected void map(Object key, Text value, Mapper<Object, Text, Text, Text>.Context context)
	                throws IOException, InterruptedException {
	        	String line=value.toString();
	        	if(line.startsWith("(")){
	        	String[] treecontent=line.split(";");
	        	////writewrite(type,height)
	            context.write(new Text(treecontent[2]), new Text(treecontent[6]));
	        }
	    }
	   }
	    
	    public static class PHReducer extends Reducer<Text, Text, Text, Text> {

	        protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
	                throws IOException, InterruptedException {
	        	
	        	double max=0;
	        	for(Text val:values){
	        		String valstring=val.toString();
	        		System.out.println(valstring);
	        		if (!valstring.equals("") && Double.parseDouble(valstring)>max)
	        		{	        			
	        			max=Double.parseDouble(val.toString());
	        			System.out.println(val.toString());
	        		}          		
	        	}
	        	//System.out.println(String.valueOf(key.toString()));
	        	context.write(key,new Text(String.valueOf(max)));
	        }
	    }
}