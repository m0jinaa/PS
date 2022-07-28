import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = new int[101][101];
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0;i<n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int j = a;j<a+10;j++) {
				for(int k = b;k<b+10;k++) {
					map[j][k]++;
				}
			}
		}
		
		int answer = 0;
		for(int i = 0;i<101;i++) {
			for(int j = 0;j<101;j++) {
				if(map[i][j]==0)
					continue;
				int cnt = 0;
				
				for(int k = 0;k<4;k++) {
					int x = i+dx[k];
					int y = j+dy[k];
					if(0>x||x>=101||0>y||y>=101) {
						continue;
					}
					if(map[x][y]==0)
						cnt++;
				}
				answer+=cnt;
			}
		}
		System.out.println(answer);
	}

}
