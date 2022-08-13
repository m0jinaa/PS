import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[] root;
	static int find(int x) {
		if(root[x]<0)
			return x;
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if( a==b)
			return true;
		else if(a<b)
			root[b] = a;
		else
			root[a] = b;
		return false;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		root = new int[n+1];
		Arrays.fill(root, -1);
		int answer = 0;
		for(int i = 1;i<=m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int d1 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			
			if(union(d1,d2)){
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
