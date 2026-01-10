import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Employee implements Comparable<Employee> {
		int d, h, l;
		boolean deka;

		public Employee(int d, int h, int l) {
			super();
			this.d = d;
			this.h = h;
			this.l = l;
			this.deka = false;
		}

		public void setDeka() {
			this.deka = true;
		}

		@Override
		public int compareTo(Employee e) {
			// 우선순위 : 근무일수>화장실 급한정도>낮은 줄 번호

			if (this.d != e.d) {
				return e.d - this.d;
			} else if (this.h != e.h) {
				return e.h - this.h;
			} else {
				return this.l - e.l;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Employee[] employees = new Employee[n];

		int d, h, l;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			l = i % m;

			employees[i] = new Employee(d, h, l);
		}

		// k+1번째 사원이 데카임을 설정
		employees[k].setDeka();

		// 줄마다 맨 앞자리에 서있는 사원들의 모임
		PriorityQueue<Employee> q = new PriorityQueue<>();

		// 줄마다 두번째로 서있는 사원의 index
		int[] ind = new int[m];

		for (int i = 0; i < n && i < m; i++) {
			q.add(employees[i]);
			ind[i] = i + m;
		}

		int answer = 0;

		Employee now;

		while (!q.isEmpty()) {
			// 앞줄에 서있는 사원 중에 우선순위 높은 사원 가져오기
			now = q.poll();

			// 지금 화장실 이용하는 사원이 데카라면 탈출
			if (now.deka)
				break;

			answer++;

			if (ind[now.l] >= n)
				continue;
			q.add(employees[ind[now.l]]);
			ind[now.l] += m;
		}

		System.out.println(answer);
	}
}