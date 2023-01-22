import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	
	static int find(int x) {
		if(root[x] != x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	static void union(int x,int y) {
		x = find(x);
		y = find(y);
		
		if(x==y)
			return;
		else if(x<y)
			root[y] = x;
		else
			root[x] = y;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] enemy = new ArrayList[n+1];
		root = new int[n+1];
		
		for(int i = 1;i<=n;i++) {
			enemy[i] = new ArrayList<Integer>();
			root[i] = i;
		}
		String r;
		int p,q;
		
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			r = st.nextToken();
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			switch(r) {
			case "E":
				for(int x:enemy[q]) {
					union(x,p);
				}
				for(int x:enemy[p]) {
					union(x,q);
				}
				enemy[p].add(q);
				enemy[q].add(p);
				break;
			case "F":
				union(p,q);
				break;
			}
		}
		int cnt = 0;
		
		for(int i = 1;i<=n;i++) {
			if(find(i)==i)
				cnt++;
		}
		
		System.out.println(cnt);
	}
}