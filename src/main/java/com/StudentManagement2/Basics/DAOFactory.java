package com.StudentManagement2.Basics;

import com.StudentManagement2.Batch.BatchDAO;
import com.StudentManagement2.Batch.BatchImplements;
import com.StudentManagement2.Course.CourseDAO;
import com.StudentManagement2.Course.CourseImplements;
import com.StudentManagement2.Payment.PaymentDAO;
import com.StudentManagement2.Payment.PaymentImplements;
import com.StudentManagement2.Student.StudentDAO;
import com.StudentManagement2.Student.StudentImplements;

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
	StudentDAO  studentDAO = new StudentImplements();
	return studentDAO;
}
public static PaymentDAO getPaymentDAO() {
	PaymentDAO  paymentDAO = new PaymentImplements();
	return paymentDAO;
}
}
