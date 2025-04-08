package com.service.bo;

import com.service.vo.UserVO;

public interface UserBO {
	
	public void addUsr(UserVO usrVO);
	
	public UserVO getUsr(int usrID);

	public void update(UserVO usrVO);

	public void deleteUser(int usrID);

}
