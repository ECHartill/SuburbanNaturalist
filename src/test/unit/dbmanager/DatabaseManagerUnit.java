package test.unit.dbmanager;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;

import com.database.HibernateDatabaseManager;
import com.helpers.Encryptor;
import com.models.Image;
import com.models.User;
import com.parents.SuburbanNaturalistException;

public class DatabaseManagerUnit
{
	@Test(enabled = false)
	public void testLogin() throws SuburbanNaturalistException
	{
		Encryptor e = Encryptor.getInstance();
		HibernateDatabaseManager hdbm = new HibernateDatabaseManager();
		User u = hdbm.login("eric@eric.com", e.encrypt("1qweqwe"));
		
		assert u != null;
	}
	
	@Test(enabled = false)
	public void testSaveImage()
	{
		Image i = new Image();
	    Date now = new Date(new GregorianCalendar().getTimeInMillis());
		HibernateDatabaseManager hdbm = new HibernateDatabaseManager();

		i.setFileName("");
		i.setImagePath("");
		i.setLastEdited(now);
		i.setShared(now);
		i.setUploaded(now);
		i.setUserId(1);
		
		try
		{
			hdbm.saveImage(i);
		}
		catch (SuburbanNaturalistException sne)
		{
			sne.printStackTrace();
		}
	}
}
