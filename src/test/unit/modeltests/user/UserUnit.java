package test.unit.modeltests.user;

import org.testng.annotations.Test;

import com.models.User;

public class UserUnit
{
	@Test
	public void testId()
	{
		User u = new User();
		
		u.setId(100);
		assert 100 == u.getId();
		
		u.setId(null);
		assert null == u.getId();
		
		u.setId(0);
		assert 0 == u.getId();
	}
	
	@Test
	public void testFirstname()
	{
		User u = new User();
		
		u.setFirstname("");
		assert u.getFirstname().length() == 0;
		
		u.setFirstname(null);
		assert null == u.getFirstname();
		
		u.setFirstname("Alpha");
		assert u.getFirstname().equals("Alpha");
	}
	
	@Test
	public void testLastname()
	{
		User u = new User();
		
		u.setLastname("");
		assert u.getLastname().length() == 0;
		
		u.setLastname(null);
		assert null == u.getLastname();
		
		u.setLastname("Omega");
		assert u.getLastname().equals("Omega");
	}
	
	@Test
	public void testUsername()
	{
		User u = new User();
		
		u.setUsername("");
		assert u.getUsername().length() == 0;
		
		u.setUsername(null);
		assert null == u.getUsername();
		
		u.setUsername("Andre 3000");
		assert u.getUsername().equals("Andre 3000");
	}
	
	@Test
	public void testPassword()
	{
		User u = new User();
		
		u.setPassword("");
		assert u.getPassword().length() == 0;
		
		u.setPassword(null);
		assert null == u.getPassword();
		
		u.setPassword("Big Boi");
		assert u.getPassword().equals("Big Boi");
	}
}
