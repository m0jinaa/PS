import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] pair;
	static boolean[] used;
	static ArrayList<Integer>[] match;
	
	static boolean dfs(int x) {
		for(int target : match[x]) {
			if(used[target])
				continue;
			used[target] = true;
			if(pair[target]==0 || dfs(pair[target])) {
				pair[target] = x;
				return true;
			}
		}
		return false;
	}
	
	public static int gcd(int a, int b) {
		if(a<b) {
			int t = a;
			a= b;
			b = t;
		}
		int t;
		while(b!=0) {
			t = a%b;
			a = b;
			b = t;
		}
		
		return a;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;

		while(true) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n==0 && m==0)
				break;
			
			pair = new int[m+1];
			used = new boolean[m+1];
			match = new ArrayList[n+1];
			
			int[] cardA = new int[n+1];
			int[] cardB = new int[m+1];
			
			
			for(int i = 1;i<=n;i++) {
				if(i%10==1) {
					st = new StringTokenizer(br.readLine()," ");
				}
				match[i] = new ArrayList<>();
				cardA[i] = Integer.parseInt(st.nextToken());
			}
			
			int a,b;
			
			for(int i = 1;i<=m;i++) {
				if(i%10==1) {
					st = new StringTokenizer(br.readLine()," ");
				}
				cardB[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 1;i<=n;i++) {
				for(int j = 1;j<=m;j++) {
					if(gcd(cardA[i],cardB[j])>1) {
						match[i].add(j);
					}
				}
				
			}
			
			int cnt = 0;
			
			for(int i = 1;i<=n;i++) {
				Arrays.fill(used, false);
				
				if(dfs(i)) {
					cnt++;
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb.toString());		
	}
}