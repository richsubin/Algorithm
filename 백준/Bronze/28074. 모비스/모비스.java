import java.io.*;
import java.util.*;

	
class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] mobis = {"M","O","B","I","S"};
		String result = "YES";
		for(int i=0;i<5;i++) {
			if(!str.contains(mobis[i])) {
				result = "NO";
				break;
			}
		}
		System.out.print(result);
	}
}