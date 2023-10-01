import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static Disease[] diseases;
	static int m;

	static class Disease {
		int r, b, d;

		public Disease(int r, int b, int d) {
			super();
			this.r = r;
			this.b = b;
			this.d = d;
		}
	}

	static class Student implements Comparable<Student> {
		int id, d;

		public Student(int id, int d) {
			super();
			this.id = id;
			this.d = d;
		}

		@Override
		public int compareTo(Student s) {
			if (this.d != s.d)
				return this.d - s.d;
			else
				return this.id - s.id;
		}

		@Override
		public String toString() {
			return this.id + " " + this.d + "\n";
		}

	}

	public static void fill() {
		dp[0][0] = 0;

		for (Disease disease : diseases) {
			for (int i = 50; i >= disease.r; i--) {
				for (int j = 50; j >= disease.b; j--) {
					if (dp[i - disease.r][j - disease.b] == -1)
						continue;
					dp[i][j] = Math.max(dp[i][j], dp[i - disease.r][j - disease.b] + disease.d);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		diseases = new Disease[m];
		Student[] students = new Student[n];

		int r, b, d;
        
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			diseases[i] = new Disease(r, b, d);
		}

		dp = new int[51][51];

		for (int i = 0; i < 51; i++) {
			Arrays.fill(dp[i], -1);
		}

		fill();

		int x, y;
        
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			d = dp[x][y] == -1 ? 0 : dp[x][y];

			students[i] = new Student(i + 1, d);
		}

		Arrays.sort(students);

		for (Student s : students) {
			sb.append(s.toString());
		}
        
		System.out.print(sb.toString());
	}
}