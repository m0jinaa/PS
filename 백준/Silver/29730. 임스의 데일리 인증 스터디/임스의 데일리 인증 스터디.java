import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Record implements Comparable<Record> {
		String note;
		int number;
		int length;

		public Record(String note, int number, int length) {
			super();
			this.note = note;
			this.number = number;
			this.length = length;
		}

		@Override
		public int compareTo(Record r) {
			if (r.number == 0 && this.number == 0) {
				if (this.length != r.length) {
					return this.length - r.length;
				} else {
					return this.note.compareTo(r.note);
				}
			} else if (r.number != 0 && this.number != 0) {
				return this.number - r.number;
			} else if (r.number == 0) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String solvedac = "boj.kr/";

		int n = Integer.parseInt(br.readLine());

		Record[] records = new Record[n];

		String note;
		for (int i = 0; i < n; i++) {
			note = br.readLine();

			if (note.startsWith(solvedac)) {
				records[i] = new Record(note, Integer.parseInt(note.substring(7)), 0);
			} else {
				records[i] = new Record(note, 0, note.length());
			}
		}

		Arrays.sort(records);

		for (Record r : records) {
			sb.append(r.note).append("\n");
		}

		System.out.println(sb.toString());
	}
}