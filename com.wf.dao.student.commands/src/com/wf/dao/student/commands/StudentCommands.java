package com.wf.dao.student.commands;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import com.wf.dao.base.exceptions.SessionFactoryNotAvaliableException;
import com.wf.dao.student.IStudentDao;
import com.wf.model.Student;

public class StudentCommands implements CommandProvider {

	private IStudentDao dao = null;

	public IStudentDao getDao() {
		return dao;
	}

	public void setDao(IStudentDao dao) {
		this.dao = dao;
		System.out.println(IStudentDao.class.getSimpleName() + " has just registered to " + this.getClass().getSimpleName());
	}

	@Override
	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("--- DAO Student Commands---\n\t");
		buffer.append("getStudent    - Gets Student with given id\n\t");
		buffer.append("deleteStudent - Deletes Student with given id\n");
		return buffer.toString();
	}

	private String usageGetStudent() {
		return "getStudent <id (must be number)>";
	}

	private String usageDeleteStudent() {
		return "deleteStudent <id (must be number)>";
	}

	private void printServiceError(CommandInterpreter ci) {
		ci.println(IStudentDao.class.getSimpleName() + " is not avaiable now");
	}
	
	public void _getStudent(CommandInterpreter ci) {
		String argument = ci.nextArgument();
		if (argument != null) {
			long studentId = Long.parseLong(argument);
			if (this.dao != null) {
				Student student = dao.getById(studentId);
				ci.println("Found : " + student.toString());
			} else {
				printServiceError(ci);
			}
		} else {
			ci.println(usageGetStudent());
		}
	}
	
	public void _deleteStudent(CommandInterpreter ci) throws SessionFactoryNotAvaliableException, Exception {
		String argument = ci.nextArgument();
		if (argument != null) {
			long studentId = Long.parseLong(argument);
			if (this.dao != null) {
				Student student = dao.getById(studentId);
				ci.println("Found : " + student.toString() + " and its going to be deleted");
				student.setStatus(Boolean.FALSE);
				this.dao.save(student);
			} else {
				printServiceError(ci);
			}
		} else {
			ci.println(usageDeleteStudent());
		}
	}
	

}
