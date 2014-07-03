package com.wf.controller.student.internal;

import com.wf.controller.base.AbstractController;
import com.wf.controller.base.exceptions.DAONotAvaliableException;
import com.wf.controller.student.IStudentController;
import com.wf.dao.student.IStudentDao;
import com.wf.model.Student;

public class StudentController extends AbstractController<IStudentDao, Student> implements IStudentController {

	public StudentController() {
		super();
	}

	@Override
	public Student getStudent(Long id) throws DAONotAvaliableException {
		if (this.getDao() != null) {
			return this.getDao().getById(id);
		}
		
		throw new DAONotAvaliableException(IStudentDao.class.getSimpleName() + " is not avaliable");
	}
	
}
