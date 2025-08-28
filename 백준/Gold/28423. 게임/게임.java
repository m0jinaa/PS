import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 100_000;
	// G[x]값 저장
	static int[] g;
	// 방문여부 체크
	static boolean[] v;

	public static int f(int x) {
		// g[x]값이 있다면 리턴
		if (g[x] != 2) {
			return g[x];
		} else if (v[x]) // g[x]값은 없는데 방문은 함 -> 순환되고있음
			return g[x] = 0;

		v[x] = true;

		int ret = 0;

		int mul = 1;
		int sum = 0;
		int t;
		int nx = x;

		while (nx > 0) {
			t = nx % 10;
			mul *= t;
			sum += t;
			nx /= 10;
		}

		int next;

		if (mul == 0) {
			next = sum * 10;
		} else {
			next = sum * (int) Math.pow(10, (int) Math.log10(mul) + 1) + mul;
		}

		// 다음 수가 100000을 넘는다면 -1
		if (next > MAX) {
			ret = -1;
		} else if (next == x) {// 다음수 = 현재수 면 1
			ret = 1;
		} else {
			ret = f(next);
		}

		return g[x] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		g = new int[MAX + 1];
		Arrays.fill(g, 2);

		v = new boolean[MAX + 1];

		st = new StringTokenizer(br.readLine(), " ");

		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int answer = 0;

		for (int i = l; i <= r; i++) {
			answer += f(i);
		}

		System.out.println(answer);
	}
}