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
import diary.pagemodel.Page;
import diary.service.DiaryServiceI;
import diary.utils.ConstantUtils;
import diary.utils.GenerateHTML;

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

		try {
			String uid = d.getUid();
			Tuser user = userdao.getById(Tuser.class, uid);
			Ttype ttype = typedao.getById(Ttype.class, d.getTid());

			BeanUtils.copyProperties(d, t);
			t.setTuser(user);
			t.setTtype(ttype);
			t.setReleaseDate(new Date());
			t.setDiaryId(UUID.randomUUID().toString());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("diary", t);
			String path = GenerateHTML.generation(map,ConstantUtils.DIARYFTL);
			t.setFilepath(path);

			this.diarydao.save(t);
		} catch (Exception e) {
		}

	}

	public void updateDiary(Tdiary d) {

	}

	public Page<Diary> list(String uid, int current, int rows) {

		Map<String, Object> m = new HashMap<String, Object>();

		// 静态化代码
		Map<String, Object> map = new HashMap<String, Object>();

		List<Diary> diarylist = new ArrayList<Diary>();
		m.put("uid", uid);

		// 根据用户查询出所有的日记
		String HQL = "from Tdiary d where d.tuser.userId=:uid order by d.releaseDate desc";
		int count = diarydao.count(HQL, m);

		// 对Page对象初始化
		Page<Diary> page = new Page<Diary>(current, count);
		page.setPagesize(rows);

		List<Tdiary> tdiarylist = diarydao.find(HQL, m, page.getCurrent(), page.getPagesize());

		for (Tdiary tdiary : tdiarylist) {
			Diary diary = new Diary();
			BeanUtils.copyProperties(tdiary, diary, new String[] { "ttype", "tuser" });
			diary.setUid(tdiary.getTuser().getUserId());
			diary.setTid(tdiary.getTtype().getDiaryTypeId());
			diarylist.add(diary);
		}

		map.put("diary", diarylist);
		/************************* S无关代码 ************************/

		//GenerateHTML.generation(map,ConstantUtils.ShowDiaryList);

		/************************* E无关代码 ************************/

		page.setList(diarylist);

		return page;
	}

	public void delete(Tdiary d) {

	}

	public Diary showdiary(String did) {
		Diary diary = new Diary();
		Tdiary tdiary = this.diarydao.getById(Tdiary.class, did);
		BeanUtils.copyProperties(tdiary, diary);
		diary.setUid(tdiary.getTuser().getUserId());

		Map<String, Object> map = new HashMap<String, Object>();

		return diary;
	}

}
