import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] root;
	
	public static int ccw(long p1,long q1,long p2,long q2,long p3,long q3) {
		long val = (p2-p1)*(q3-q1)-(q2-q1)*(p3-p1);
		if(val<0) {
			return -1;
		}
		else if(val>0)
			return 1;
		else
			return 0;
	}
	public static boolean check(long[] line, long[] line2) {
		long x1 = line[0];
		long y1 = line[1];
		long x2 = line[2];
		long y2 = line[3];
		long x3 = line2[0];
		long y3 = line2[1];
		long x4 = line2[2];
		long y4 = line2[3];
		
		int c1 = ccw(x1,y1,x2,y2,x3,y3);
		int c2 = ccw(x1,y1,x2,y2,x4,y4);
		int c3 = ccw(x3,y3,x4,y4,x1,y1);
		int c4 = ccw(x3,y3,x4,y4,x2,y2);
		
		boolean r1 = Math.min(x1, x2)<=Math.max(x3, x4);
		boolean r2 = Math.min(x3, x4)<=Math.max(x1, x2);
		boolean r3 = Math.min(y1, y2)<=Math.max(y3, y4);
		boolean r4 = Math.min(y3, y4)<=Math.max(y1, y2);
		
		if(c1==0&&c2==0&&c3==0&&c4==0) {
			if(r1&&r2&&r3&&r4)
				return true;
		}
//		else if(c1*c2<=0&&c3*c4<=0)
//			return true;
		return false;
	}
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b)
			return;
		else if(a>b)
			root[a] = b;
		else
			root[b] = a;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		long[][] line = new long[n][4];
		root = new int[n];
		for(int i = 0;i<n;i++) {
			root[i] = i;
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<4;j++) {
				line[i][j] = (long)(Math.round(Double.parseDouble(st.nextToken())*100));
			}
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = i+1;j<n;j++) {
				if(find(i)!=find(j) && check(line[i],line[j])) {
					union(i,j);
				}
			}
		}
		
		int answer = 0;
		for(int i = 0;i<n;i++) {
			if(find(i)==i)
				answer++;
		}
		System.out.println(answer);
	}
}
