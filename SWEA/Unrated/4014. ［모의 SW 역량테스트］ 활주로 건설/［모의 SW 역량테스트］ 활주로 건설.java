import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,x;
	static int[][] map, vmap;
	
	private static int check(int[][] board) {
		// TODO Auto-generated method stub
		int ans=0;
		int c; //몇칸째
		boolean l = false; //경사로 영역 포함 여부
		for(int[] line:board) {
			l = false;
			c = 1;
			for(int i = 1;i<n;i++) {
				if(line[i]==line[i-1]) {
					if(l) {
						if(c==x) {
							l = false;
							c = 1;
						}
						else {
							c++;
						}
					}
					else {
						c++;
					}
				}
				else if(line[i-1]>line[i]) {
					if(line[i-1]-line[i]!=1)
						break;
					if(l && c<x)
						break;
					l = true;
					c = 1;
				}
				else {
					if(line[i]-line[i-1]!=1)
						break;
					if(l || c<x)
						break;
					l = false;
					c = 1;
				}
				
				if(i==n-1) {
					if(l && c<x)
						break;
					ans++;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			vmap = new int[n][n];
			int answer = 0;
			for(int i = 0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0;j<n;j++) {
					map[i][j] = vmap[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = check(map)+check(vmap);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		
		}
		System.out.println(sb.toString());
	}
}