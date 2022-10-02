import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static int[] root;
	static LinkedList<int[]> lines;
	static LinkedList<int[]>[] graph;
	static int[][] maxValue;
	static Queue<int[]> q= new LinkedList<int[]>();
	static int find(int x) {
		if(root[x] !=x) {
			root[x] = find(root[x]);
		}
		return root[x];
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b)
			return false;
		else if(a<b) {
			root[b] = a;
			return true;
		}
		else {
			root[a] = b;
			return true;
		}
	}
	
	public static void getMaxVal() {
		int[] now;
		int x,c,nx,nc;
		for(int start = 1;start<=N;start++) {
			q.clear();
			maxValue[start][start]=0;
			q.offer(new int[] {start,0});// 시작위치, 최댓값
			while(!q.isEmpty()) {
				now = q.poll();
				x = now[0];
				c = now[1];
				for(int[] next:graph[x]) {
					nx = next[0];
					nc = Math.max(c, next[1]);
					if(maxValue[start][nx]==-1) {
						maxValue[start][nx] = nc;
						q.offer(new int[] {nx,nc});	
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		root = new int[N+1];
		graph = new LinkedList[N+1];
		lines = new LinkedList<int[]>();
		for(int i = 1;i<=N;i++) {
			root[i] = i;
			graph[i] = new LinkedList<int[]>();
		}
		int a,b,c;
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			lines.add(new int[] {a,b,c});
		}
		lines.sort((l1,l2)->l1[2]-l2[2]);
		
		int cost = 0;
		int cnt = 0;
		for(int[] line:lines) {
			a = line[0];
			b = line[1];
			c = line[2];
			if(union(a,b)) {
				cost+=c;
				graph[a].add(new int[]{b,c});
				graph[b].add(new int[] {a,c});
				cnt++;
				if(cnt==N-1)//모든 노드 연결
					break;
			}
		}
//		System.out.println(cost);
//		System.out.println(Arrays.toString(root));
		maxValue = new int[N+1][N+1];
		for(int i = 0;i<=N;i++) {
			Arrays.fill(maxValue[i], -1);
		}
		getMaxVal();
		
//		for(int[] row: maxValue) {
//			System.out.println(Arrays.toString(row));
//		}
		
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<q;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(cost-maxValue[a][b]).append("\n");
		}
		
		System.out.print(sb);
	}
}