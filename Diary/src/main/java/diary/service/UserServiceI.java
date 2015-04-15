package diary.service;

import diary.pagemodel.User;

public interface UserServiceI {
	
	public static final String USER_SERVICE_NAME ="userService"; 
	
	public void test();
	
	public void save(User t);

	public User login(User user);

}
