package Mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _14 {
	public static void main(String[] args) throws IOException {
		String line;
		String arr[];
		BufferedReader br = new BufferedReader(new FileReader("C:\\MSA9\\student.txt"));
		System.out.println("번호		이름		성적		반");
		while(true) {
			line = br.readLine();
			if(line == null)
				break;
			arr = line.split("/");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "		");
			}
			System.out.println();
		}
		br.close();
	}
}
