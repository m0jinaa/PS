import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Pair implements Comparable<Pair> {
		String mentor, mentee;

		public Pair(String mentor, String mentee) {
			super();
			this.mentor = mentor;
			this.mentee = mentee;
		}

		@Override
		public int compareTo(Pair p) {
			if (!this.mentor.equals(p.mentor)) {
				return this.mentor.compareTo(p.mentor);
			} else {
				return p.mentee.compareTo(this.mentee);
			}
		}

		@Override
		public String toString() {
			return mentor + " " + mentee + "\n";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Pair[] pairs = new Pair[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			pairs[i] = new Pair(st.nextToken(), st.nextToken());
		}

		Arrays.sort(pairs);

		for (Pair p : pairs) {
			sb.append(p.toString());
		}

		System.out.print(sb.toString());
	}
}