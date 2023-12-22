import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		StringBuffer result = new StringBuffer();
		StringBuffer temp = new StringBuffer();
				
		while(str.length() != 0) {
			
			if(str.charAt(0) == '<') {
				if(temp.length() > 0) {
					result.append(temp.reverse());
					temp = new StringBuffer();
				}
				int index = str.indexOf('>');
				result.append(str.substring(0, index+1));
				str = str.substring(index+1);
			}
			else if(str.charAt(0) == ' ') {
				if(temp.length() > 0) {
					result.append(temp.reverse());
					temp = new StringBuffer();
				}
				result = result.append(' ');
				str = str.substring(1);
			}
			else {
				temp.append(str.charAt(0));
				str = str.substring(1);
			}
		}
        
        if(temp.length() > 0) {
			result.append(temp.reverse());
			temp = new StringBuffer();
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}