package com.yash.students.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yash.students.dao.ClasssDao;
import com.yash.students.dao.ResultDao;
import com.yash.students.dao.StudentDao;
import com.yash.students.entity.Classs;
import com.yash.students.entity.Result;
import com.yash.students.entity.Student;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yash/students/applicationContext.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		ClasssDao classDao = context.getBean("classDao", ClasssDao.class);
		ResultDao resultDao = context.getBean("resultDao", ResultDao.class);

		List<Result> results = resultDao.getAllResult();
		List<Result> resultAbsentInOneExam = resultDao.getResultAbsentInOneExam();
		
		System.out.println("Student who are absent in one or more exam");
		for (Result result : resultAbsentInOneExam) {
			System.out.println(studentDao.getStudentById(result.getSid()));
		}

		System.out.println("***********************************************************");
		System.out.println("students who score more than 75%");
		

		for (Result result : results) {
			double percentage, totalMarks;
			totalMarks = result.getMaths() + result.getEnglish() + result.getHindi() + result.getScience()
					+ result.getSanskrit();
			percentage = (totalMarks / 500) * 100;
			if (percentage >= 75) {
				System.out.println(studentDao.getStudentById(result.getSid()) + " percentage=" + percentage);
			}
		}
		System.out.println("***********************************************************");
		System.out.println("students who fail to score passing marks");
		
		int count = 0;
		for (Result result : results) {

			double percentage, totalMarks;
			totalMarks = result.getMaths() + result.getEnglish() + result.getHindi() + result.getScience()
					+ result.getSanskrit();
			percentage = (totalMarks / 500) * 100;
			if (percentage < 40) {
				System.out.println(studentDao.getStudentById(result.getSid()));
				count++;
			}

		}
		System.out.println("Total number of students to fail : " + count);
		
		System.out.println("***********************************************************");
		
		
		System.out.println("Average marks of each class per section.");
		
		List<Classs> listOfAllClasses = classDao.getAllClassIds();
		for (Classs cls : listOfAllClasses) {
			List<Result> resultByClassId=resultDao.getResultByClassId(cls.getClassId());
			System.out.println("Class : "+cls.getClassName()+" Section : "+cls.getSection());
			List<Double> totalMarks=new ArrayList<Double>();
			for(Result result:resultByClassId)
			{
				totalMarks.add(result.getEnglish()+result.getHindi()+result.getMaths()+result.getSanskrit()+result.getScience());
			}
			System.out.println("Average Marks : "+totalMarks.stream().collect(Collectors.averagingDouble(e->e)));
			
		}
		System.out.println("***********************************************************");
		
		
		System.out.println("Average marks of each class");
		
		List<Classs> classnames=classDao.getAllClassName();
		for(Classs classname:classnames)
		{
			List<Result> resultByClassName=resultDao.getResultByClassName(classname.getClassName());
			System.out.println("Class : "+classname.getClassName());
			List<Double> totalMarks=new ArrayList<Double>();
			int temp=0;
			for(Result result:resultByClassName)
			{
				totalMarks.add(result.getEnglish()+result.getHindi()+result.getMaths()+result.getSanskrit()+result.getScience());
				temp++;
			}
			System.out.println("Average Marks : "+totalMarks.stream().collect(Collectors.averagingDouble(e->e)));
			
		}
		System.out.println("***********************************************************");
		
		
		System.out.println("average marks of each subject per section");
		for (Classs cls : listOfAllClasses) {
			System.out.println("ClassName : "+cls.getClassName()+" Section : "+cls.getSection());
			double averageOfMaths=resultDao.getAverageOfEachSubject(cls.getClassId(),"maths");
			System.out.println("Average Of Maths Subject"+averageOfMaths);
			double averageOfHindi=resultDao.getAverageOfEachSubject(cls.getClassId(),"hindi");
			System.out.println("Average Of Hindi Subject"+averageOfHindi);
			double averageOfEnglish=resultDao.getAverageOfEachSubject(cls.getClassId(),"english");
			System.out.println("Average Of English Subject"+averageOfEnglish);
			double averageOfScience=resultDao.getAverageOfEachSubject(cls.getClassId(),"science");
			System.out.println("Average Of Science Subject"+averageOfScience);
			double averageOfSanskrit=resultDao.getAverageOfEachSubject(cls.getClassId(),"sanskrit");
			System.out.println("Average Of Sanskrit Subject"+averageOfSanskrit);
			System.out.println();
		}
		System.out.println("***********************************************************");
		System.out.println("average marks of each subject per class");
		for(Classs classname:classnames)
		{
			System.out.println("Class : "+classname.getClassName());
			double averageOfMaths=resultDao.getAverageOfEachSubjectPerClass(classname.getClassName(),"maths");
			System.out.println("Average Of Maths Subject"+averageOfMaths);
			double averageOfHindi=resultDao.getAverageOfEachSubjectPerClass(classname.getClassName(),"hindi");
			System.out.println("Average Of Hindi Subject"+averageOfHindi);
			double averageOfEnglish=resultDao.getAverageOfEachSubjectPerClass(classname.getClassName(),"english");
			System.out.println("Average Of English Subject"+averageOfEnglish);
			double averageOfScience=resultDao.getAverageOfEachSubjectPerClass(classname.getClassName(),"science");
			System.out.println("Average Of Science Subject"+averageOfScience);
			double averageOfSanskrit=resultDao.getAverageOfEachSubjectPerClass(classname.getClassName(),"sanskrit");
			System.out.println("Average Of Sasnkrit Subject"+averageOfSanskrit);
			System.out.println();
		}
		
		
	}
}
