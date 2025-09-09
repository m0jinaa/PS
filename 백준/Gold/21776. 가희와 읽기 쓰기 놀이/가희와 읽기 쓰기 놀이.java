import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sbb = new StringBuilder();
	static final int MAX = 100;
	static final String ERROR = "ERROR";
	static final String EMPTY = "EMPTY";
	static int n, c;
	// 카드 종류
	static Card[] cards;
	// 사람마다 어떤카드를 순서대로 냈는지
	static int[][] haveCard;
	// 사람마다 낸 카드 개수
	static int[] cnt;
	// 만들 수 있는 문자
	static Set<String> set;
	static char[] stack;
	// 삭제 여부 체크
	static boolean[] deleted;
	static int d;
	static int stackInd = 0;
	static int[] used;
	static int[] order;

	static class Operation {
		int type; // 0 : add, 1 : del
		int ind;
		char w;

		public Operation(int type, char w) {
			super();
			this.type = type;
			this.w = w;
		}

		public Operation(int type, int ind) {
			super();
			this.type = type;
			this.ind = ind;
		}
	}

	static class Card {
		Operation[] opers;
		int l;
		private int ind;

		public Card(int l) {
			super();
			this.l = l;
			this.opers = new Operation[l];
			this.ind = 0;
		}

		void insertAdd(char w) {
			opers[this.ind] = new Operation(0, w);
			this.ind++;
		}

		void insertDel(int x) {
			opers[this.ind] = new Operation(1, x);
			this.ind++;
		}
	}

	static boolean executeCard(int x) {

		int nd;

		for (Operation o : cards[x].opers) {
			if (o.type == 0) { // add
				stack[stackInd++] = o.w;
			} else if (stackInd - d <= o.ind) { // 삭제할 수 없는 경우
				return false;
			} else {
				nd = 0;
				for (int i = 0; i < stackInd; i++) {
					if (deleted[i])
						continue;
					else if (nd == o.ind) {
						deleted[i] = true;
						d++;
						break;
					}
					nd++;
				}
			}
		}

		return true;
	}

	static void play() {
		int[] ind = new int[n];
		Arrays.fill(deleted, false);
		stackInd = 0;
		d = 0;
		boolean err = false;

		for (int i = 0; i < c; i++) {
			if (!executeCard(haveCard[order[i]][ind[order[i]]])) { // 카드 실행 중 오류가 생긴 경우
				err = true;
				break;
			}
			ind[order[i]]++;
		}
		if (err)
			set.add(ERROR);
		else
			set.add(makeString());
	}

	static String makeString() {
		sbb.setLength(0);
		for (int i = 0; i < stackInd; i++) {
			if (deleted[i])
				continue;
			sbb.append(stack[i]);
		}

		return sbb.length() == 0 ? EMPTY : sbb.toString();
	}

	// 카드 내는 사람 순서 정하기
	static void makeOrder(int x) {
		if (x == c) {
			play();
		} else {
			for (int i = 0; i < n; i++) {
				if (used[i] == cnt[i])
					continue;
				used[i]++;
				order[x] = i;
				makeOrder(x + 1);
				used[i]--;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st, stt;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		order = new int[c];
		haveCard = new int[n][];
		cnt = new int[n];
		used = new int[n];
		set = new HashSet<>();
		stack = new char[MAX];
		deleted = new boolean[MAX];
		int m;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			cnt[i] = m;

			haveCard[i] = new int[m];

			for (int j = 0; j < m; j++) {
				haveCard[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}

		cards = new Card[c];
		int l;
		String type;
		char w;
		int x;

		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine(), ",");

			l = st.countTokens();

			cards[i] = new Card(l);

			for (int j = 0; j < l; j++) {
				stt = new StringTokenizer(st.nextToken(), " ");

				type = stt.nextToken();

				switch (type) {
				case "ADD":
					w = stt.nextToken().charAt(0);
					cards[i].insertAdd(w);
					break;
				case "DEL":
					x = Integer.parseInt(stt.nextToken());
					cards[i].insertDel(x);
					break;
				}
			}
		}

		makeOrder(0);

		String[] answers = new String[set.size()];

		set.toArray(answers);

		Arrays.sort(answers);

		for (String ans : answers) {
			sb.append(ans).append("\n");
		}

		System.out.print(sb.toString());
	}
}