import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] boss;
	static boolean[] inTable;
	static int[] bossInTable;

	static int checkBoss(int x) {
		if (x == 0) {
			return 0;
		} else if (bossInTable[x] != -1) {
			return bossInTable[x];
		} else if (inTable[x]) {
			return 1;
		} else {
			return bossInTable[x] = checkBoss(boss[x]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		inTable = new boolean[n + 1];
		boss = new int[n + 1];
		bossInTable = new int[n + 1];

		// 상사 체크
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			boss[i] = Integer.parseInt(st.nextToken());
			bossInTable[i] = -1;
		}

		// 테이블에 있는 사람 체크
		st = new StringTokenizer(br.readLine(), " ");

		int e;
		int[] table = new int[m];
		for (int i = 0; i < m; i++) {
			e = Integer.parseInt(st.nextToken());

			inTable[e] = true;
			table[i] = e;
		}

		int answer = 0;

		for (int t : table) {
			if (checkBoss(boss[t]) == 0) {
				bossInTable[t] = 1;
				answer++;
			}

		}

		System.out.println(answer);
	}
}