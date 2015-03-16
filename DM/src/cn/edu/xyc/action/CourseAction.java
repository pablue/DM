package cn.edu.xyc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.xyc.dm.model.Banji;
import cn.edu.xyc.dm.model.Course;
import cn.edu.xyc.dm.model.Teacher;

@Scope("prototype")
@Controller("courseAction")
public class CourseAction extends BaseAction<Course> {
	
	private String cid;

	private static final long serialVersionUID = -1308875327958511472L;

	public void getcoursebytid() throws IOException {
		Teacher teacher = (Teacher) ServletActionContext.getRequest()
				.getSession().getAttribute("teacher");
		int tid = (int) teacher.getTid();
		
		Collection<Course> Courses = this.courseService.getcoursebytid(tid);
		for (Course c : Courses) {
			System.out.println(c.getCid() + c.getCname());
		}

		// -----------------------------------------------
		HttpServletResponse response = ServletActionContext.getResponse();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONArray arr = JSONArray.fromObject(Courses);
		out.print(arr);
		System.out.println(arr);
	}
	
	
	public void getbanjibycidandtid() throws IOException{
		System.out.println("执行 getbanjibycidandtid");
		System.out.println(this.cid);
		Teacher teacher = (Teacher) ServletActionContext.getRequest()
				.getSession().getAttribute("teacher");
		int tid = (int) teacher.getTid();
	
		 String cidstring = ServletActionContext.getRequest().getParameter("cid");
		 System.out.println(cidstring);
		@SuppressWarnings("unchecked")
		List<Banji> listbanji = this.courseService.getbanji(tid,Integer.parseInt(cidstring));
		
		for (Banji banji : listbanji) {
			System.out.println(banji.getBid()+"----"+banji.getBname());
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONArray arr = JSONArray.fromObject(listbanji);
		out.print(arr);
		System.out.println(arr);
		
	}


	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}




}
