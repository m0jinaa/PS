import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static boolean[] used;
	static int[] matched;;
	static int[][] dist;

	static boolean match(int x) {
		for (int y = 1; y <= n; y++) {
			if (dist[x][y] > k || used[y])
				continue;
			used[y] = true;
			if (matched[y] == 0 || match(matched[y])) {
				matched[y] = x;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		dist = new int[n + 1][n + 1];
		used = new boolean[n + 1];
		matched = new int[n + 1];

		int[][] student = new int[n + 1][2];
		int[][] tutor = new int[n + 1][2];

		int x, y;
		// 학생 위치 저장
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			student[i][0] = x;
			student[i][1] = y;
		}

		// 튜터 위치 저장
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			tutor[i][0] = x;
			tutor[i][1] = y;
		}

		// 학생-튜터 거리 계산
		int d;

		int s = 100_000_000;
		int e = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				d = Math.abs(student[i][0] - tutor[j][0]) + Math.abs(student[i][1] - tutor[j][1]);
				dist[i][j] = d;
				s = Math.min(s, d);
				e = Math.max(e, d);
			}
		}

		// binarySearch
		int answer = e + 1;
		int cnt;
		while (s <= e) {
			k = (s + e) / 2;
			cnt = 0;
			Arrays.fill(matched, 0);
			for(int i = 1;i<=n;i++) {
				Arrays.fill(used, false);
				if(match(i))
					cnt++;
			}
			
			if(cnt==n) {
				answer = Math.min(answer, k);
				e = k-1;
			}
			else {
				s = k+1;
			}
		}
		
		System.out.println(answer);
	}

}
