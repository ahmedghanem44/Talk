package com.nemo.talk.daos;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nemo.talk.entities.Talk;

import javassist.tools.rmi.ObjectNotFoundException;

@Repository
public class TalkDao implements TalkDaoInterface{
	
	@Autowired
	SessionFactory sessionFactory;	

	@Transactional
	public void addTalk (Talk talk) {
		Session sess = sessionFactory.getCurrentSession();
		sess.save(talk);
//		sess.flush();
//		sess.close();	
	}

	@Transactional
	public void updateTalk (Talk talk) {
		Session sess = sessionFactory.openSession();
		org.hibernate.Transaction tx = sess.beginTransaction();
		Talk t = (Talk) sess.load(Talk.class,talk.getId());
		t.setName(talk.getName());
		t.setSpeaker(talk.getSpeaker());
		t.setVenue(talk.getVenue());
		t.setMinutes(talk.getMinutes());
		sess.update(t);
		tx.commit();
		
		sess.close();
	}

	@Transactional
	public void deleteTalk (int id) {
		Session sess = sessionFactory.openSession();
//		Talk t = new Talk();
//		t.setId(id);
		Talk t = (Talk) sess.load(Talk.class, new Integer(id));
		sess.delete(t);
		sess.flush();
		sess.close();
	}
	
	@Transactional
	public Talk getTalk(int id) {
		Session sess = sessionFactory.openSession();
		Talk talk = (Talk) sess.get(Talk.class, new Integer(id));
//		Talk talk = sess.load(Talk.class, id);
//		Talk talk = sess.load(Talk.class, (Integer)id);
//		Talk talk = sess.load((Talk.class, new Integer(id));
		return talk;	
	}
	
	@Transactional
	public List<Talk> getTalks(){
		Session sess = sessionFactory.openSession();
//		Query query = sess.createQuery("from Talk");
//		List<Talk> talks = query.list();
		List<Talk> list = sess.createCriteria(Talk.class).list();
//		Criteria cr = sess.createCriteria(Talk.class);
//		List<Talk> list2 = cr.list();
//		cr.add(Restrictions.eq(propertyName, value));
		sess.close();
		return list;
	}
	
	
	

}
