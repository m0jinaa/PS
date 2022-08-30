import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static long[] w;
	static boolean[] done;
	static boolean[][] crossed;
	static long[][] line;
	static ArrayList<int[]> cnt;
	public static int ccw(long p1, long q1, long p2, long q2, long p3, long q3) {
		long val = (p2-p1)*(q3-q1)-(q2-q1)*(p3-p1);
		if(val<0)
			return -1;
		else if(val>0)
			return 1;
		else
			return 0;
	}
	
	public static boolean check(long[] l1, long[] l2) {
		long x1 = l1[0];
		long y1 = l1[1];
		long x2 = l1[2];
		long y2 = l1[3];
		long x3 = l2[0];
		long y3 = l2[1];
		long x4 = l2[2];
		long y4 = l2[3];
		
		int c1 = ccw(x1,y1,x2,y2,x3,y3);
		int c2 = ccw(x1,y1,x2,y2,x4,y4);
		int c3 = ccw(x3,y3,x4,y4,x1,y1);
		int c4 = ccw(x3,y3,x4,y4,x2,y2);
	
		if(c1*c2<0&&c3*c4<0)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		n = Integer.parseInt(br.readLine());
		w = new long[n];
		done = new boolean[n];
		crossed = new boolean[n][n];
		line = new long[n][4];
		long answer = 0;
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<4;j++) {
				line[i][j] = Long.parseLong(st.nextToken());
			}
			w[i] = Long.parseLong(st.nextToken());
		}
		cnt = new ArrayList<int[]>();
		for(int i = 0;i<n;i++) {
			cnt.add(new int[]{i,0});
		}
		for(int i = 0;i<n;i++) {
			for(int j = i+1;j<n;j++) {
				if(check(line[i],line[j])) {
					crossed[i][j] = true;
					crossed[j][i] = true;
					cnt.get(i)[1]++;
					cnt.get(j)[1]++;
				}
			}
		}
		cnt.sort((c1,c2)->{
			return w[c1[0]]<w[c2[0]]?-1:1;
//			if(c1[1]==c2[1])
//				return w[c1[0]]<w[c2[0]]?-1:1;
//			else
//				return c1[1]<c2[1]?-1:1;
		});
		int c = 0;
		int r;
		for(int[] row:cnt) {
//			System.out.println(Arrays.toString(done));
//			System.out.println(Arrays.toString(row));
			c = 0;
			r = row[0];

			for(int i = 0;i<n;i++) {
				if(crossed[r][i]&&!done[i])
					c++;
			}
			answer+=(c+1)*w[r];
			done[r] = true;
		}
		System.out.println(answer);
	}
}