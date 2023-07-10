import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Record implements Comparable<Record> {
		int cnt;
		int penalty;

		public Record(int cnt, int penalty) {
			super();
			this.cnt = cnt;
			this.penalty = penalty;
		}

		@Override
		public int compareTo(Record r) {
			if (this.cnt != r.cnt) {
				return r.cnt - this.cnt;
			} else {
				return this.penalty - r.penalty;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Record[] records = new Record[n];
		int c, p;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			c = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			records[i] = new Record(c, p);
		}

		Arrays.sort(records);

		c = records[4].cnt;

		int answer = 0;

		for (int i = 5; i < n; i++) {
			if (records[i].cnt == c) {
				answer++;
			} else {
				break;
			}
		}

		System.out.println(answer);
	}
}