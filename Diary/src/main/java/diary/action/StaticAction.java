package diary.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import diary.action.base.BaseAction;
import diary.pagemodel.Diary;
import diary.pagemodel.Page;
import diary.pagemodel.User;
import diary.utils.ConstantUtils;
import diary.utils.GenerateHTML;

@Action(value = "staticAction")
public class StaticAction extends BaseAction {

	public void test() {
		System.out.println("我出来了");
	}

}
