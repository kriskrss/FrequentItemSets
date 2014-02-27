import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Partitioner;

public class FrequentItemSetPartitioner implements
		Partitioner<Text, IntWritable> {

	@Override
	public void configure(JobConf conf) {
	}

	@Override
	public int getPartition(Text key, IntWritable value, int numReducers) {
		int length = key.toString().split(",").length;
		return length - 1;
	}

}
