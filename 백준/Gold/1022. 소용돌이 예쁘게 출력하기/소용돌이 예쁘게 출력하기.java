import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean inRange(int r1,int r2,int c1,int c2,int a,int b) {
		if(r1<=a && a<=r2&&c1<=b&&b<=c2) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] dx = {0,-1,0,1};
		int[] dy = {1,0,-1,0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int r = r2-r1+1;
		int c = c2-c1+1;
		int[][] answer = new int[r][c];
		int length = 1;
		int cnt = 0;
		int fill = 0;
		int x = 0;
		int y = 0;
		int d = 0;
		int n = 1;
		int max = 0;
		
		while(fill<r*c) {
			int i = 0;
			while(i++<length) {
				if(inRange(r1,r2,c1,c2,x,y)) {
					answer[x-r1][y-c1] = n;
					fill++;
					max = Math.max(n, max);
				}
				x+=dx[d];
				y+=dy[d];
				n++;
			}
			cnt++;
			if(cnt==2) {
				cnt = 0;
				length++;
			}
			d = (d+1)%4;
		}
		int t = (int)( Math.log10(max)+1);
		String te = Integer.toString(t);
		
		for(int[] row:answer) {
			for(int data:row) {
				System.out.printf("%"+te+"d ",data);
			}
			System.out.println();
		}
	}
}
