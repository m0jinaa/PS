import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 1_000_000;
	static final int START = 100;
	static boolean[] isBroken;
	static int[] v;

	// 번호로 눌러서 갈 수 있는지 체크해서 갈 수 있다면 몇번 클릭해야하는지 리턴
	// 못가면 -1 리턴
	static int canPush(int x) {
		if (x == 0) {
			return isBroken[x] ? -1 : 1;
		}

		int c = 0;

		while (x != 0) {
			if (isBroken[x % 10])
				return -1;
			x /= 10;
			c++;
		}

		return c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		isBroken = new boolean[10];

		int n = Integer.parseInt(br.readLine());

		int m = Integer.parseInt(br.readLine());

		int b;

		if (m > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			while (m-- > 0) {
				b = Integer.parseInt(st.nextToken());
				isBroken[b] = true;
			}
		}

		int answer = Math.abs(n - START);

		int p;

		for (int i = 0; i < MAX; i++) {
			p = canPush(i);

			if (p == -1)
				continue;

			p += Math.abs(i - n);

			answer = Math.min(answer, p);
		}

		System.out.println(answer);
	}
}