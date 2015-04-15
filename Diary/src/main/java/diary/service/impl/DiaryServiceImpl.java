package diary.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.dao.BaseDao;
import diary.model.Tdiary;
import diary.model.Tuser;
import diary.pagemodel.Diary;
import diary.service.DiaryServiceI;


@Service(DiaryServiceI.DIARY_SERVICE_NAME)
public class DiaryServiceImpl implements DiaryServiceI {
	
	@Autowired
	private BaseDao<Tdiary> diarydao;
	
	@Autowired
	private BaseDao<Tuser> userdao;

	public void addDiary(Diary d) {
		
		Tdiary t = new Tdiary();
		
		try{
			String uid = d.getUid();
			Tuser user = userdao.getById(Tuser.class, uid);
			BeanUtils.copyProperties(d, t,new String[]{});
			t.setTuser(user);
			this.diarydao.save(t);
		}catch(Exception e){
			
			
		}
		
	}

	public void updateDiary(Tdiary d) {
		
	}

	public List<Diary> list(String uid,int page ,int rows) {
		Map<String,Object> m  = new HashMap<String,Object>();
		List<Diary> diarylist = new ArrayList<Diary>();
		
		Diary diary = new Diary();
		m.put("uid", uid);
		List<Tdiary> tdiarylist = diarydao.find("from Tdiary d where d.tuser.userId=:uid", m, page, rows);
		for (Tdiary tdiary : tdiarylist) {
			
			BeanUtils.copyProperties(tdiary, diary,new String[]{"ttype","tuser"});
			diary.setUid(tdiary.getTuser().getUserId());
			diary.setTid(tdiary.getTtype().getDiaryTypeId());
			diarylist.add(diary);
		}
		
		return diarylist;
	}

	public void delete(Tdiary d) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
