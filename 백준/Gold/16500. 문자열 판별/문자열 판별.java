import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static ArrayList<Integer>[] canGo;
	static int l;
	static int[] dp;

	static int possible(int x) {
		if (dp[x] != -1)
			return dp[x];
		if (x == l)
			return dp[x] = 1;

		int status = 0;
		int temp;
		for (int y : canGo[x]) {
			temp = possible(y);
			if (temp == 1) {
				status = 1;
				break;
			}
		}

		return dp[x] = status;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		int n = Integer.parseInt(br.readLine());

		l = s.length();
		dp = new int[l + 1];
		canGo = new ArrayList[l];

		Arrays.fill(dp, -1);

		for (int i = 0; i < l; i++) {
			canGo[i] = new ArrayList<>();
		}

		int ind, next;

		String a;

		for (int i = 0; i < n; i++) {
			ind = 0;
			a = br.readLine();
			while (ind < l) {
				next = s.indexOf(a, ind);
				if (next == -1)
					break;
				canGo[next].add(next + a.length());
				ind = next + a.length();
			}
		}

		System.out.println(possible(0));
	}
}