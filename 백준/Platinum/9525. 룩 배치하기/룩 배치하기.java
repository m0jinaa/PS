import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int N;
	static char[][] map;
	static int[][] vertical;
	static int[] put;
	static boolean[] used;
	static ArrayList<Integer>[] canPut;

	static boolean match(int x) {
		for (int y : canPut[x]) {
			if (used[y])
				continue;
			used[y] = true;
			if (put[y] == 0 || match(put[y])) {
				put[y] = x;
				return true;
			}
		}
		return false;
	}
	
	static int getVertical() {
		int ind = 1;
		for(int j = 0;j<N;j++) {
			for(int i = 0;i<N;i++) {
				if(map[i][j]=='X') {
					ind++;
				}
				else {
					vertical[i][j] = ind;
					if(i==N-1)
						ind++;
				}
				
			}
		}
		return ind-1;
	}
	static int getHorizontal() {
		int ind = 1;
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
				if(map[i][j]=='X') {
					ind++;
				}
				else {
					canPut[vertical[i][j]].add(ind);
					if(j==N-1)
						ind++;
				}
				
			}
		}
		return ind-1;	
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][];
		vertical = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int n = getVertical();
		
		canPut = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			canPut[i] = new ArrayList<>();
		}
		
		int m = getHorizontal();
		
		used = new boolean[m+1];
		put = new int[m+1];
		
		int cnt = 0;
		
		for(int i = 1;i<=n;i++) {
			Arrays.fill(used, false);
			if(match(i)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);		
	}
}