package driver;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import pack.PickHighest;
import pack.NoPerType;
import pack.DistrictForOldest;

public class Tree_Driver {

    private static String inputPath = "";
    //private static String outputPath = "";

    
    public static void main(String[] args) {
    	Tree_Driver client = new Tree_Driver();
        
        if (args.length == 1) {
            inputPath = args[0];
            //outputPath = args[1];
        }
        
        try {
            client.execute();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private void execute() throws Exception {

    	//runNoPerTypeJob(inputPath,"NumberPerType");
        runPHJob(inputPath, "PickHighest");
        //runDFOJob(inputPath,"DistrictYear");
    }
 
    private int runPHJob(String inputPath, String outputPath) throws Exception {
        Configuration configuration = new Configuration();
        remove_ifexist(configuration, outputPath);
        
        Job job = Job.getInstance(configuration);
        job.setJobName("Job_PH");
        job.setJarByClass(PickHighest.class);
        
        job.setMapperClass(PickHighest.PHMapper.class);
        job.setReducerClass(PickHighest.PHReducer.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));
        
        return job.waitForCompletion(true) ? 0 : 1;
    }
    private int runNoPerTypeJob(String inputPath, String outputPath) throws Exception {
        Configuration configuration = new Configuration();
        remove_ifexist(configuration, outputPath);
        
        Job job = Job.getInstance(configuration);
        job.setJobName("Job_No");
        job.setJarByClass(NoPerType.class);
        
        job.setMapperClass(NoPerType.NoMapper.class);
        job.setReducerClass(NoPerType.NoReducer.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));
        
        return job.waitForCompletion(true) ? 0 : 1;
    }
    private int runDFOJob(String inputPath, String outputPath) throws Exception {
        Configuration configuration = new Configuration();
        remove_ifexist(configuration, outputPath);
        
        Job job = Job.getInstance(configuration);
        job.setJobName("Job_DistrictForOldest");
        job.setJarByClass(DistrictForOldest.class);
        
        job.setMapperClass(DistrictForOldest.DFOMapper.class);
        job.setReducerClass(DistrictForOldest.DFOReducer.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));
        
        return job.waitForCompletion(true) ? 0 : 1;
    }
    private void remove_ifexist(Configuration configuration, String outputPath) throws IOException {
        FileSystem fileSystem = FileSystem.get(configuration);
        Path path = new Path(outputPath);
        if (fileSystem.exists(path)) {
            fileSystem.delete(path, true);
        }
    }

}
