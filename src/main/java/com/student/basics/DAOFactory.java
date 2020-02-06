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
public static CourseDAO getCourseDAO() {
	CourseDAO  courseDAO = new CourseImplements();
	return courseDAO;
}
public static BatchDAO getBatchDAO() {
	BatchDAO  batchDAO = new BatchImplements();
	return batchDAO;
}
public static StudentDAO getStudentDAO() {
	StudentDAO  studentDAO = new StudentImplementation();
	return studentDAO;
}
public static PaymentDAO getPaymentDAO() {
	PaymentDAO  paymentDAO = new PaymentImplements();
	return paymentDAO;
}
}
