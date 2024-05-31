import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student> {
		int x, m;

		public Student(int x, int m) {
			super();
			this.x = x;
			this.m = m;
		}

		@Override
		public int compareTo(Student s) {
			return this.x - s.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		LinkedList<Integer> A = new LinkedList<>();
		LinkedList<Integer> B = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());

		int o, a, b;

		LinkedList<Student> line = new LinkedList<>();
		Student student;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());

			switch (o) {
			case 1:
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				line.add(new Student(a, b));
				break;
			case 2:
				b = Integer.parseInt(st.nextToken());
				student = line.poll();

				if (student.m == b) {
					A.add(student.x);
				} else {
					B.add(student.x);
				}
				break;
			}
		}

		Collections.sort(A);
		Collections.sort(B);
		Collections.sort(line);

		if (A.size() == 0) {
			sb.append("None\n");
		} else {
			while (!A.isEmpty()) {
				sb.append(A.poll()).append(" ");
			}
			sb.append("\n");
		}
		if (B.size() == 0) {
			sb.append("None\n");
		} else {
			while (!B.isEmpty()) {
				sb.append(B.poll()).append(" ");
			}
			sb.append("\n");
		}
		if (line.size() == 0) {
			sb.append("None\n");
		} else {
			while (!line.isEmpty()) {
				sb.append(line.poll().x).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}