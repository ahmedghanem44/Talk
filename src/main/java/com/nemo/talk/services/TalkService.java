package com.nemo.talk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemo.talk.daos.TalkDao;
import com.nemo.talk.daos.TalkDaoInterface;
import com.nemo.talk.entities.Talk;


@Service
public class TalkService implements TalkServiceInterface {
	
	@Autowired
	private TalkDaoInterface talkdDao;


	public void newTalk(Talk talk) {
		 talkdDao.addTalk(talk); 

	}


	public void removeTalk(int id) {
		talkdDao.deleteTalk(id);

	}


	public Talk findTalk(int id) {	
		return talkdDao.getTalk(id);
	}


	public List<Talk> findTalks() {
		return talkdDao.getTalks();
	}


	public void editTalk(Talk talk) {
		talkdDao.updateTalk(talk);

	}

}
