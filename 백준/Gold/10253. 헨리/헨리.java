import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int gcd(int x, int y) {
		if(x!=0) {
			return gcd(y%x,x);
		}
		else
			return y;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		int a,b,x,g;
		while(t-->0) {
			st = new StringTokenizer(br.readLine()," ");
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			while(a>1) {
				x = (int)Math.ceil(1.0*b/a);
				if(b%x==0) {
					a-=b/x;
				}
				else {
					a = a*x-b;
					b = b*x;
				}
				g = gcd(a,b);
				a/=g;
				b/=g;
			}
			sb.append(b).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
