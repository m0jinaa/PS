import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> left, right;
	static int[] pair;
	static boolean[] used;
	static boolean[] prime;
	static int n, lsize, rsize;

	static void init() {
		// 리스트의 수의 최대값이 1000이므로 소수쌍의 최대값은 2000
		prime = new boolean[2001];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		// 에라토스테네스의 체(소수 구하기)
		for (int i = 2; i < 2001; i++) {
			if (prime[i]) {
				for (int j = 2 * i; j < 2001; j += i) {
					prime[j] = false;
				}
			}
		}
	}

	static boolean dfs(int ind) {
		for (int i = 0; i < lsize; i++) {
			if (pair[i]==-1)// 맨 처음 숫자랑 짝?
				continue;
			
			if (used[i]) // 이미 사용된 수
				continue;
			
			if (!prime[right.get(ind) + left.get(i)])// 둘 더한게 소수가 아님
				continue;
			
			used[i] = true;
			
			if (pair[i] == -2 || dfs(pair[i])) {
				pair[i] = ind;
				return true;
			}

		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		init();

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		left = new ArrayList<>();
		right = new ArrayList<>();

		used = new boolean[n + 1];

		int first = Integer.parseInt(st.nextToken());
		int x;
		for (int i = 1; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			if (first % 2 == 0) {
				if (x % 2 == 0) {
					right.add(x);
				} else {
					left.add(x);
				}
			} else {
				if (x % 2 == 0) {
					left.add(x);
				} else {
					right.add(x);
				}
			}
		}

		boolean possible;

		ArrayList<Integer> answer = new ArrayList<Integer>();

		lsize = left.size();
		rsize = right.size();

		pair = new int[lsize];

		if (lsize == rsize + 1) {
			for (int i = 0; i < lsize; i++) {
				if (!prime[first + left.get(i)])
					continue;

				Arrays.fill(pair, -2);

				pair[i] = -1;

				possible = true;

				for (int j = 0; j < rsize; j++) {
					Arrays.fill(used, false);
					used[i] = true;
					if (!dfs(j)) {
						possible = false;
						break;
					}
				}

				pair[i] = 0;

				if (possible) {
					answer.add(left.get(i));
				}
			}
		}

		Collections.sort(answer);

		if (answer.isEmpty()) {
			sb.append("-1");
		} else {
			for (int ans : answer) {
				sb.append(ans).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}