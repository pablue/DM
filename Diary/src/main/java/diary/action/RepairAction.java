package diary.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;

import diary.action.base.BaseAction;

@Action(value = "repair")
public class RepairAction extends BaseAction {

	private static final long serialVersionUID = -1290412684168258940L;
	
	private static final Logger LOGGER = Logger.getLogger(RepairAction.class);

	public void reset() {
		try {
			this.repairServiceI.repair();
			LOGGER.info("数据库修复成功");
		} catch (Exception e) {
			LOGGER.error("数据库修复失败");
			e.printStackTrace();
		}
	}

}
