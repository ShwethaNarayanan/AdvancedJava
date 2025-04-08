package com.apex.user.bo;

import com.apex.user.vo.UserVO;

public interface UserBO {
	public void addUsr(UserVO usrVO);

	public UserVO getUsr(int usrID);

	public void update(UserVO usrVO);

	public void deleteUser(int usrID);
}
