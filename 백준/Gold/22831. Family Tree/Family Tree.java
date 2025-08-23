import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int ind = 1;
	static Map<String, Integer> map;
	static int[] parent;

	static int getInd(String x) {
		if (!map.containsKey(x)) {
			map.put(x, ind++);
		}

		return map.get(x);
	}

	static boolean checkParent(int c, int p) {
		return parent[c] == p;
	}

	static boolean checkSibling(int x, int y) {
		return parent[x] == parent[y];
	}

	static boolean checkAncestor(int d, int a) {
		while (d != 0) {
			if (d == a)
				return true;
			d = parent[d];
		}
		return false;
	}

	static boolean checkRelationship(int a, String r, int b) {
		if ("child".equals(r)) {
			return checkParent(a, b);
		} else if ("parent".equals(r)) {
			return checkParent(b, a);
		} else if ("sibling".equals(r)) {
			return checkSibling(a, b);
		} else if ("descendant".equals(r)) {
			return checkAncestor(a, b);
		} else {
			return checkAncestor(b, a);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n, m;

		Stack<Integer> familyTree = new Stack<>();
		String name;
		int index;
		String input;
		int indent;

		int a, b;
		String relationship;

		int t = 0;

		map = new HashMap<>();

		while (true) {

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			t++;

			if (t != 1)
				sb.append("\n");

			parent = new int[n + 1];
			map.clear();
			familyTree.clear();
			ind = 1;

			// 최고조상 입력받기
			name = br.readLine();

			index = getInd(name);

			familyTree.add(index);

			for (int i = 1; i < n; i++) {
				input = br.readLine();
				name = input.trim();

				indent = input.length() - name.length();

				while (indent != familyTree.size()) {
					familyTree.pop();
				}

				index = getInd(name);
				parent[index] = familyTree.peek();
				familyTree.add(index);
			}

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");

				// statement에서 필요한 요소 추출
				a = getInd(st.nextToken());
				st.nextToken();
				st.nextToken();
				relationship = st.nextToken();
				st.nextToken();
				b = getInd(st.nextToken().replace(".", ""));

				sb.append(checkRelationship(a, relationship, b) ? "True\n" : "False\n");
			}
		}

		System.out.print(sb.toString());
	}
}