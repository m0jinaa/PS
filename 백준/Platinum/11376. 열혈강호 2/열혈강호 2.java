import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] done;
	static int[] work;
	static ArrayList<Integer>[] canDo;
	static boolean[] v;
	static boolean dfs(int x) {
		v[x] = true;
		for(int i: canDo[x]) {
			if(done[i])
				continue;
			done[i] = true;
			if(work[i]==0 || (!v[work[i]] && dfs(work[i]))) {
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

		canDo = new ArrayList[2*n+1];
		v = new boolean[2*n+1];
		work = new int[m + 1];
		done = new boolean[m + 1];
		
		for (int i = 1; i <= n; i++) {
			canDo[i*2-1] = new ArrayList<Integer>();
			canDo[i*2] = new ArrayList<Integer>();
			
		}

		int c, x;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			c = Integer.parseInt(st.nextToken());

			while (c-- > 0) {
				x = Integer.parseInt(st.nextToken());
				canDo[2*i-1].add(x);
				canDo[2*i].add(x);
			}
		}

		int answer = 0;
		for (int i = 1; i <= 2*n; i++) {
			Arrays.fill(done, false);
			if (dfs(i)) {
				Arrays.fill(v, false);
				answer++;
			}
		}
		System.out.println(answer);

	}
}