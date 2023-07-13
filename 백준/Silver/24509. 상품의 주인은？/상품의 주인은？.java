import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student> {
		int id, score;

		public Student(int id, int score) {
			super();
			this.id = id;
			this.score = score;
		}

		@Override
		public int compareTo(Student s) {
			if (this.score != s.score) {
				return s.score - this.score;
			} else {
				return this.id - s.id;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Student[][] score = new Student[4][n];

		int x, s;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 4; j++) {
				s = Integer.parseInt(st.nextToken());
				score[j][i] = new Student(x, s);
			}

		}

		for (int i = 0; i < 4; i++) {
			Arrays.sort(score[i]);
		}

		boolean[] received = new boolean[n + 1];

		for (int i = 0; i < 4; i++) {
			for (Student student : score[i]) {
				if (received[student.id])
					continue;
				received[student.id] = true;
				sb.append(student.id).append(" ");
				break;
			}
		}

		System.out.println(sb.toString());
	}
}