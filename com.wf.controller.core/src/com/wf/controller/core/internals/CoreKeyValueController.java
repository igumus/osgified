package com.wf.controller.core.internals;

import com.wf.controller.base.AbstractController;
import com.wf.controller.core.ICoreKeyValueController;
import com.wf.dao.core.ICoreKeyValueDao;
import com.wf.model.CoreKeyValue;

public class CoreKeyValueController extends AbstractController<ICoreKeyValueDao, CoreKeyValue> implements ICoreKeyValueController {

	public CoreKeyValueController() {
		super();
	}
	
}
