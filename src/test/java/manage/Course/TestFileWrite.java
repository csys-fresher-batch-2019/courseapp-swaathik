package manage.Course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestFileWrite {

	public static void main(String[] args) throws IOException {
		FileUtil.writeToFile("employees.txt","Python,879");
		
		//File Read
		String fileName = "employees.txt";
		Path path = Paths.get(fileName);
		
		//Read All Bytes - Read entire file
		byte[] bytes = Files.readAllBytes(path);
		String content = new String(bytes);
		System.out.println(content);
		
		//Read Lines
		System.out.println("Read Lines");
   List<String> readAllLines = Files.readAllLines(path);
		for(String line : readAllLines) {
			System.out.println(line);
		}

}

}
