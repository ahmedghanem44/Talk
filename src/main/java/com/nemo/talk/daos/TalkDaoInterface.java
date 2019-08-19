package com.nemo.talk.daos;

import java.util.List;

import com.nemo.talk.entities.Talk;

public interface TalkDaoInterface {
	
	void addTalk (Talk talk);
	void deleteTalk (int id);
	Talk getTalk(int id);
	List<Talk> getTalks();
	void updateTalk (Talk talk);
	
}
