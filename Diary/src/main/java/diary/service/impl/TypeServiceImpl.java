package diary.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.dao.BaseDao;
import diary.model.Ttype;
import diary.model.Tuser;
import diary.pagemodel.Type;
import diary.service.TypeServiceI;

@Service(TypeServiceI.TYPE_SERVICE_NAME)
public class TypeServiceImpl implements TypeServiceI {

	@Autowired
	private BaseDao<Ttype> typedao;

	@Autowired
	private BaseDao<Tuser> userdao;

	public void addType(Type d) {
		Map<String, Object> m = new HashMap<String, Object>();
		Ttype tt = new Ttype();

		// 得到用户信息
		m.put("id", d.getUid());
		Tuser uesr = userdao.getByHql("from Tuser u where u.userId=:id", m);

		BeanUtils.copyProperties(d, tt, new String[] { "id" });
		// 将用户的信息存入到日记类型当中；
		tt.setTuser(uesr);

		tt.setDiaryTypeId(UUID.randomUUID().toString());
		typedao.save(tt);
	}

	public void delete(Ttype d) {
		typedao.delete(d);

	}

	public void updateDiary(Type d) {
		typedao.update(null);

	}

	public List<Type> list(String uid) {
		Map<String, Object> m = new HashMap<String, Object>();
		List<Type> listtype = new ArrayList<Type>();
		m.put("uid", uid);
		List<Ttype> list = typedao.find("from Ttype t where t.tuser.userId=:uid",m);
		for (Ttype ttype : list) {
			Type type = new Type();
			type.setId(ttype.getDiaryTypeId());
			//判断是否为父节点
			if(ttype.getTtype()!=null){
				type.setTid(ttype.getTtype().getDiaryTypeId());
			}
			type.setUid(ttype.getTuser().getUserId());
			BeanUtils.copyProperties(ttype, type);
			listtype.add(type);
		}
		return listtype;
	}

}
