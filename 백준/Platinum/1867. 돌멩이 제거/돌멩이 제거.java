import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canPick;
	static boolean[] used;
	static int[] picker;

	static boolean dfs(int x) {
		for (int y : canPick[x]) {
			if (used[y])
				continue;
			used[y] = true;
			if (picker[y] == 0 || dfs(picker[y])) {
				picker[y] = x;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		used = new boolean[n + 1];
		picker = new int[n + 1];

		canPick = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			canPick[i] = new ArrayList<>();
		}
		int x,y;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			canPick[x].add(y);
		}
		
		int cnt = 0;
		
		for(int i = 1;i<=n;i++) {
			Arrays.fill(used, false);
			if(dfs(i)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}