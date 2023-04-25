import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[] parent;
	
	static class Noodle implements Comparable<Noodle>{
		int exp,cnt;

		public Noodle(int exp, int cnt) {
			super();
			this.exp = exp;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Noodle o) {
			return (this.cnt!=o.cnt)?(o.cnt-this.cnt):(o.exp-this.exp);
		}		
	}
	
	public static int find(int x) {
		if(parent[x]!=x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	public static boolean union(int a) {
		a = find(a);
		int b = find(a-1);
		
		if(a==b)
			return false;
		if(a<b) {
			parent[b] = a;
		}
		else {
			parent[a] = b;
		}
		return true;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		Noodle[] noodles = new Noodle[n];
		
		int exp, cnt;
		parent = new int[n+1];
		for(int i = 1;i<=n;i++) {
			parent[i] = i;
			st = new StringTokenizer(br.readLine()," ");
			exp = Integer.parseInt(st.nextToken());
			cnt = Integer.parseInt(st.nextToken());
			noodles[i-1] = new Noodle(exp,cnt);
		}
		
		Arrays.sort(noodles);
		
		long answer = 0;
		int x;
		for(Noodle noodle:noodles) {
			x = find(noodle.exp);
			if(x!=0) {
				answer+=noodle.cnt;
				union(noodle.exp);
			}
		}
		
		System.out.println(answer);
	}
}