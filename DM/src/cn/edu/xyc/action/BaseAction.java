package cn.edu.xyc.action;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import cn.edu.xyc.dm.service.CourseService;
import cn.edu.xyc.dm.service.TeacherService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private Class classt;
	private T t;

	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType type = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			this.classt = (Class) type.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			this.t = (T) this.classt.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return this.t;
	}

	// =============== Service实例的声明 ==================

	// 调用Service层的方法
	@Resource(name = "teacherService")
	protected TeacherService teacherService;

	@Resource(name = "courseService")
	protected CourseService courseService;
}
