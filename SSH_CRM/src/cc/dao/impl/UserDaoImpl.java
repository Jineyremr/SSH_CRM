package cc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cc.dao.UserDao;
import cc.domain.*;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")*/
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	/*@Resource(name="sessionFactory")
	private SessionFactory sf;*/
	

	public User login(final String userCode) {
		
		//HQL
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			public User doInHibernate(Session session) throws HibernateException {
				String hql="from User where user_code = ?";
				Query query = session.createQuery(hql);
				query.setParameter(0, userCode);
				User user = (User) query.uniqueResult();
				
				return user;
			}
		});
		
		
		//Criteria
		/*DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", userCode));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		
		if(list != null && list.size()>0){
			return list.get(0);
			
			
		}else{
			return null;
		}*/
		
		
		//Configuration conf = new Configuration().configure();
		
		//SessionFactory sessionFactory = conf.buildSessionFactory();
		/*Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		User u = new User();
		u.setUser_code("class");
		u.setUser_name("ио©н");
		u.setUser_password("1234");
		
		session.save(u);
		
		tx.commit();
		session.close();*/
	}

}
