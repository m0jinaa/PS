import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	static int[] fresh;
	
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y)
			return;
		else if(x<y) {
			root[y] = x;
			fresh[x]+=fresh[y];
		}
		else {
			root[x] = y;
			fresh[y]+=fresh[x];
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		root = new int[n+1];
		fresh = new int[n+1];
		
		for(int i = 1; i<=n;i++) {
			root[i] = i;
			fresh[i] = Integer.parseInt(st.nextToken());
			if(fresh[i]==0)
				fresh[i] = -1;
		}
		int u,v;
		
		for(int i = 0 ;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			union(u,v);
		}
		
		StringBuilder sb = new StringBuilder();
		
		int k;
		
		for(int i = 0;i<q;i++) {
			k = Integer.parseInt(br.readLine());
			if(fresh[find(k)]>0)
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		
		System.out.println(sb.toString());
	}
}