import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b)
			root[b] = a;
		else
			root[a] = b;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		root = new int[n+1];
		for(int i = 1;i<=n;i++)
			root[i] = i;
		int answer = 0;
		for(int i = 1;i<=m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int d1 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			
			if(find(d1)!=find(d2))
				union(d1,d2);
			else {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
