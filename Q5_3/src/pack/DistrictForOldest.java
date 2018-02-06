package pack;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;


public class DistrictForOldest {
	   public static class DFOMapper extends Mapper<Object, Text, Text, Text> {

	        protected void map(Object key, Text value, Mapper<Object, Text, Text, Text>.Context context)
	                throws IOException, InterruptedException {
	        	String line=value.toString();
	        	if(line.startsWith("(")){
	        	String[] treecontent=line.split(";");
	        	//write(year,district)
	            context.write(new Text(treecontent[5]), new Text(treecontent[1]));
	        }
	    }
	   }
	    
	    public static class DFOReducer extends Reducer<Text, Text, Text, Text> {

	        protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
	                throws IOException, InterruptedException {
	        	
	        	StringBuilder district=new StringBuilder("");
	        	for(Text val:values){
        		district.append(val.toString()+",");
	        	}
	        	//System.out.println(String.valueOf(key.toString()));
	        	context.write(key,new Text(String.valueOf(district.toString())));
	        }
	    }
}
