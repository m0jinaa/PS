import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] word;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			word = br.readLine().toCharArray();
			int n = word.length;
			int i = n-1;
			while(i>0&&word[i-1]>=word[i])--i;
			if(i!=0) {
				int j = n-1;
				while(word[i-1]>=word[j])--j;
				
				swap(i-1,j);
				
				int k = n-1;
				
				while(i<k) {
					swap(i++,k--);
				}
			}
			sb.append(String.valueOf(word)).append("\n");
		}
		System.out.print(sb);
	}
	static void swap(int a, int b) {
		char temp = word[a];
		word[a] = word[b];
		word[b] = temp;
	}
}
