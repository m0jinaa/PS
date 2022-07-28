import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0;i<T;i++) {
			int n = sc.nextInt();
			int answer = 0;
			if(n%2==0) {
				answer = (n*n)/4;
			}
			else {
				answer = (((n-1)*(n-1))/4)+n;
			}
			System.out.println(answer);
		}
	}

}
