package com.rapstar.song.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rapstar.entity.Song;
import com.rapstar.entity.User;

@Repository
public class SongDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public int editSong(int mystate,int id) {
		Session session=this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = null;
		if(mystate == 1) {//已审核，未下架
			hql = "update Song s set s.mystate = 0 where s.id = :id";
		}else if(mystate == 2){//未审核
			hql = "update Song s set s.mystate = 1 where s.id = :id";
		}
		Query query = session.createQuery(hql);
		query.setParameter("id",id);
		int row = query.executeUpdate();
		tx.commit();
		
		return row;
	}
	/*
	 * 
	 * ��ȡ���и���
	 */
	public List<Song> getAllSongs(){
		System.out.println("���õ�dao��");
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Song");
		List<Song> songs=query.list();
		System.out.println("dao��"+songs.toString());
		if(null!=songs&&0!=songs.size()) {
			return songs;
		}else {
			return null;
		}
	}
    /*
	 * 
	 *得到热门歌曲
	 */
	public List<Song> getHotSongs(){
		Session session=sessionFactory.openSession();
		List<Song> songs=new ArrayList<>();
		Query query1=session.createQuery("select songid from Songcollect");
		List<Integer> songsids=query1.list();
		Set set=new HashSet(songsids);
		songsids.clear();
		songsids.addAll(set);
		for(int i=0;i<songsids.size();i++) {
			Query q=session.createQuery("from Song where id=:id");
			q.setParameter("id", songsids.get(i));
			Song song=(Song) q.list().get(0);
			songs.add(song);
		}
		
		if(null!=songs&&0!=songs.size()) {
			return songs;
		}else {
			return null;
		}
	}
	
	/*
	 * 随机生成歌曲
	 */
	public List<Song> getRandomSongs(){
		Session session=sessionFactory.openSession();
		List<Song> songs=new ArrayList<>();
		Set xs=new HashSet<>();
		//生成随机数
		for(int i=0;i<20;) {	
			int x=(int) (Math.random()*(50-1)+1);
			if(x>0&&x<49) {
				boolean y=xs.add(x);
				if(y) {
					i++;
				}	
			}	
		}
		Object[] arr=xs.toArray();
		List<Integer> list=new ArrayList<>();
		
		for(int i=0;i<xs.size();i++) {
			Query query=session.createQuery("from Song where id=:id");
			query.setParameter("id",arr[i]);
			songs.add((Song) query.uniqueResult());
			i++;	
		}
		
		if(null!=songs&&0!=songs.size()) {
			return songs;
		}else {
			return null;
		}
	}
	
	
	/*
	 * ���ݸ赥id�鿴�����б�
	 */
	public List<Song> getSongsBySonglistid(Integer id){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Song where songlistid=:id");
		query.setParameter("id", id);
		List<Song> songs=query.list();
		session.close();
		if(null!=songs&&0!=songs.size()) {
			return songs;
		}else {
			return null;
		}
	}
	
	/*
	 * ���ݸ����������ϸ��Ϣ
	 * 
	 */
	public Song getDetailByName(String name) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Song where name=:name");
		query.setParameter("name", name);
		List<Song> songs=query.list();
		Song song=songs.get(0);
		if(song!=null) {
			return song;
		}
		return null;		
	}
	
	/*
	 * 
	 * ���ݸ���id�õ�������ϸ��Ϣ
	 */
	public Song getDetailById(Integer id) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Song where id=:id");
		query.setParameter("id", id);
		List<Song> songs=query.list();
		Song song=songs.get(0);
		if(song!=null) {
			return song;
		}
		return null;		
	}
	
	/*
	 * 
	 * 根据用户id和所要的收藏/本地等来查询歌曲列表
	 */
	public List<Song> getSongsByUserAndWant(Integer id,String want){
		Session session=sessionFactory.openSession();
		List<Song> songs=new ArrayList<Song>();
		if(want.equals("collect")) {
			//根据用户id查询到歌曲id
			Query query=session.createQuery("select songid from Songcollect where userid=:x");
			query.setParameter("x", id);
			List<Integer> ids=query.list();
			//根据歌曲id查询歌曲列表
			for(int i=0;i<ids.size();i++) {
				Query query1=session.createQuery("from Song where id=:id");
				query1.setParameter("id", ids.get(i));
				Song song=(Song) query1.list().get(0);
				songs.add(song);
			}	
		}
		
		session.close();
		if(null!=songs&&0!=songs.size()) {
			return songs;
		}else {
			return null;
		}
	}
	
	
	public int countByPage() {
		Session session = this.sessionFactory.openSession();
		String hql = "select count(*) from Song";
		Query query = session.createQuery(hql);
		long num = (Long)query.uniqueResult();		
		return (int)num;
	}
	
	
	public List<Song> findByPage(int pageNum, int pageSize) {
		Session session = this.sessionFactory.openSession();
		String hql = "from Song";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	
	}
	
	
	public int countBySomePage() {
		Session session = this.sessionFactory.openSession();
		String hql = "select count(*) from Song where mystate = 2";
		Query query = session.createQuery(hql);
		long num = (Long)query.uniqueResult();		
		return (int)num;
	}
	
	
	public List<Song> findBySomePage(int pageNum, int pageSize) {
		Session session = this.sessionFactory.openSession();
		String hql = "from Song where mystate = 2";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		
		return query.list();
	
	}
}
