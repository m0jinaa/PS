import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int now = 0;
		int[] count = new int[n];
		count[0] = 1;
		int answer = 0;
		while(true) {
			if(count[now]==m)
				break;
			if(count[now]%2==0) {
				now = (now+n-l)%n;
			}
			else {
				now = (now+l)%n;
			}
			count[now]++;
			answer++;
		}
		System.out.println(answer);
	}

}
