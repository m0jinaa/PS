import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] done;
	static int[] work;
	static ArrayList<Integer>[] canDo;
	
	static boolean dfs(int x) {
		for(int i: canDo[x]) {
			if(done[i])
				continue;
			done[i] = true;
			if(work[i]==0 || dfs(work[i])) {
				work[i] = x;
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

		canDo = new ArrayList[n + 1];

		work = new int[m + 1];
		done = new boolean[m + 1];

		for (int i = 1; i <= n; i++) {
			canDo[i] = new ArrayList<Integer>();
		}

		int c, x;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());

			while (c-- > 0) {
				x = Integer.parseInt(st.nextToken());
				canDo[i].add(x);
			}
		}

		int cnt;
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			cnt = 2;
			while (cnt-- > 0) {
				Arrays.fill(done, false);
				if (dfs(i)) {
					answer++;
				}
			}
		}
        
		System.out.println(answer);
	}
}