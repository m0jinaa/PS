import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	static int n;
	
	public static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b)
			return;
		else if(a<b)
			root[b] = a;
		else
			root[a] = b;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		root = new int[n+1];
		for(int i = 0;i<=n;i++)
			root[i] = i;
		int a,b;
		
		for(int i = 0;i<n-2;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1;i<=n;i++) {
			if(root[i]==i)
				sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
