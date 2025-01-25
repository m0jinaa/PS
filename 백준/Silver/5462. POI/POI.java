import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static class Student implements Comparable<Student> {
		int id, score, cnt;

		public Student(int id, int score, int cnt) {
			super();
			this.id = id;
			this.score = score;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Student s) {
			if (s.score != this.score) {
				return s.score - this.score;
			} else if (this.cnt != s.cnt) {
				return s.cnt - this.cnt;
			} else {
				return this.id - s.id;
			}
		}

		public void addCnt() {
			this.cnt++;
		}

		public void addScore(int s) {
			this.score += s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		int[][] problems = new int[n][t];

		int[] score = new int[t];

		Student[] students = new Student[n];

		for (int i = 0; i < n; i++) {
			students[i] = new Student(i + 1, 0, 0);

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < t; j++) {
				problems[i][j] = Integer.parseInt(st.nextToken());

				if (problems[i][j] == 0) {
					score[j]++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < t; j++) {
				if (problems[i][j] == 0)
					continue;
				students[i].addCnt();
				students[i].addScore(score[j]);
			}
		}

		Arrays.sort(students);

		int rank = 0;
		int answer = 0;

		for (Student s : students) {
			rank++;
			if (s.id != p)
				continue;
			answer = s.score;
			break;
		}

		sb.append(answer).append(" ").append(rank);

		System.out.println(sb.toString());
	}
}