package Mission;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _14 {
	public static void main(String[] args){
		String line;
		String arr[][] = new String[10][4];
		String temp[] = new String[4];
		try {
			BufferedReader br = new BufferedReader(new FileReader("student.txt"));
			System.out.println("번호	이름	성적	반");
				for (int i = 0; i < arr.length; i++) {
					line = br.readLine();
					if(line == null)
						break;
					arr[i] = line.split("/");
				}
			for (int i = 0; i < arr.length-1; i++) {
				for (int j = 0; j < arr.length-1; j++) {
					if(Integer.parseInt(arr[j][2]) < Integer.parseInt(arr[j+1][2]))
					{
						temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			for (String[] list : arr) {
				for (String i : list) {
				System.out.print(i+"	");
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
