import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		
		int[] A = new int[46];
		int[] B = new int[46];
		A[0] = 1;
		A[1] = 0;
		B[0] = 0;
		B[1] = 1;
		
		for(int i=2;i<=K;i++) {
			A[i] = A[i-1] + A[i-2];
			B[i] = B[i-1] + B[i-2];
		}
		
		bw.write(A[K] + " " + B[K]);
		bw.flush();
		bw.close();
	}
}