import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int ccw(long a,long b,long c,long d, long e, long f) {
		long val = (c-a)*(f-b)-(d-b)*(e-a);
		if (val<0)
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
		
		if(ccw(x1,y1,x2,y2,x3,y3)*ccw(x1,y1,x2,y2,x4,y4)<0&&ccw(x3,y3,x4,y4,x1,y1)*ccw(x3,y3,x4,y4,x2,y2)<0)
			System.out.println(1);
		else
			System.out.println(0);
		
	}
}
