import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		int n = T.length;
		int m = P.length;
		int[] k = new int[m];
		int i = 1;
		int j = 0;
		while(i+j<m) {
			if(P[i+j]==P[j]) {
				j++;
				k[i+j-1] = j;
			}
			else {
				if(j==0)
					i++;
				else {
					i+=j-k[j-1];
					j = k[j-1];
				}
			}
		}
		//System.out.println(Arrays.toString(k));
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		i = 0;
		j = 0;
		while(i<n) {
			//System.out.println(i+" "+j);
			if(T[i]==P[j]) {
				i++;
				j++;
				if(j==m) {
					cnt++;
					sb.append(i-m+1).append(" ");
					j = k[j-1];
				}
			}
			else {
				if(j==0) {
					i++;
				}
				else {
					j = k[j-1];
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb);		
	}
}