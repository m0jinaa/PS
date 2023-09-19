import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] feed;
	static int max;
	static int n,k;
	
	static void dfs(int ind, int sum, int store) {
		if(ind == n) {
			max = Math.max(max, store);
			return;
		}
		
		if(sum==0) {
			dfs(ind+1, sum, store);
		}
		
		sum+=feed[ind];
		
		if(k<=sum) {
			store+=sum-k;
			sum = 0;
		}
		
		dfs(ind+1,sum,store);
	}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		feed = new int[n];
		for(int i = 0;i<n;i++) {
			feed[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		
		System.out.println(max);			
	}
}