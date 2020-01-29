package manage.Course;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.StudentManagement2.Course.CourseClass;
import com.StudentManagement2.Course.CourseImplements;

public class TestExportProject {

	public static void main(String[] args) throws Exception {
		CourseImplements c4 = new CourseImplements();
		List<CourseClass> list =c4.orderByCourseName();
		String fileContent = "";
		//StringBuilder fileContent = new StringBuilder();
		for(CourseClass p : list) {
			String line = p.getCourseName() +","+p.getCourseCode();
			//fileContent.append(p.projectName).append(",")
			//System.out.println(line);
			fileContent = fileContent +line+"\n";
		}
		System.out.println(fileContent);
		
		Path path = Paths.get("D:\\projects_export.txt");
		Files.write(path,fileContent.getBytes()); //overwrite file contents
		//Files.write(path,fileContent.getBytes(),StandardOpenOption.APPEND);
		

	}

}
