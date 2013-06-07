package test.unit.dbmanager;

import org.testng.annotations.Test;

import com.database.HibernateDatabaseManager;
import com.helpers.Encryptor;
import com.models.User;
import com.parents.SuburbanNaturalistException;

public class DatabaseManagerUnit
{
	@Test
	public void testLogin() throws SuburbanNaturalistException
	{
		Encryptor e = Encryptor.getInstance();
		HibernateDatabaseManager hdbm = new HibernateDatabaseManager();
		User u = hdbm.login("erichartill@gmail.com", e.encrypt("1qweqwe"));
	}
}
