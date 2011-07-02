package net.viralpatel.spring3.service;

import java.util.List;

import net.viralpatel.spring3.form.Contact;

public interface ContactService {

	public void addContact(Contact contact);
	public List<Contact> listContacts();
	public void removeContact(Integer id);
	
}
