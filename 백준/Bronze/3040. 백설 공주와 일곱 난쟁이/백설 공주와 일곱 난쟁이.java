import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean done = false;
	static int[] answer;
	static int[] dwarf;
	public static void get7dwarf(int i,int cnt,int sum) {
		if(done == true ||(i>=9&&sum<100)||(sum<100 &&cnt>=7)||9-i<7-cnt) {
			return;
		}
		if(cnt==7 && sum == 100) {
			for(int a:answer) {
				System.out.println(a);
			}
			done = true;
			return;
		}
		if(sum+dwarf[i]<=100) {
			answer[cnt] = dwarf[i];
			get7dwarf(i+1,cnt+1,sum+dwarf[i]);
			answer[cnt] = 0;
			get7dwarf(i+1,cnt,sum);			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarf = new int[9];
		for(int i=0;i<9;i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(dwarf);
		answer = new int[7];
		get7dwarf(0,0,0);
	}
}