import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static int[] order;
	static int[][] arg;
	static boolean[] v;
	static int answer = Integer.MAX_VALUE;
    
	static void rotate(int[][] g, int a, int b,int c) {
		int x1 = a-c;
		int y1 = b-c;
		int x2 = a+c;
		int y2 = b+c;
		
		//left
		int temp1 = g[x1][y1];
		for(int i = x1+1;i<=x2;i++) {
			g[i-1][y1] = g[i][y1];
		}
		//up
		int temp2 = g[x1][y2];
		for(int i = y2-1;i>y1;i--) {
			g[x1][i+1] = g[x1][i]; 
		}
		g[x1][y1+1] = temp1;
		//right
		temp1 = g[x2][y2];
		for(int i = x2-1;i>x1;i--) {
			g[i+1][y2] = g[i][y2];
		}
		g[x1+1][y2] = temp2;
		//bottom
		for(int i = y1+1;i<y2;i++) {
			g[x2][i-1] = g[x2][i];
		}
		g[x2][y2-1] = temp1;
	}
    
	static void getMinSum() {
		int[][] graph = new int[n][m];
		for(int i = 0;i<n;i++) {
			graph[i] = Arrays.copyOf(map[i], m);
		}	
		for(int o:order) {
			for(int i = 1;i<=arg[o][2];i++) {
				rotate(graph,arg[o][0],arg[o][1],i);
			}
		}	
		for(int i = 0;i<n;i++) {
			int sum = 0;
			for(int j = 0;j<m;j++) {
				sum+=graph[i][j];
			}
			answer = Math.min(answer,sum);
		}
		
	}
	static void permutation(int i) {
		if(i==k) {
			getMinSum();
		}
		for(int j = 0;j<k;j++) {
			if(!v[j]) {
				v[j] = true;
				order[i] = j;
				permutation(i+1);
				v[j] = false;
			}
		}		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arg = new int[k][3];
		
		for(int i = 0;i<k;i++) {
			st = new StringTokenizer(br.readLine()," ");
			arg[i][0] = Integer.parseInt(st.nextToken())-1;
			arg[i][1] = Integer.parseInt(st.nextToken())-1;
			arg[i][2] = Integer.parseInt(st.nextToken());
		}
		order = new int[k];
		v = new boolean[k];
		permutation(0);
		
		System.out.println(answer);
	}
}
