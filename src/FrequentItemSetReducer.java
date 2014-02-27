import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class FrequentItemSetReducer implements
		Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	public void configure(JobConf arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void reduce(Text itemset, Iterator<IntWritable> values,
			OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		int count = 0;
		//count number of occurrences of each item set
		while (values.hasNext()) {
			count += values.next().get();
		}
		output.collect(itemset, new IntWritable(count));
	}
}
