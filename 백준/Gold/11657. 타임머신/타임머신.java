import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static ArrayList<City>[] graph;
	static final long INF = Long.MAX_VALUE;
	static long[] dist;
	
	static class City{
		int x;
		long d;
		public City(int x, long d) {
			super();
			this.x = x;
			this.d = d;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		dist = new long[n+1];
		for(int i = 1;i<=n;i++) {
			graph[i] = new ArrayList<City>();
			dist[i] = INF;
		}
		
		int a,b;
		long c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			graph[a].add(new City(b,c));
		}
				
		dist[1] = 0;
		
		boolean flag = false;
		
		for(int i = 1;i<n;i++) {
			flag = false;
			for(int j = 1;j<=n;j++) {
				for(City city:graph[j]) {
					if(dist[j] == INF)
						break;
					
					if(dist[city.x]>dist[j]+city.d) {
						dist[city.x] = dist[j]+city.d;
						flag = true;
					}
				}
			}
			
			if(!flag)
				break;
		}
		boolean cycle=false;
		if(flag) {
			end: for(int i = 1;i<=n;i++) {
				for(City city:graph[i]) {
					if(dist[i] == INF)
						break;
					
					if(dist[city.x]>dist[i]+city.d) {
						cycle = true;
						break end;
					}
				}
			}	
		}
		
		if(cycle) {
			sb.append("-1");
		}
		else {
			for(int i = 2;i<=n;i++) {
				sb.append(dist[i]==INF?-1:dist[i]).append("\n");
			}
		}	
		System.out.println(sb.toString());
	}
}