import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int answer;
	static int max;
	static void getMax(int[][] g) {
		max = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				max = max<g[i][j]?g[i][j]:max;
			}
		}
		answer = answer<max?max:answer;
	}
	
	static void move(int[][] g,int cnt) {
		if(cnt==5) {
			getMax(g);
			return;
		}
		else {
			int[][] m1 = new int[n][];
			int[][] m2 = new int[n][];
			int[][] m3 = new int[n][];
			int[][] m4 = new int[n][];
			
			for(int i = 0;i<n;i++) {
				m1[i] = Arrays.copyOf(g[i], n);
				m2[i] = Arrays.copyOf(g[i], n);
				m3[i] = Arrays.copyOf(g[i], n);
				m4[i] = Arrays.copyOf(g[i], n);
			}
			int ind = 0,j,bef,val;
			//왼쪽
			for(int i = 0;i<n;i++) {
				ind = 0;
				j = 0;
				bef = 0;
				val = 0;
				while(j<n) {
					val = g[i][j];
					j++;
					if(val==0) {
						continue;
					}
					else if(bef==val) {
						m1[i][ind++] = val*2;
						bef = 0;
					}
					else if(bef==0) {
						bef = val;
					}
					else {
						m1[i][ind++] = bef;
						bef = val;
					}
				}
				if(bef!=0) {
					m1[i][ind++] = bef;
				}
				for(int k = ind;k<n;k++) {
					m1[i][k] = 0;
				}
			}
			
			//오른쪽
			for(int i = 0;i<n;i++) {
				ind = n-1;
				j = n-1;
				bef = 0;
				val = 0;
				while(j>=0) {
					val = g[i][j];
					j--;
					if(val==0) {
						continue;
					}
					else if(bef==val) {
						m2[i][ind--] = val*2;
						bef = 0;
					}
					else if(bef==0) {
						bef = val;
					}
					else {
						m2[i][ind--] = bef;
						bef = val;
					}
				}
				if(bef!=0) {
					m2[i][ind--] = bef;
				}
				for(int k = ind;k>=0;k--) {
					m2[i][k] = 0;
				}
			}

			//위
			for(int i = 0;i<n;i++) {
				ind = 0;
				j = 0;
				bef = 0;
				val = 0;
				while(j<n) {
					val = g[j][i];
					j++;
					if(val==0) {
						continue;
					}
					else if(bef==val) {
						m3[ind++][i] = val*2;
						bef = 0;
					}
					else if(bef==0) {
						bef = val;
					}
					else {
						m3[ind++][i] = bef;
						bef = val;
					}
				}
				if(bef!=0) {
					m3[ind++][i] = bef;
				}
				for(int k = ind;k<n;k++) {
					m3[k][i] = 0;
				}
			}
			
			//아래
			for(int i = 0;i<n;i++) {
				ind = n-1;
				j = n-1;
				bef = 0;
				val = 0;
				while(j>=0) {
					val = g[j][i];
					j--;
					if(val==0) {
						continue;
					}
					else if(bef==val) {
						m4[ind--][i] = val*2;
						bef = 0;
					}
					else if(bef==0) {
						bef = val;
					}
					else {
						m4[ind--][i] = bef;
						bef = val;
					}
				}
				if(bef!=0) {
					m4[ind--][i] = bef;
				}
				for(int k = ind;k>=0;k--) {
					m4[k][i] = 0;
				}
			}
			move(m1,cnt+1);
			move(m2,cnt+1);
			move(m3,cnt+1);
			move(m4,cnt+1);	
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(map,0);
		
		System.out.println(answer);
	}
}