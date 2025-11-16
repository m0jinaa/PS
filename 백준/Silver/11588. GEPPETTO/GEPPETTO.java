import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] hate;

	// h : 현재까지 넣은 재료들과 맞지 않는 재료들
	static int makePizza(int ind, int h) {
		int cnt = 1;

		for (int i = ind + 1; i <= n; i++) {
			if ((h & (1 << i)) != 0)
				continue;

			cnt += makePizza(i, h | hate[i]);
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		hate = new int[n + 1];

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			hate[a] |= (1 << b);
			hate[b] |= (1 << a);
		}

		int answer = makePizza(0, 0);

		System.out.println(answer);
	}
}