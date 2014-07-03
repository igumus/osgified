package com.wf.dao.student.internals;

import java.util.LinkedList;
import java.util.List;

import com.wf.dao.base.AbstractJPADao;
import com.wf.dao.student.IStudentDao;
import com.wf.model.Student;

public class StudentJPADao extends AbstractJPADao<Student> implements IStudentDao{

	@Override
	public Student getById(Long id) {
		Student student = new Student();
		student.setId(id);
		return student;
	}

	@Override
	public void saveOrUpdate(Student entity) {
		System.out.println(entity.getId() + " saveOrUpdated");
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = new LinkedList<Student>();
		list.add(getById(1l));
		list.add(getById(2l));
		return list;
	}

	@Override
	public Student findByStudentNo(String studentNo) {
		Student student = new Student();
		student.setId(1l);
		student.setStudentNo(studentNo);
		return student;
	}

}
