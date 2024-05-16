package com.cts.member.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.member.exception.MemberNotFoundException;
import com.cts.member.model.Member;
import com.cts.member.repo.MemberRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService {
	// Shagun
	@Autowired
	MemberRepo memberRepo;

	@Transactional
	public Member registerMember(Member member) {
		log.info("adding new Member to record...");
		memberRepo.save(member);
		log.info("done.");
		return member;
	}

	@Transactional
	public List<Member> getAllMembersForAdmin() {
		log.info("loading all members...");
		List<Member> memberList = memberRepo.findAll();
		if (memberList.size() == 0) {
			log.info("Exception occurs");
			throw new MemberNotFoundException("Database is emplty!");
		} else {
			return memberList;
		}
	}

	// Rishabh
	@Transactional
	public Member memberById(int id) {
		log.info("searching Member record...");
		return memberRepo.findById(id)
				.orElseThrow(() -> new MemberNotFoundException("Member with the id " + id + " does not exist"));
	}

	@Transactional
	public Member memberByUserName(String userName) throws MemberNotFoundException {
		log.info("searching Member record...");
		Member mList = memberRepo.findByUserName(userName);

		if (mList == null) {
			throw new MemberNotFoundException("Member with the userName " + userName + " does not exist");
		}

		return mList;
	}

	@Transactional
	public String memberType(int id) {
		log.info("fetching member-type...");
		Optional<Member> mList = memberRepo.findById(id);
		String memType = null;
		if (!mList.isPresent()) {
			throw new MemberNotFoundException("Member with the memberId " + id + " does not exist");
		} else {
			memType = mList.get().getMemberType();
		}

		return memType;
	}

}
