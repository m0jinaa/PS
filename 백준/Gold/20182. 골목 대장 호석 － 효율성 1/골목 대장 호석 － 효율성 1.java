import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m,A,B,C;
	static ArrayList<int[]>[] graph;
	
	public static boolean dijkstra(int money) {
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]-n2[1]);
		q.add(new int[] {A,0});
		int[] now;
		int[] price = new int[n+1];
		Arrays.fill(price, Integer.MAX_VALUE);
		price[A] = 0;
		int x,p;
		while(!q.isEmpty()) {
			now = q.poll();
			x = now[0];
			p = now[1];
			if(price[x]<p)
				continue;
			if(x==B)
				return true;
			for(int[] next:graph[x]) {
				if(next[1]>money||price[next[0]]<=p+next[1]||p+next[1]>C)
					continue;
				price[next[0]] = p+next[1];
				q.add(new int[] {next[0],price[next[0]]});
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<int[]>();
		}
		int a,b,c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b,c});
			graph[b].add(new int[] {a,c});
		}
		
		int l = 1;
		int r = 20;
		int answer = -1;
		int mid;
		while(l<=r) {
			mid = (l+r)/2;
			if(dijkstra(mid)) {
				answer = mid;
				r = mid-1;
			}
			else {
				l = mid+1;
			}
		}		
		System.out.println(answer);
	}
}