package net.viralpatel.spring3.service;

import java.util.List;

import javax.annotation.Resource;

import net.viralpatel.spring3.form.Contact;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactService")
@Transactional
public class HibernateContactService implements ContactService{

	//TODO decidir si utilizar o no esto
	protected static Logger logger = Logger.getLogger("service");
	
	//TODO usar aqui el autowired???
	@Resource(name="sessionFactory")
	private  SessionFactory sessionFactory;
	
	public void addContact(Contact contact) {
		logger.debug("Saving contact");
		Session session = sessionFactory.getCurrentSession();
		session.save(contact);
	}

	public List<Contact> listContacts() {
		logger.debug("Retrieving all contacts");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM CONTACT");
		return query.list();
	}

	public void removeContact(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Contact c = (Contact) session.get(Contact.class, id);
		session.delete(c);
	}

}
