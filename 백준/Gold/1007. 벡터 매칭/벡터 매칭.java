import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	public static double answer = 300000;
	public static void getMinSum(int i, int[][] dots, long x, long y, int p, int m) {
//		System.out.println(i+ " "+x+ " "+y+ " "+p+ " "+m);
//		System.out.println("length : "+dots.length);
		if(i>dots.length)
			return;
		if(p+m == dots.length) {
			double val = Math.sqrt(x*x+y*y);
			if (answer>val)
				answer = val;
		}
		else if(p == dots.length/2) {
			getMinSum(i+1,dots,x-dots[i][0],y-dots[i][1],p,m+1);
		}
		else if(m == dots.length/2) {
			getMinSum(i+1,dots,x+dots[i][0],y+dots[i][1],p+1,m);			
		}
		else {
			getMinSum(i+1,dots,x+dots[i][0],y+dots[i][1],p+1,m);
			getMinSum(i+1,dots,x-dots[i][0],y-dots[i][1],p,m+1);						
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			answer = 300000;
			int n = Integer.parseInt(br.readLine());
			int[][] dots = new int[n][2];
			for(int i = 0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				dots[i][0] = Integer.parseInt(st.nextToken());
				dots[i][1] = Integer.parseInt(st.nextToken());
			}
			getMinSum(0,dots,0,0,0,0);
			System.out.println(answer);
		}
	}
}