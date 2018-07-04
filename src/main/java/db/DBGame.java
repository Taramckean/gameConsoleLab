package db;

import models.Console;
import models.Game;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGame {
	private static Session session;
	private static Transaction transaction;

	public static List<Console> getConsolesFromGame(Game game){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Console> consoles = null;
		try { Criteria cr = session.createCriteria(Console.class);
			((Criteria) cr).createAlias("games", "game");
			cr.add(Restrictions.eq("game.id", game.getId()));
			consoles = cr.list();
		} catch(HibernateException e){
			e.printStackTrace();
		} finally {
			session.close();
		} return consoles;
	}
}
