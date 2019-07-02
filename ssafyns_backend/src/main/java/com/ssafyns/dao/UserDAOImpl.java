package com.ssafyns.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafyns.vo.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private SqlSession session;

	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public void insertUser(User user) {
		session.insert("user.InsertUser", user);
	}

	@Override
	public void updateUser(User user) {
		session.update("user.UpdateUser", user);
	}

	// 실제 탈퇴할 때 삭제하는 게 아니라 isleave를 1로 바꿔주기만 하면 된다.
	@Override
	public void deleteUser(String user_id) {
		session.delete("user.DeleteUser", user_id);
	}

	@Override
	public User selectUser(String user_id) {
		return session.selectOne("user.SelectUser", user_id);
	}
	
	@Override
	public List<User> selectUserList() {
		return session.selectList("user.SelectUserList");
	}
	
}
