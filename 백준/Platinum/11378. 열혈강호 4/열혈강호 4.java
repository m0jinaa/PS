import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] done;
	static boolean[] used;
	static ArrayList<Integer>[] canDo;

	static boolean dfs(int x) {
		for (int y : canDo[x]) {
			if (used[y])
				continue;
			used[y] = true;
			if (done[y] == 0 || dfs(done[y])) {
				done[y] = x;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		done = new int[m + 1];
		used = new boolean[m + 1];
		canDo = new ArrayList[n+1];
		for (int i = 1; i < n+1; i++) {
			canDo[i] = new ArrayList<>();
		}

		int x, c;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());
			while (c-- > 0) {
				x = Integer.parseInt(st.nextToken());
				canDo[i].add(x);
			}
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(used, false);
			if (dfs(i)) {
				cnt++;
			}
		}
		
		int t;
		while(true) {
			t = 0;
			for (int i = 1; i <= n && cnt<m && k>0; i++) {
				Arrays.fill(used, false);
				if (dfs(i)) {
					cnt++;
					k--;
					t++;
				}
			}
			if(t==0 || cnt>=m || k==0)
				break;
		}
		System.out.println(cnt);
	}
}