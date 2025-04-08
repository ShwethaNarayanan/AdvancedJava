package com.service.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apex.user.dao.UserDAO;
import com.apex.user.vo.User;
import com.service.vo.UserVO;


@Service
public class UserBOImpl implements UserBO {
	
	@Autowired
	private UserDAO userdao;

	private User user;
	
	@Override
	public void addUsr(UserVO usrVO) {
		user = new User();
		user.setFirstName(usrVO.getFirstName());
		user.setLastName(usrVO.getLastName());
		user.setMiddleName(usrVO.getMiddleName());		
		userdao.addUser(user);
	}

	@Override
	public UserVO getUsr(int usrID) {
		user = userdao.getUser(usrID);
		UserVO userVO = new UserVO(user.getFirstName(), user.getLastName(), user.getMiddleName());	
		userVO.setId(user.getId());
		return null;
	}

	@Override
	public void update(UserVO usrVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int usrID) {
		// TODO Auto-generated method stub
		
	}

}
