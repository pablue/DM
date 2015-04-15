package diary.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.dao.BaseDao;
import diary.model.Tuser;
import diary.pagemodel.User;
import diary.service.UserServiceI;
import diary.utils.Encrypt;

@Service(UserServiceI.USER_SERVICE_NAME)
public class UserServiceImpl implements UserServiceI {

	private static final Logger logger = Logger.getLogger(UserServiceI.class);

	
	private BaseDao<Tuser> userdao;
	

	public BaseDao<Tuser> getUserdao() {
		return userdao;
	}
	@Autowired
	public void setUserdao(BaseDao<Tuser> userdao) {
		this.userdao = userdao;
	}

	public void test() {
		logger.info("sssssssss");
		List<Tuser> find = userdao.find("from TUser",2,10);
		for (Tuser tUser : find) {
			System.out.println(tUser.getUserName());
		}
	}

	public void save(User t) {
		Tuser user = new Tuser();
		BeanUtils.copyProperties(t, user);
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(Encrypt.e(t.getPassword()));
		userdao.save(user);
	}

	public User login(User user) {
		//将参数传递给HQL语句
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("username", user.getUserName());
		params.put("password", Encrypt.e(user.getPassword()));
		Tuser tuser = userdao.getByHql("from Tuser t where t.userName=:username and t.password=:password",params);
		
		if(tuser!=null){
			//将查询出来的用户信息返回，并剔除所有的日记信息
			BeanUtils.copyProperties(tuser, user,new String[]{"tdiaries"});
			return user;
		}
		return null;
	}

}
