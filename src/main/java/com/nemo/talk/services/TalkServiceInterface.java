package com.nemo.talk.services;

import java.util.List;

import com.nemo.talk.entities.Talk;

public interface TalkServiceInterface {
	
	void newTalk (Talk talk);
	void removeTalk (int id);
	Talk findTalk(int id);
	List<Talk> findTalks();
	void editTalk (Talk talk);

}
