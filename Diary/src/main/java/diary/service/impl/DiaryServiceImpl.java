package diary.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diary.dao.BaseDao;
import diary.model.Tdiary;
import diary.model.Ttype;
import diary.model.Tuser;
import diary.pagemodel.Diary;
import diary.service.DiaryServiceI;


@Service(DiaryServiceI.DIARY_SERVICE_NAME)
public class DiaryServiceImpl implements DiaryServiceI {
	
	@Autowired
	private BaseDao<Tdiary> diarydao;
	
	@Autowired
	private BaseDao<Tuser> userdao;
	
	@Autowired
	private BaseDao<Ttype> typedao;

	public void addDiary(Diary d) {
		
		Tdiary t = new Tdiary();
		
		try{
			String uid = d.getUid();
			Tuser user = userdao.getById(Tuser.class, uid);
			Ttype ttype = typedao.getById(Ttype.class, d.getTid());
			
			BeanUtils.copyProperties(d, t);
			t.setTuser(user);
			t.setTtype(ttype);
			t.setReleaseDate(new Date());
			t.setDiaryId(UUID.randomUUID().toString());
			this.diarydao.save(t);
		}catch(Exception e){
			
			
		}
		
	}

	public void updateDiary(Tdiary d) {
		
	}

	public List<Diary> list(String uid,int page ,int rows) {
		Map<String,Object> m  = new HashMap<String,Object>();
		List<Diary> diarylist = new ArrayList<Diary>();
		
		m.put("uid", uid);
		List<Tdiary> tdiarylist = diarydao.find("from Tdiary d where d.tuser.userId=:uid order by d.releaseDate desc", m, page, rows);
		for (Tdiary tdiary : tdiarylist) {
			Diary diary = new Diary();
			
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
