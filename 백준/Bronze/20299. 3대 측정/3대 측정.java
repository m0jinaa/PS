import java.io.BufferedReader; //입력받을 때 사용
import java.io.InputStreamReader; //입력받을 때 사용 
import java.util.StringTokenizer; //입력받을 때 사용

public class Main { //class 시작
	static int n,s,m; //사용할 전역변수 선언
	
	public static void main(String[] args) throws Exception { // main 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력 받을 때 사용
		StringTokenizer st = new StringTokenizer(br.readLine()," "); // split 할 때 사용
		
		n = Integer.parseInt(st.nextToken()); //신청 동아리수
		s = Integer.parseInt(st.nextToken()); // 최소 합 기준
		m = Integer.parseInt(st.nextToken()); // 최소 값 기준
		
		int x1,x2,x3; //각 팀원 능력치
		StringBuilder sb = new StringBuilder(); //출력용
		int count = 0; //가입가능한 동아리 수
		for(int i = 0;i<n;i++) { //for 시작
			st = new StringTokenizer(br.readLine()," "); //각 팀 정보 받아오기
			x1 = Integer.parseInt(st.nextToken()); // 첫번째 팀원 능력치
			x2 = Integer.parseInt(st.nextToken()); // 두번째 팀원 능력치
			x3 = Integer.parseInt(st.nextToken()); // 세번째 팀원 능력치
			if(Math.min(x1, Math.min(x2, x3))<m || x1+x2+x3<s) //팀원 능력이 m 미만이거나, 팀원의 능력 합이 s 미만인 경우
				continue; // 패스
			count++; //가입가능한 동아리 수 증가
			sb.append(x1).append(" ").append(x2).append(" ").append(x3).append(" "); //sb에 동아리원 능력 추가
		} //end for 
		
		System.out.println(count); //가입 가능한 동아리수 출력
		System.out.println(sb.toString()); // 동아리원들 능력 출력
		
	}// end main
} //end class