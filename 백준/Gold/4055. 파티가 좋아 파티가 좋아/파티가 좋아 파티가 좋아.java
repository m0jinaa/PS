import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Party implements Comparable<Party> {
		int s, e;

		public Party(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Party p) {
			int v = this.e + p.s - (p.e + this.s);
			if (v == 0)
				return this.s - p.s;
			else
				return v;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n, s, e;
		Party[] parties;

		int answer;

		int day = 0;
		boolean[] attend = new boolean[48];

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			day++;

			parties = new Party[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());

				parties[i] = new Party(s * 2, e * 2);
			}

			Arrays.sort(parties);

			// 시작시간 = 8시, 30분단위로 세기위해 *2
			answer = 0;
			Arrays.fill(attend, false);

			for (Party p : parties) {

				for (int i = p.s; i < p.e; i++) {
					if (attend[i])
						continue;
					attend[i] = true;
					answer++;
					break;
				}
			}

			sb.append("On day ").append(day).append(" Emma can attend as many as ").append(answer)
					.append(" parties.\n");
		}

		System.out.println(sb.toString());

	}
}