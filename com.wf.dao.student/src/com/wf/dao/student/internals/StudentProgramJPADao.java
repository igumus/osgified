package com.wf.dao.student.internals;

import java.util.LinkedList;
import java.util.List;

import com.wf.dao.base.AbstractJPADao;
import com.wf.dao.student.IStudentProgramDao;
import com.wf.model.StudentProgram;

public class StudentProgramJPADao extends AbstractJPADao<StudentProgram> implements IStudentProgramDao {

	@Override
	public StudentProgram getById(Long id) {
		StudentProgram studentProgram = new StudentProgram();
		studentProgram.setId(id);
		return studentProgram;
	}

	@Override
	public void saveOrUpdate(StudentProgram entity) {
		System.out.println(entity.getId() + " saveOrUpdated");
	}

	@Override
	public List<StudentProgram> findAll() {
		List<StudentProgram> list = new LinkedList<StudentProgram>();

		list.add(getById(1l));
		list.add(getById(2l));

		return list;
	}

}
