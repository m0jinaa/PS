import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] numbers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		
		numbers = new int[n];
		for(int i = 0;i<n;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int i = n-1;
		while(i>0&&numbers[i-1]>numbers[i])i--;
		
		if(i==0) {
			System.out.println(-1);
		}
		else {
			int j = n-1;
			while(numbers[j]<=numbers[i-1])j--;
			
			swap(i-1,j);
			
			int k = n-1;
			while(i<k) {
				swap(i++,k--);
			}
			StringBuilder sb = new StringBuilder();
			for(int num:numbers) {
				sb.append(num).append(" ");
			}
			System.out.println(sb);
		}
	}
	static void swap(int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;
	}
}