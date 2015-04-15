package diary.service;

import java.util.List;

import diary.model.Ttype;
import diary.pagemodel.Type;

public interface TypeServiceI {

	public static final String TYPE_SERVICE_NAME = "typeService";

	public void addType(Type d);

	public void delete(Ttype d);

	public void updateDiary(Type d);

	public List<Type> list(String uid);

}
