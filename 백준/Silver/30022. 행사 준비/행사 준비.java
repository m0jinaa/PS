import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Product implements Comparable<Product> {
		int p, q;

		public Product(int p, int q) {
			super();
			this.p = p;
			this.q = q;
		}

		@Override
		public int compareTo(Product product) {
			int pq1 = this.p - this.q;
			int pq2 = product.p - product.q;

			return pq1 - pq2;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		Product[] products = new Product[n];

		int p, q;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			products[i] = new Product(p, q);
		}

		Arrays.sort(products);

		long answer = 0;

		for (Product product : products) {
			if (a-- > 0) {
				answer += product.p;
			} else {
				answer += product.q;
			}
		}

		System.out.println(answer);
	}
}