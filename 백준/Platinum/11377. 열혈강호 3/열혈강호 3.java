import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] work;
	static boolean[] used;
	static ArrayList<Integer>[] canDo;

	static boolean dfs(int x) {
		for (int w : canDo[x]) {
			if (used[w])
				continue;
			used[w] = true;
			if (work[w] == 0 || dfs(work[w])) {
				work[w] = x;
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

		canDo = new ArrayList[2 * n + 1];
		work = new int[m + 1];
		used = new boolean[m + 1];

		int c, x;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());
			canDo[i] = new ArrayList<>();
			canDo[i+n] = new ArrayList<>();
			
			while (c-- > 0) {
				x = Integer.parseInt(st.nextToken());
				canDo[i].add(x);
				canDo[i+n].add(x);
			}
		}
		int cnt = 0;
		int answer = 0;
		
		for(int i = 1;i<=2*n;i++) {
			Arrays.fill(used, false);
			if((i<=n || (i>n&&cnt<k)) && dfs(i)) {
				answer++;
				if(i>n) {
					cnt++;
				}
			}
		}
		
		System.out.println(answer);
	}
}