import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student> {
		int country, student_id, score;

		public Student(int country, int student_id, int score) {
			super();
			this.country = country;
			this.student_id = student_id;
			this.score = score;
		}

		@Override
		public int compareTo(Student s) {
			return s.score - this.score;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		ArrayList<Student> list = new ArrayList<>();
		int c, id, s;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());
			id = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			list.add(new Student(c, id, s));
		}

		Collections.sort(list);

		int[] cnt = new int[n + 1];
		int rank = 1;

		for (Student student : list) {
			if (rank == 4)
				break;

			if (cnt[student.country] < 2) {
				cnt[student.country]++;
				sb.append(student.country).append(" ").append(student.student_id).append("\n");
				rank++;
			}
		}

		System.out.print(sb.toString());
	}
}