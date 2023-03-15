import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] S, B;
	static long result;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		S = new int[N];
		B = new int[N];
		isSelected = new boolean[N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		result = Math.abs(S[0]-B[0]);
		subset(0);
		System.out.println(result);
	}
	private static void subset(int cnt) {
		if(cnt == N) {
			int S_multi = 1; //신 곱 초기화
			int B_sum = 0; //쓴 합 초기화
			int selectCnt = 0; //재료를 적어도 하나를 선택해야해서
			for(int i =0;i<N;i++) {
				if(isSelected[i]) { //선택되면
					S_multi *= S[i];
					B_sum += B[i];
					selectCnt++;
				}
			}

			if(selectCnt>0&&Math.abs(S_multi-B_sum)<result) result = Math.abs(S_multi-B_sum);
			return;
		}
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] =false;
		subset(cnt+1);
	}
}
