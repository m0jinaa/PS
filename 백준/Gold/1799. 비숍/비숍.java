import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] match;
	static boolean[] used;
	static ArrayList<Integer>[] canMatch;
	
	static boolean dfs(int x) {
		for(int y : canMatch[x]) {
			if(used[y])
				continue;
			
			used[y] = true;
			if(match[y]==0 || dfs(match[y])) {
				match[y] = x;
				
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = 2*n-1;
		
		
		used = new boolean[m+1];
		match = new int[m+1];
		
		canMatch = new ArrayList[m+1];
		
		for(int i = 1;i<=m;i++) {
			canMatch[i] = new ArrayList<>();
		}
		
		int x;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			for(int j = 0;j<n;j++) {
				x = Integer.parseInt(st.nextToken());
				if(x==1) {
					canMatch[i+j+1].add(n+j-i);
				}
			}
		}
		
		int cnt = 0;
		
		for(int i = 1; i<=m;i++) {
			Arrays.fill(used, false);
			if(dfs(i)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}