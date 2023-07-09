import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student> {
		String name;
		double height;
		int ind;

		public Student(String name, double height, int ind) {
			super();
			this.name = name;
			this.height = height;
			this.ind = ind;
		}

		@Override
		public int compareTo(Student student) {
			if (this.height < student.height) {
				return 1;
			} else if (this.height > student.height) {
				return -1;
			} else {
				return this.ind - student.ind;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n;

		double h;
		String name;

		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			Student[] students = new Student[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				name = st.nextToken();
				h = Double.parseDouble(st.nextToken());

				students[i] = new Student(name, h, i);
			}

			Arrays.sort(students);

			h = students[0].height;

			for (Student student : students) {
				if (student.height == h) {
					sb.append(student.name).append(" ");
				} else {
					break;
				}
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}