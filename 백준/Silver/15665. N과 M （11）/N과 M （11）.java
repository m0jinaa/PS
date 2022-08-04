import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] numbers;
	static int[] input;
	static StringBuilder sb;
	
	static void permutation(int cnt) {
		if(cnt==m) {
			for(int i:numbers) {
				sb.append(i+" ");
			}
			sb.append("\n");
		}
		else {
			for(int i = 0;i<n;i++) {
				numbers[cnt] = input[i];
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
		
		st = new StringTokenizer(br.readLine());
		Set<Integer> set= new HashSet<Integer>();
		for(int i = 0;i<n;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		n = set.size();
		input = new int[n];
		int ind = 0;
		for(Integer i:set) {
			input[ind++] = i;
		}
		numbers = new int[m];
		sb = new StringBuilder();
		permutation(0);
		
		System.out.print(sb);	
	}
}
