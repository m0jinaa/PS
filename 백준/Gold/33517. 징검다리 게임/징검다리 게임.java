import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] map = new int[n];

		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		int k = Integer.parseInt(br.readLine());

		boolean[] firstD = new boolean[k];
		int[] countA = new int[k];

		char[] S = br.readLine().toCharArray();

		int ind = 0;

		firstD[0] = (S[0] == 'D');
		boolean haveJ = false;

		for (int i = 0; i < k; i++) {
			if (S[i] == 'J') {
				ind++;
				haveJ = true;
				if (i + 1 < k && S[i + 1] == 'D') {
					firstD[ind] = true;
				}
			} else if (S[i] == 'A') {
				countA[ind]++;
			}
		}

		boolean d = firstD[0];
		int a = countA[0];

		boolean canWin = haveJ;

		int start;

		if (S[k - 1] != 'J') {
			firstD[0] = firstD[ind];
			countA[0] += countA[ind];
			start = 2;
			if ((map[1] == -1 && !d) || (map[1] > a))
				canWin = false;
		} else {
			start = 1;
		}

		for (int i = start; i < n && canWin; i++) {
			// 지뢰
			if (map[i] == -1) {
				if (!firstD[(i - 1) % ind]) {
					canWin = false;
				}
			} else if (map[i] > countA[(i - 1) % ind]) {
				canWin = false;
			}
		}

		System.out.println(canWin ? "YES" : "NO");
	}
}