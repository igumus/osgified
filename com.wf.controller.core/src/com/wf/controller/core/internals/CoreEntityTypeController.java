package com.wf.controller.core.internals;

import com.wf.controller.base.AbstractController;
import com.wf.controller.core.ICoreEntityTypeController;
import com.wf.dao.core.ICoreEntityTypeDao;
import com.wf.model.CoreEntityType;

public class CoreEntityTypeController extends AbstractController<ICoreEntityTypeDao, CoreEntityType> implements ICoreEntityTypeController {

	public CoreEntityTypeController() {
		super();
	}
	
}
