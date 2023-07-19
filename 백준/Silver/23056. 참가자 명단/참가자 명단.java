import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
	static class Classroom implements Comparable<Classroom> {

		int n;
		int ind;
		int limit;
		String[] students;

		public Classroom(int n, int limit) {
			super();
			this.n = n;
			this.limit = limit;
			this.ind = 0;
			this.students = new String[limit];
		}

		public void add(String name) {
			if (ind == limit)
				return;
			students[ind++] = name;
		}

		@Override
		public int compareTo(Classroom c) {
			if (c.n % 2 != this.n % 2) {
				if (this.n % 2 == 0)
					return 1;
				else
					return -1;
			} else {
				return this.n - c.n;
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			Arrays.sort(this.students, 0, ind, new Comparator<String>() {

				@Override
				public int compare(String s1, String s2) {
					if (s1.length() != s2.length()) {
						return s1.length() - s2.length();
					} else {
						return s1.compareTo(s2);
					}
				}

			});

			for (int i = 0; i < ind; i++) {
				sb.append(this.n).append(" ").append(students[i]).append("\n");
			}

			return sb.toString();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Classroom[] classrooms = new Classroom[n];

		for (int i = 0; i < n; i++) {
			classrooms[i] = new Classroom(i + 1, m);
		}

		int c;
		String name;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			c = Integer.parseInt(st.nextToken());
			name = st.nextToken();

			if (c == 0 && "0".equals(name)) {
				break;
			}

			classrooms[c - 1].add(name);
		}

		Arrays.sort(classrooms);

		for (Classroom classroom : classrooms) {
			sb.append(classroom.toString());
		}

		System.out.print(sb.toString());
	}
}