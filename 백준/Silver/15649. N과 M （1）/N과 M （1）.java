import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		sb = new StringBuilder("");
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		numbers = new int[M];
		isSelected = new boolean[N+1];
		
		perm(0);
	}
	
	private static void perm(int cnt) {
		if(cnt == M) {
			for(int i=0;i<cnt;i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int card = 1;card<=N;card++) {
			if(isSelected[card]) continue;
			numbers[cnt] = card;
			isSelected[card] = true;
			perm(cnt+1);
			isSelected[card] = false;
		}
	}

}