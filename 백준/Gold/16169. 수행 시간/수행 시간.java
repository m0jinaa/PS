import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Computer implements Comparable<Computer> {
		int ind, grade, speed;

		public Computer(int ind, int grade, int speed) {
			super();
			this.ind = ind;
			this.grade = grade;
			this.speed = speed;
		}

		@Override
		public int compareTo(Computer c) {
			return this.grade - c.grade;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];// 컴퓨터 별 이전 레벨까지 최대소요시간
		Computer[] computers = new Computer[n];

		int g, s;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			g = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			computers[i] = new Computer(i + 1, g, s);
		}

		Arrays.sort(computers);
		int t;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (computers[i].grade == computers[j].grade)
					continue;
				else if (computers[i].grade + 1 < computers[j].grade)
					break;
				t = dp[computers[i].ind] + (int) Math.pow(computers[i].ind - computers[j].ind, 2) + computers[i].speed;
				dp[computers[j].ind] = Math.max(dp[computers[j].ind], t);
			}
			if (computers[n - 1].grade == computers[i].grade)
				answer = Math.max(dp[computers[i].ind] + computers[i].speed, answer);
		}

		System.out.println(answer);
	}
}