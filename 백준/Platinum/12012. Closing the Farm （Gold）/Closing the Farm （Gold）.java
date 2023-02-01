import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y)
			return false;
		
		root[x] = y;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		root = new int[n+1];
		
		ArrayList<Integer>[] connected = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			root[i] = i;
			connected[i] = new ArrayList<Integer>();
		}
		
		boolean[] exist = new boolean[n+1];
		
		int a,b;
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			connected[a].add(b);
			connected[b].add(a);
		}
		
		int[] query = new int[n];
		String[] answer = new String[n];
		
		for(int i = 0;i<n;i++) {
			query[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		int now;
		for(int i = n-1;i>=0;i--) {
			cnt++;
			now = query[i];
			exist[now] = true;
			
			for(int c:connected[now]) {
				if(exist[c]&&union(c,now))
					cnt--;
			}
			
			if(cnt==1)
				answer[i] = "YES\n";
			else
				answer[i] = "NO\n";	
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(String ans:answer)
			sb.append(ans);
		
		System.out.println(sb.toString());
	}
}