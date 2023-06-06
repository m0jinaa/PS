import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int ALLSOLVED;
	static int answer;
	static int[] student;

	static void select(int ind, int sol, int cnt) {
		if (sol == ALLSOLVED) {
			answer = Math.min(answer, cnt);
		} else if (ind == m) {
			return;
		} else {
			if ((student[ind] | sol) != sol) {
				select(ind + 1, sol | student[ind], cnt + 1);
			}
			select(ind + 1, sol, cnt);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		answer = m + 1;
		ALLSOLVED = (1 << n) - 1;

		student = new int[m];
		int o, p;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			o = Integer.parseInt(st.nextToken());
			while (o-- > 0) {
				p = Integer.parseInt(st.nextToken()) - 1;
				student[i] += (1 << p);
			}
		}

		select(0, 0, 0);

		System.out.println(answer == m + 1 ? -1 : answer);
	}
}