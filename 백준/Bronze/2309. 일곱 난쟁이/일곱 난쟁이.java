import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Main {
	static boolean done = false;
	
	public static void get7drawf(int[] d,int i,int[] ans,int cnt,int sum) {
		if(cnt==7 && sum == 100) {
			for(int a:ans) {
				System.out.println(a);
			}
			done = true;
			return;
		}
		if(done == true ||(i>=9&&sum<100)||(sum<100 &&cnt>=7)||9-i<7-cnt) {
			return;
		}
		if(sum+d[i]<=100) {
			ans[cnt] = d[i];
			get7drawf(d,i+1,ans,cnt+1,sum+d[i]);
			ans[cnt] = 0;
			get7drawf(d,i+1,ans,cnt,sum);			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] drawf = new int[9];
		for(int i=0;i<9;i++) {
			drawf[i] = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(drawf);
		int[] answer = new int[7];
		get7drawf(drawf,0,answer,0,0);	
	}
}
