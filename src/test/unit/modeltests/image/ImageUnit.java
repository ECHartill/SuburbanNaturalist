package test.unit.modeltests.image;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.testng.annotations.Test;

import com.models.Image;

public class ImageUnit
{
	
	@Test
	public void testId()
	{
		Image i = new Image();
		
		i.setId(100);
		assert 100 == i.getId();
		
		i.setId(null);
		assert null == i.getId();
		
		i.setId(0);
		assert 0 == i.getId();
	}
	
	@Test
	public void testUserId()
	{
		Image i = new Image();
		
		i.setUserId(100);
		assert 100 == i.getUserId();
		
		i.setUserId(null);
		assert null == i.getUserId();
		
		i.setUserId(0);
		assert 0 == i.getUserId();
	}
	
	@Test
	public void testImagePath()
	{
		Image i = new Image();
		
		i.setImagePath("");
		assert i.getImagePath().length() == 0;
		assert "".equals(i.getImagePath());
		
		i.setImagePath(null);
		assert null == i.getImagePath();
		
		i.setImagePath("omega");
		assert "omega".equals(i.getImagePath());
	}
	
	@Test
	public void testFileName()
	{
		Image i = new Image();
		
		i.setFileName("");
		assert i.getFileName().length() == 0;
		assert "".equals(i.getFileName());
		
		i.setFileName(null);
		assert null == i.getFileName();
		
		i.setFileName("omega");
		assert "omega".equals(i.getFileName());
	}
	
	@Test
	public void testUploaded()
	{
		Image i = new Image();
	    Date d = new Date(new GregorianCalendar().getTimeInMillis());
		
	    i.setUploaded(d);
	    assert d == i.getUploaded();
	    
	    i.setUploaded(null);
	    assert null == i.getUploaded();
	}
	
	@Test
	public void testShared()
	{
		Image i = new Image();
	    Date d = new Date(new GregorianCalendar().getTimeInMillis());
		
	    i.setShared(d);
	    assert d == i.getShared();
	    
	    i.setShared(null);
	    assert null == i.getShared();
	}
	
	@Test
	public void testLastEdited()
	{
		Image i = new Image();
	    Date d = new Date(new GregorianCalendar().getTimeInMillis());
		
	    i.setLastEdited(d);
	    assert d == i.getLastEdited();
	    
	    i.setLastEdited(null);
	    assert null == i.getLastEdited();
	}

}
