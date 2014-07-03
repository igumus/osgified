package com.wf.dao.student;

import com.wf.dao.base.IDao;
import com.wf.model.Student;

public interface IStudentDao extends IDao<Student>{

	Student findByStudentNo(String studentNo);
	
}
