package com.wf.controller.core.internals;

import com.wf.controller.base.AbstractController;
import com.wf.controller.core.ICoreEntityController;
import com.wf.dao.core.ICoreEntityDao;
import com.wf.model.CoreEntity;


public class CoreEntityController extends AbstractController<ICoreEntityDao, CoreEntity> implements ICoreEntityController {

	public CoreEntityController() {
		super();
	}

}
