package com.student.basics;

import com.student.batch.BatchDAO;
import com.student.batch.BatchImplements;
import com.student.course.CourseDAO;
import com.student.course.CourseImplements;
import com.student.payment.PaymentDAO;
import com.student.payment.PaymentImplements;
import com.student.student.StudentDAO;
import com.student.student.StudentImplementation;

public class DAOFactory {
	private DAOFactory() {
	    throw new IllegalStateException("Utility class");
	  }

public static CourseDAO getCourseDAO() {
	return new CourseImplements();
}
public static BatchDAO getBatchDAO() {
	return new BatchImplements();
}
public static StudentDAO getStudentDAO() { 
	return new StudentImplementation();
}
public static PaymentDAO getPaymentDAO() {
	return  new PaymentImplements();
}
}
