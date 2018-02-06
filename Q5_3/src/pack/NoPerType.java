package pack;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class NoPerType {
	   public static class NoMapper extends Mapper<Object, Text, Text, Text> {

	        protected void map(Object key, Text value, Mapper<Object, Text, Text, Text>.Context context)
	                throws IOException, InterruptedException {
	        	String line=value.toString();
	        	if(line.startsWith("(")){
	        	String[] treecontent=line.split(";");
	        	//write(type,1)
	            context.write(new Text(treecontent[2]), new Text("1"));
	        }
	    }
	   }
	    
	    public static class NoReducer extends Reducer<Text, Text, Text, Text> {

	        protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
	                throws IOException, InterruptedException {
	        	
	        	int sum=0;
	        	for(Text val:values){
         		sum++;
	        	}
	        	context.write(key,new Text(String.valueOf(sum)));
	        }
	    }
}