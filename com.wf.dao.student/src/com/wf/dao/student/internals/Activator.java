package com.wf.dao.student.internals;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.wf.dao.student.IStudentDao;
import com.wf.dao.student.IStudentProgramDao;

public class Activator implements BundleActivator {

	private static BundleContext context;

	private ServiceRegistration<IStudentDao> studentDaoServiceRegistration = null;
	private ServiceRegistration<IStudentProgramDao> studentProgramDaoServiceRegistration = null;

	static BundleContext getContext() {
		return context;
	}

	@SuppressWarnings("unchecked")
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		studentDaoServiceRegistration = (ServiceRegistration<IStudentDao>) context.registerService(IStudentDao.class.getName(), new StudentJPADao(), null);
		studentProgramDaoServiceRegistration = (ServiceRegistration<IStudentProgramDao>) context.registerService(IStudentProgramDao.class.getName(), new StudentProgramJPADao(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		if (studentDaoServiceRegistration != null) {
			studentDaoServiceRegistration.unregister();
			studentDaoServiceRegistration = null;
		}
		if (studentProgramDaoServiceRegistration != null) {
			studentProgramDaoServiceRegistration.unregister();
			studentProgramDaoServiceRegistration = null;
		}
	}

}
