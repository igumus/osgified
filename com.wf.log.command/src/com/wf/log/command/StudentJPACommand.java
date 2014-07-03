package com.wf.log.command;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import com.wf.dao.base.exceptions.SessionFactoryNotAvaliableException;
import com.wf.dao.student.IStudentDao;
import com.wf.model.Student;

public class StudentJPACommand implements CommandProvider {

	private IStudentDao studentDao;
	
	public void _getStudent(CommandInterpreter ci) {
		String argument = ci.nextArgument();
		if (argument != null) {
			long studentId = Long.parseLong(argument);
			if (studentDao != null) {
				Student student = studentDao.getById(studentId);
				ci.println("Found : " + student.toString());
			} else {
				ci.println("StudentJPA service not avaiable now");
			}
		} else {
			ci.println(getCommandGetStudentUsage());
		}
	}

	public void _saveStudent(CommandInterpreter ci) {
		String argument = ci.nextArgument();
		if (argument != null) {
			long studentId = Long.parseLong(argument);
			Student student = new Student();
			student.setId(studentId);
			if (studentDao != null) {
				try {
					studentDao.saveOrUpdate(student);
				} catch (SessionFactoryNotAvaliableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				ci.println("StudentJPA service not avaiable now");
			}

		} else {
			ci.println(getUsage());
		}
	}

	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("---My JPA commands---\n\t");
		buffer.append("saveStudent - Saves student with according id\n\t");
		buffer.append("getStudent - Gets student with given id\n");
		return buffer.toString();
	}

	private String getUsage() {
		return "saveStudent studentId";
	}
	
	private String getCommandGetStudentUsage() {
		return "getStudent studentid";
	}

	public void setStudentDao(IStudentDao studentDao) {

		this.studentDao = studentDao;
		System.out.println("Student dao has just registered");
	}
	
	public void unsetStudentDao(IStudentDao studentDao) {
		this.studentDao = null;
	}
}
