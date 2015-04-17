package diary.service;

import java.util.List;

import diary.model.Tdiary;
import diary.pagemodel.Diary;
import diary.pagemodel.Page;

public interface DiaryServiceI {
	
	public static final String DIARY_SERVICE_NAME="diaryService";
	
	public void addDiary(Diary d);
	
	
	public void delete(Tdiary d);
	
	public void updateDiary(Tdiary d);
	
	
	/**
	 * 根据用户列出他们的日记
	 * @param uid
	 * @return
	 */
	public Page<Diary> list(String uid,int page,int rows);
	
	
	/**
	 * 查看单个日记
	 */
	
	public Diary showdiary(String did);
}
