import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static char[][] map;
	static int[][] numbered;
	static ArrayList<Integer>[] canCover;
	static int[] covered;
	static boolean[] used;

	static boolean cover(int x) {
		for (int y : canCover[x]) {
			if (used[y])
				continue;
			used[y] = true;
			if (covered[y] == 0 || cover(covered[y])) {
				covered[y] = x;
				return true;
			}
		}
		return false;
	}

	static int horizontal() {
		int ind = 1;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(map[i][j] == '*') {
					numbered[i][j] = ind;
				}
				else if(map[i][j] == '.' && (j>0) && map[i][j-1]=='*') {
					ind++;
				}
			}
			if(map[i][m-1]=='*')
				ind++;
		}
		return ind-1;
	}
	
	static int vertical() {
		int ind = 1;
		for(int j = 0;j<m;j++) {
			for(int i = 0;i<n;i++) {
				if(map[i][j] == '*') {
					canCover[numbered[i][j]].add(ind);
				}
				else if(map[i][j] == '.' && (i>0) && map[i-1][j]=='*') {
					ind++;
				}
			}
			if(map[n-1][j]=='*')
				ind++;
		}
		return ind-1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][];
		numbered = new int[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int p = horizontal();

		canCover = new ArrayList[p + 1];
		
		for (int i = 1; i <= p; i++) {
			canCover[i] = new ArrayList<>();
		}
		int q = vertical();
		
		used = new boolean[q + 1];
		covered = new int[q + 1];

		int cnt = 0;

		for (int i = 1; i <= p; i++) {
			Arrays.fill(used, false);
			if (cover(i)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
