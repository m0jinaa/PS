import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static class Item{
		int i;
		int j;
		public Item(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		long cost;
		public Item(int i, long cost) {
			super();
			this.i = i;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Queue<Item> q = new PriorityQueue<Item>((n1,n2)->n1.cost<n2.cost?-1:1);
		int n,m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		long[] price = new long[n+1];
		boolean[] v = new boolean[n+1];
		ArrayList<Item>[] graph = new ArrayList[n+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<Item>();
			price[i] = Long.parseLong(st.nextToken());
			q.add(new Item(i,price[i]));
		}
		int a,b,c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[b].add(new Item(c,a));
			graph[c].add(new Item(b,a));
		}
		Item now;
		while(!q.isEmpty()) {
			now = q.poll();
			if(v[now.i])
				continue;
			if(now.i==1)
				break;
			
			for(Item next:graph[now.i]) {
				if(v[next.i]&&price[next.j]>price[now.i]+price[next.i]) {
					price[next.j] = price[now.i]+price[next.i];
					q.add(new Item(next.j,price[next.j]));
				}
			}
			v[now.i] = true;
		}	
		System.out.println(price[1]);
	}
}