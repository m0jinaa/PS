import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] pick;
	static boolean[] used;
	static ArrayList<Integer>[] want;

	static boolean dfs(int x) {
		for (int y : want[x]) {
			if (used[y])
				continue;
			used[y] = true;
			if (pick[y] == 0 || dfs(pick[y])) {
				pick[y] = x;
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
		int k1 = Integer.parseInt(st.nextToken());
		int k2 = Integer.parseInt(st.nextToken());

		want = new ArrayList[n + 1];
		pick = new int[m+1];
		used = new boolean[m+1];
		
		for (int i = 1; i <= n; i++) {
			want[i] = new ArrayList<>();
		}

		int i, j;
		while (k1-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());

			want[i].add(j);
		}

		int cnt1 = 0, cnt2 = 0;

		for(int p = 1;p<=n;p++) {
			Arrays.fill(used, false);
			if(dfs(p)) {
				cnt1++;
			}
		}
		
		for(int t = 1;t<=n;t++) {
			want[t].clear();
		}
		Arrays.fill(pick, 0);
		
		while(k2-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());

			want[i].add(j);			
		}
		
		for(int p = 1;p<=n;p++) {
			Arrays.fill(used, false);
			if(dfs(p)){
				cnt2++;
			}
		}
		
		if(cnt1<cnt2) {
			System.out.println("네 다음 힐딱이");
		}
		else {
			System.out.println("그만 알아보자");
		}		
	}
}