import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] time;
	static int n,m,k;
	static ArrayList<int[]>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			time = new int[n+1][m+1];
			graph = new ArrayList[n+1];
			for(int i = 0;i<=n;i++) {
				graph[i] = new ArrayList<int[]>();
				Arrays.fill(time[i], Integer.MAX_VALUE);
			}
			int a,b,c,d;
			for(int i = 0;i<k;i++) {
				st = new StringTokenizer(br.readLine()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				graph[a].add(new int[] {b,c,d});
			}
			int answer = -1;
			time[1][0] = 0;
			Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[2]-n2[2]);
			q.offer(new int[] {1,0,0});
			int[] now;
			int nb,nc,nd;
			while(!q.isEmpty()) {
				now = q.poll();
				//System.out.println(Arrays.toString(now));
				b = now[0];
				c = now[1];
				d = now[2];
				if(b==n) {
					answer = d;
					break;
				}
				if(time[b][c]<d)
					continue;
				for(int[] next:graph[b]) {
					nb = next[0];
					nc = c+next[1];
					nd = d+next[2];
					if(nc<=m&&time[nb][nc]>nd) {
						time[nb][nc] = nd;
						q.offer(new int[] {nb,nc,nd});
					}
				}
			}
			sb.append(answer==-1?"Poor KCM":answer).append("\n");
		}
		System.out.println(sb);
	}
}