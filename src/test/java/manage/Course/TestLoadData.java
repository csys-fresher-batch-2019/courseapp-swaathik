package manage.Course;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.student.course.CourseClass;
import com.student.course.CourseImplements;

public class TestLoadData {

	public static void main(String[] args) throws Exception {
		String fileName = "employees.txt";
		Path path = Paths.get(fileName);
		List<String>lines = Files.readAllLines(path);
		for(String line:lines) {
			System.out.println(line);
			String[] row = line.split(",");
			
			String courseName = row[0];
			int courseCode = Integer.parseInt(row[1]);
			CourseClass course = new CourseClass();
			course.setCourseName(courseName);
			course.setCourseCode(courseCode);
			System.out.println(course);
			CourseImplements daoimpl1 = new CourseImplements();
			daoimpl1.addCourses(course);
		}
		
	}

}
