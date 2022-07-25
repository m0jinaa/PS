import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] A = new int[4];
		int[] B = new int[4];
		for(int i = 0;i<t;i++) {
			Arrays.fill(A, 0);
			Arrays.fill(B, 0);
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j = 0;j<a;j++) {
				A[Integer.parseInt(st.nextToken())-1]++;
			}

			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int j = 0;j<b;j++) {
				B[Integer.parseInt(st.nextToken())-1]++;
			}
			
			boolean over = false;
			for(int j = 3;j>=0;j--) {
				if(A[j]==B[j])
					continue;
				else if(A[j]>B[j])
					System.out.println('A');
				else
					System.out.println('B');
				over=true;
				break;
			}
			if(!over)
				System.out.println('D');
		}
	}

}
