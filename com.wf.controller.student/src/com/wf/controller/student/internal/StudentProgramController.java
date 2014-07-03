package com.wf.controller.student.internal;

import com.wf.controller.base.AbstractController;
import com.wf.controller.student.IStudentProgramController;
import com.wf.dao.student.IStudentProgramDao;
import com.wf.model.StudentProgram;

public class StudentProgramController extends AbstractController<IStudentProgramDao, StudentProgram> implements IStudentProgramController {

	public StudentProgramController() {
		super();
	}
	
}
