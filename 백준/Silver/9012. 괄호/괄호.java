import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            sb.append(check(str) + "\n");
        }
        bw.write(sb+"");
        bw.flush();
        bw.close();
        br.close();
    }
        public static String check(String str){
            Stack<Character> stack = new Stack<Character>();

                for(int j = 0;j<str.length();j++){
                    char c = str.charAt(j);
                    if(c=='('){
                        stack.push(c);
                    }
                    else{
                        if(stack.isEmpty()) {
                            return "NO";
                        }
                        else stack.pop();
                    }
                }
            if(stack.isEmpty()){
                return "YES";
            }
            else{
                return "NO";
            }
        }
    }