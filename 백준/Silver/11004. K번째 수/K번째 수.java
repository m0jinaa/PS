import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class MaxHeap {
		private int n, size;
		private int[] heap;

		public MaxHeap(int size) {
			super();
			this.size = size;
			this.n = 0;
			this.heap = new int[size + 1];// 1부터 시작
		}

		public int poll() {
			int value = this.heap[1];

			int t = this.heap[n];

			n--;
			int p = 1;
			int c = 2;
			while (c <= this.n) {
				if (c < this.n && this.heap[c] < this.heap[c + 1]) {
					c++;
				}
				if (t > this.heap[c])
					break;
				this.heap[p] = this.heap[c];
				p = c;
				c *= 2;
			}
			this.heap[p] = t;

			return value;
		}

		public void add(int x) {
			heap[++n] = x;
			int c = n;

			while (c > 1) {
				if (heap[c] > heap[c / 2]) {
					swap(c, c / 2);
					c /= 2;
				} else {
					break;
				}
			}
		}

		public int peek() {
			return heap[1];
		}

		private void swap(int a, int b) {
			int t = heap[a];
			heap[a] = heap[b];
			heap[b] = t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		MaxHeap maxHeap = new MaxHeap(k);

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < k; i++) {
			maxHeap.add(Integer.parseInt(st.nextToken()));
		}
		int x;

		for (int i = k; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			if (maxHeap.peek() <= x) {
				continue;
			}
			maxHeap.poll();
			maxHeap.add(x);
		}

		System.out.println(maxHeap.peek());
	}
}