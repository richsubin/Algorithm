import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		int[] Rest = new int[42];
		int count = 0;
		for(int i=0;i<10;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			int n = arr[i] % 42;
			if(Rest[n]==0) {
				Rest[n]++;
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}