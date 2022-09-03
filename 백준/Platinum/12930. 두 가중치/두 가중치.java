import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main{
	static int[][][] map;
	static int n;
	static int[][] cost;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n][2];
		char[] arr;
		for(int i = 0;i<2;i++) {
			for(int j = 0;j<n;j++) {
				arr = br.readLine().toCharArray();
				for(int k = 0;k<n;k++) {
					if(arr[k]=='.')
						map[j][k][i] = -1;
					else
						map[j][k][i] = arr[k]-'0';
				}
			}
		}
		
		Queue<int[]> q = new PriorityQueue<int[]>((n1,n2)->n1[1]*n1[2]-n2[1]*n2[2]);
		
		q.add(new int[] {0,0,0});
		cost = new int[n][181];
		for(int i = 0;i<n;i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		cost[0][0] = 0;
		int[] now,next;
		int a,b,c,nb,nc;
		int answer = -1;
		while(!q.isEmpty()) {
			now = q.poll();
			a = now[0];
			b = now[1];
			c = now[2];
			if(cost[a][b]<b*c){
				continue;
			}
			if(a==1) {
				answer = cost[a][b];
				break;
			}
			for(int i = 0;i<n;i++) {
				next = map[a][i];
				if(next[0] == -1)
					continue;
				nb = b+next[0];
				nc = c+next[1];
				if(cost[i][nb]>nb*nc) {
					cost[i][nb] = nb*nc;
					q.add(new int[] {i,nb,nc});
				}
			}		
		}	
		System.out.println(answer);
	}
}
