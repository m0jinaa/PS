import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student> {
		int ind;
		int stat;

		public Student(int ind, int stat) {
			super();
			this.ind = ind;
			this.stat = stat;
		}

		@Override
		public int compareTo(Student s) {
			return s.stat - this.stat;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Student[] students = new Student[n];

		int sum = 0;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 3; i++) {
			sum += Integer.parseInt(st.nextToken());
		}

		int stat;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			stat = 0;

			for (int j = 0; j < 3; j++) {
				stat += Integer.parseInt(st.nextToken());
			}

			students[i] = new Student(i + 1, stat);
		}

		Arrays.sort(students);

		m--;

		sb.append(0).append(" ");

		for (Student s : students) {
			if (s.stat > sum)
				continue;
			else if (m == 0)
				break;
			else {
				sb.append(s.ind).append(" ");
				m--;
			}
		}

		System.out.println(sb.toString());
	}
}