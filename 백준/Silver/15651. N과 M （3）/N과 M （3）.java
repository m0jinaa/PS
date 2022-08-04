import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int[] numbers;
	static int n;
	static int m;
	static void permutation(int cnt) throws IOException {
		if(cnt==m) {
			for(int num:numbers)
				sb.append(num+" ");
			sb.append("\n");
			return;
		}
		else {
			for(int i = 1;i<=n;i++) {
				numbers[cnt] = i;
				permutation(cnt+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		numbers = new int[m];
		permutation(0);
		System.out.print(sb);	
	}
}
