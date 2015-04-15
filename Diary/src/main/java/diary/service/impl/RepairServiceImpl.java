package diary.service.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.dao.BaseDao;
import diary.model.Ttype;
import diary.model.Tuser;
import diary.service.RepairServiceI;
import diary.utils.Encrypt;

@Service(RepairServiceI.REPAIR_SERVICE_NAME)
public class RepairServiceImpl implements RepairServiceI {

	private static final Logger LOGGER = Logger.getLogger(RepairServiceImpl.class);

	@Autowired
	private BaseDao<Ttype> typedao;

	@Autowired
	private BaseDao<Tuser> userdao;

	public void repair() {
		try {
			repairtype();
			LOGGER.info("日记类型修复成功");
		} catch (Exception e) {
			LOGGER.info("日记类型修复失败");
		}
	}

	public void repairtype() {
		Ttype root = new Ttype();
		root.setDiaryTypeId("root");
		root.setTypeName("我的日记本");
		typedao.saveOrUpdate(root);

		Ttype shenghuo = new Ttype();
		shenghuo.setDiaryTypeId("shenghuo");
		shenghuo.setTypeName("生活");
		shenghuo.setTtype(root);
		typedao.saveOrUpdate(shenghuo);

		Ttype yule = new Ttype();
		yule.setDiaryTypeId("yule");
		yule.setTypeName("娱乐");
		yule.setTtype(root);
		typedao.saveOrUpdate(yule);

		Ttype qinggan = new Ttype();
		qinggan.setDiaryTypeId("qinggan");
		qinggan.setTypeName("情感");
		qinggan.setTtype(root);
		typedao.saveOrUpdate(qinggan);
	}

	public void repairuser() {
		Tuser user = new Tuser();
		user.setUserName("admin");
		user.setUserId("0");
		user.setPassword(Encrypt.e("admin"));
		userdao.saveOrUpdate(user);

	}

}
