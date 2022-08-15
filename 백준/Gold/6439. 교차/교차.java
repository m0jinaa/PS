import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int ccw(int p1, int q1, int p2, int q2, int p3, int q3) {
		int val = (p2-p1)*(q3-q1)-(q2-q1)*(p3-p1);
		if(val>0)
			return 1;
		else if(val<0)
			return -1;
		else
			return 0;
	}
	public static boolean check(int p1, int q1, int p2, int q2, int p3, int q3, int p4, int q4) {
		int c1 = ccw(p1,q1,p2,q2,p3,q3);
		int c2 = ccw(p1,q1,p2,q2,p4,q4);
		int c3 = ccw(p3,q3,p4,q4,p1,q1);
		int c4 = ccw(p3,q3,p4,q4,p2,q2);
		
		boolean r1 = Math.min(p1, p2)<=Math.max(p3, p4);
		boolean r2 = Math.min(q1, q2)<=Math.max(q3, q4);
		boolean r3 = Math.max(p1, p2)>=Math.min(p3, p4);
		boolean r4 = Math.max(q1, q2)>=Math.min(q3, q4);
		
		if(c1==0&&c2==0&&c3==0&&c4==0) {
			if(r1&&r2&&r3&&r4)
				return true;
		}
		else if(c1*c2<=0&&c3*c4<=0) {
			return true;
		}
		return false;
	}
	
	public static boolean inside(int p1, int q1, int p2, int q2, int p3, int q3, int p4, int q4) {
		
		boolean r1 = Math.min(p3, p4)<=Math.min(p1, p2);
		boolean r2 = Math.max(p3, p4)>=Math.max(p1, p2);
		boolean r3 = Math.min(q3, q4)<=Math.min(q1, q2);
		boolean r4 = Math.max(q3, q4)>=Math.max(q1, q2);
		if(r1&&r2&&r3&&r4)
			return true;		
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int lx, ly, rx, ry, x1, x2, x3, x4, y1, y2, y3, y4;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			st = new StringTokenizer(br.readLine()," ");
			
			lx = Integer.parseInt(st.nextToken());
			ly = Integer.parseInt(st.nextToken());
			rx = Integer.parseInt(st.nextToken());
			ry = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x3 = Integer.parseInt(st.nextToken());
			y3 = Integer.parseInt(st.nextToken());
			x1 = x2;
			y1 = y3;
			x4 = x3;
			y4 = y2;
			
			if(check(lx,ly,rx,ry,x1,y1,x2,y2)
			||check(lx,ly,rx,ry,x1,y1,x3,y3)
			||check(lx,ly,rx,ry,x2,y2,x4,y4)
			||check(lx,ly,rx,ry,x3,y3,x4,y4)) {
				System.out.println("T");
			}
			else if(inside(lx,ly,rx,ry,x2,y2,x3,y3))
				System.out.println("T");
			else
				System.out.println("F");
		}
	}
}
