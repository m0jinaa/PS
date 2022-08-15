import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static int ccw(long lx, long ly, long rx, long ry, long x1, long y1) {
		long val = (rx-lx)*(y1-ly)-(ry-ly)*(x1-lx);
		if(val>0)
			return 1;
		else if(val<0)
			return -1;
		else
			return 0;
	}
	public static boolean check(long lx, long ly, long rx, long ry, long x1, long y1, long x2, long y2) {
		int c1 = ccw(lx,ly,rx,ry,x1,y1);
		int c2 = ccw(lx,ly,rx,ry,x2,y2);
		int c3 = ccw(x1,y1,x2,y2,lx,ly);
		int c4 = ccw(x1,y1,x2,y2,rx,ry);
		
		boolean r1 = Math.min(lx, rx)<=Math.max(x1, x2);
		boolean r2 = Math.min(ly, ry)<=Math.max(y1, y2);
		boolean r3 = Math.max(lx, rx)>=Math.min(x1, x2);
		boolean r4 = Math.max(ly, ry)>=Math.min(y1, y2);
		
		if(c1==0&&c2==0&&c3==0&&c4==0) {
			if(r1&&r2&&r3&&r4)
				return true;
		}
		else if(c1*c2<=0&&c3*c4<=0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long lx, ly, rx, ry, x1, x2, y1, y2;
		int n = Integer.parseInt(br.readLine());
		boolean meet = false;
		long[] y = new long[n+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1;i<=n;i++) {
			y[i] = Long.parseLong(st.nextToken());
		}
		long k = Long.parseLong(br.readLine());
		if(n==1 && y[1]==k)
				meet = true;
	
		for(int t = 2;t<=n;t++) {
			
			lx = t-1;
			ly = y[t-1];
			rx = t;
			ry = y[t];
			x1 = t-1;
			y1 = (t-1)*k;
			x2 = t;
			y2 = t*k;
			
			if(check(lx,ly,rx,ry,x1,y1,x2,y2)) {
				meet = true;
				break;
			}	
		}
		if(meet)
			System.out.println("T");
		else
			System.out.println("F");
	}
}
