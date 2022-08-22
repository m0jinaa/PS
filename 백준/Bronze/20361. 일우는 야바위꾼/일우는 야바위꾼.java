import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{//클래스 시작
	static int[] candy;//사탕 위치 저장할 배열
	static int temp;//swap할 때 임시로 저장할 변수
	public static void main(String[] args) throws NumberFormatException, IOException {//main시작
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력 받기위해 BufferedReader 사용
		StringTokenizer st; //입력을 split하기 위해 StringTokenizer 사용
		StringBuilder sb = new StringBuilder(); //출력을 위해 StringBuilder 사용
//		int tc = Integer.parseInt(br.readLine()); //게임 테스트 횟수 입력 받기 
		int n,x,k,a,b;//테스트 케이스 마다 안에서 사용할 변수 선언
		int answer;//정답 저장할 변수
//		for(int t = 1;t<=tc;t++) {//테스트 케이스 시작
		st = new StringTokenizer(br.readLine()," ");//띄어쓰기로 split
		n = Integer.parseInt(st.nextToken());//컵 개수
		x = Integer.parseInt(st.nextToken());//현재 간식 위치
		k = Integer.parseInt(st.nextToken());//
		candy = new int[n+1];//간식 위치 저장 배열 초기화
		candy[x] = 1;//현재 간식 위치 표시
		for(int i = 0;i<k;i++) {//start for
			st = new StringTokenizer(br.readLine()," ");//바꿀 위치 구분
			a = Integer.parseInt(st.nextToken());//첫번째 위치 
			b = Integer.parseInt(st.nextToken());//두번째 위치
			
			swap(a,b);//두 위치 바꿔주기
		}//end for
		answer = 0;//정답 초기화
		for(int i = 0;i<=n;i++) {//for문을 돌면서
			if(candy[i] == 1) {//현재 위치에 간식 있다면
				answer = i;//긴식 위치 저장
				break;//간식 1개뿐이니까 탈출
			}
		}
//			sb.append("#").append(t).append(" ").append(answer).append("\n");//테스트 케이스 결과 sb에 저장
//		}//테스트케이스 종료
		System.out.print(answer);//출력
	}//main 종료
	static void swap(int i,int j) {//swap메소드 시작
		temp = candy[i];//임시저장
		candy[i] = candy[j];//i위치에 j위치의 값 저장
		candy[j] = temp;//j위치에 temp값 저장
	}//swap메소드 종료
}//클래스 종료
