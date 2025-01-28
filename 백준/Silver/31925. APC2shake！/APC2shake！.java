import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Participant implements Comparable<Participant> {
		String name;
		int a;

		public Participant(String name, int a) {
			super();
			this.name = name;
			this.a = a;
		}

		@Override
		public int compareTo(Participant p) {
			return this.a - p.a;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		ArrayList<String> promoted = new ArrayList<>();

		ArrayList<Participant> list = new ArrayList<>();

		String name, school, icpc;
		int s, a;

		String hewhak = "hewhak";
		String winner = "winner";

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			name = st.nextToken();
			school = st.nextToken();
			icpc = st.nextToken();

			s = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());

			if (hewhak.equals(school) || winner.equals(icpc) || (s != -1 && s <= 3))
				continue;
			list.add(new Participant(name, a));
		}

		Collections.sort(list);

		for (Participant p : list) {
			if (promoted.size() == 10)
				break;
			promoted.add(p.name);
		}

		Collections.sort(promoted);

		sb.append(promoted.size()).append("\n");

		for (String firstname : promoted) {
			sb.append(firstname).append("\n");
		}

		System.out.print(sb.toString());
	}
}