import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] numbers;
	static char[] operator;
	static int nlen,olen;
	static int answer = Integer.MIN_VALUE;
	static int cal(int v, char o, int num) {
		//System.out.println(v+ " "+o+ " "+num);
		switch(o) {
		case'+':
			return v+num;
		case'-':
			return v-num;
		default:
			return v*num;
		}	
	}
	static void getMax(int val,int i,int j) {
		if(i == olen) {
			answer = answer<val?val:answer;
			return;
		}
		//지금꺼 묶기
		getMax(cal(val,operator[i],numbers[j]),i+1,j+1);
		//다음꺼 묶기
		if(i<olen-1) {//뒤로 묶을 operator가 남아있을 때
			getMax(cal(val,operator[i],cal(numbers[j],operator[i+1],numbers[j+1])),i+2,j+2);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nlen = (N+1)/2;
		olen = N/2;
		numbers = new int[nlen];
		operator = new char[olen];
		char[] carr = br.readLine().toCharArray();
		for(int i = 0;i<N;i++) {
			if(i%2==0)
				numbers[i/2] = carr[i]-'0';
			else {
				operator[i/2]=carr[i];

			}
		}
		getMax(numbers[0],0,1);
		
		System.out.println(answer);
	}
}
