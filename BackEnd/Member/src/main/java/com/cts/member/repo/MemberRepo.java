package com.cts.member.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.member.model.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {
	
//	@Query(value="select user_name, password from member", nativeQuery=true)
//	public List<Member> getAllMembersForAdmin();
//	
//	@Query(value="select member_type from member where userName=?1 and password=?2")
//	public String getMemberType(String userName, String password);
//	
	
	@Query(value="Select * From member  where user_name=?1", nativeQuery = true)
	Member findByUserName(String userName);
}
