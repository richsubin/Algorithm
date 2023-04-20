import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		boolean check = false;
		for(int i=N-1;i>=0;i--) {
			if(Arrays.equals(A, B)) {
				check = true;
				break;
			}
			int last = i;
			for(int j=0;j<i;j++) {
				if(A[last] < A[j]) last = j;
			}
			int temp = A[last];
			A[last] = A[i];
			A[i] = temp;
			
		}
		if(check) bw.write("1");
		else bw.write("0");
		bw.flush();
		bw.close();
		br.close();
	}
}