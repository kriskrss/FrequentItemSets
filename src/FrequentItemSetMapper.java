import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class FrequentItemSetMapper implements
		Mapper<LongWritable, Text, Text, IntWritable> {
	private IntWritable one = new IntWritable(1);

	@Override
	public void configure(JobConf arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void map(LongWritable key, Text basket,
			OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		String basketString = basket.toString();
		// Split basket into items
		String[] items = basketString.split("\\s+");
		// Loop to generate 2 & 3 item sets
		for (int i = 0; i < items.length; i++) {
			output.collect(new Text(items[i]), one);
			for (int j = i + 1; j < items.length; j++) {
				output.collect(new Text("(" + items[i] + "," + items[j] + ")"),
						one);
				for (int k = j + 1; k < items.length; k++) {
					output.collect(new Text("(" + items[i] + "," + items[j]
							+ "," + items[k] + ")"), one);
				}
			}
		}
	}
}
