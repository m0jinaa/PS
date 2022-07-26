import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int[] cake = new int[l+1];

		int n = sc.nextInt();
		int assume = 0;
		int assumeAns = 0;
		int[] person = new int[n+1];
		for(int i = 1;i<=n;i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			int v = k-p+1;
			if(assume<v) {
				assume = v;
				assumeAns = i;
			}
			for(int j = p;j<=k;j++) {
				if(cake[j]==0) {
					cake[j] = i;
					person[i]++;
				}
			}
		}
		int real = 0;
		int realAns= 0;
		for(int i = 1;i<=n;i++) {
			if(real<person[i]) {
				real = person[i];
				realAns = i;
			}
		}
		System.out.println(assumeAns);
		System.out.println(realAns);
	}
}
