package Mission;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _14 {
	public static void main(String[] args){
		String line;
		String arr[];
		try {
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("입출력 관련 에러가 발생했습니다.");
		}
	}
}
