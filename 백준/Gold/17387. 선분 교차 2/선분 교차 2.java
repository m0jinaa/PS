import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long val = (x2-x1)*(y3-y1)-(y2-y1)*(x3-x1);
		if(val<0)
			return -1;
		else if(val>0)
			return 1;
		else
			return 0;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long x3 = Long.parseLong(st.nextToken());
		long y3 = Long.parseLong(st.nextToken());
		long x4 = Long.parseLong(st.nextToken());
		long y4 = Long.parseLong(st.nextToken());
		
		int c1 = ccw(x1,y1,x2,y2,x3,y3);
		int c2 = ccw(x1,y1,x2,y2,x4,y4);
		int c3 = ccw(x3,y3,x4,y4,x1,y1);
		int c4 = ccw(x3,y3,x4,y4,x2,y2);
		
		int val1 = c1*c2;
		int val2 = c3*c4;

		boolean r1 = Math.min(x1, x2)<=Math.max(x3, x4);
		boolean r2 = Math.min(x3, x4)<=Math.max(x1, x2);
		boolean r3 = Math.min(y1, y2)<=Math.max(y3, y4);
		boolean r4 = Math.min(y3, y4)<=Math.max(y1, y2);
		int answer = 0;
		if(val1==0 &&val2 == 0) {
			if(r1&&r2&&r3&&r4)
				answer = 1;
		}
		else if(val1<=0 &&val2<=0)
			answer = 1;
		System.out.println(answer);
	}

}
