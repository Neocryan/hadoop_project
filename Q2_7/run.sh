hadoop jar ../hadoop-streaming.jar -input /tree/arbres.csv -output /tree/output -mapper "python2 mapper.py" -reducer "python2 reducer.py";
hdfs dfs -get /tree/output;

