package com.rapstar.songlist.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rapstar.entity.Song;
import com.rapstar.entity.SongList;
import com.rapstar.entity.User;

@Repository
public class SongListDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public int countByPage() {
		Session session = this.sessionFactory.openSession();
		String hql = "select count(*) from SongList";
		Query query = session.createQuery(hql);
		long num = (Long)query.uniqueResult();		
		return (int)num;
	}
	
	
	public List<SongList> findByPage(int pageNum, int pageSize) {
		Session session = this.sessionFactory.openSession();
		String hql = "from SongList";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	
	}
	
	/*
	 * 
	 * 得到全部歌单
	 */
	public List<SongList> getAllSongLists(){
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from SongList");
		List<SongList> songlists=query.list();
		
		if(null!=songlists&&0!=songlists.size()) {
			
			return songlists;
		}else {
			return null;
		}
	}
	
	/*
	 * 
	 * 根据用户id和所要的收藏/本地等来查询歌曲列表
	 */
	public List<SongList> getSonglistsByUserAndWant(Integer id,String want){
		Session session=sessionFactory.openSession();
		List<SongList> songlists=new ArrayList<SongList>();
		if(want.equals("collect")) {
			//根据用户id查询到歌单id
			Query query=session.createQuery("select songlistid from Slistcollect where userid=:x");
			query.setParameter("x", id);
			List<Integer> ids=query.list();
			//根据歌曲id查询歌曲列表
			for(int i=0;i<ids.size();i++) {
				Query query1=session.createQuery("from SongList where id=:id");
				query1.setParameter("id", ids.get(i));
				SongList songlist=(SongList) query1.list().get(0);
				songlists.add(songlist);
			}	
		}
		
		session.close();
		if(null!=songlists&&0!=songlists.size()) {
			return songlists;
		}else {
			return null;
		}
	}

}
