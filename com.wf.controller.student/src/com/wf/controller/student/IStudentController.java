package com.wf.controller.student;

import com.wf.controller.base.IController;
import com.wf.controller.base.exceptions.DAONotAvaliableException;
import com.wf.dao.student.IStudentDao;
import com.wf.model.Student;

public interface IStudentController extends IController<IStudentDao, Student> {

	public Student getStudent(Long id) throws DAONotAvaliableException;
	
}
