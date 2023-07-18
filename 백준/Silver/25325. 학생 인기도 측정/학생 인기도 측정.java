import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student> {
		String name;
		int like;

		public Student(String name) {
			super();
			this.name = name;
			this.like = 0;
		}

		public void increase() {
			this.like++;
		}

		@Override
		public int compareTo(Student student) {
			if (this.like != student.like)
				return student.like - this.like;
			else
				return this.name.compareTo(student.name);
		}

		@Override
		public String toString() {
			return name + " " + like + "\n";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine(), " ");
		String name;

		Student[] students = new Student[n];

		for (int i = 0; i < n; i++) {
			name = st.nextToken();
			map.put(name, i);

			students[i] = new Student(name);
		}

		int ind;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				name = st.nextToken();
				ind = map.get(name);

				students[ind].increase();
			}
		}

		Arrays.sort(students);

		for (Student s : students) {
			sb.append(s.toString());
		}

		System.out.print(sb.toString());
	}
}