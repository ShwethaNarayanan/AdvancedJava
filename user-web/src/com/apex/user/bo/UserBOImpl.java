package com.apex.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apex.user.dao.UserDAO;
import com.apex.user.vo.User;
import com.apex.user.vo.UserVO;

@Service
public class UserBOImpl implements UserBO {
	@Autowired
	UserDAO userDAO;	
//	User user = null;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void addUsr(UserVO usrVO) {
		System.out.println("UserBOImpl:addUsr():Start");
//		user = new User();
//		user.setFirstName(usrVO.getFirstName());
//		user.setLastName(usrVO.getLastName());
//		user.setMiddleName(usrVO.getMiddleName());
//		userDAO.addUser(user);
//		************************************************************
		String save_url = "http://localhost:8080/userservice/saveuser";
		ResponseEntity<UserVO> save_result = restTemplate.postForEntity(save_url, usrVO, UserVO.class);
		
//		************************************************************		
		
		
		System.out.println("UserBOImpl:addUsr():End");
	}

	public UserVO getUsr(int usrID) {
//		************************************************************
		String get_url = "http://localhost:8080/userservice/getuser/"+usrID;
		ResponseEntity<UserVO> save_result = restTemplate.getForEntity(get_url, UserVO.class);
		
//		************************************************************		
		
		return null;
	}

	public void update(UserVO usrVO) {
	}

	public void deleteUser(int usrID) {
	}

}
