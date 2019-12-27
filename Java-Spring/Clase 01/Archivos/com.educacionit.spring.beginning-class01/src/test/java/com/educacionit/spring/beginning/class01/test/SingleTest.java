
package com.educacionit.spring.beginning.class01.test;


import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.educacionit.spring.beginning.class01.beans.Single;


@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext7.xml" })
public class SingleTest {
	
	
	public SingleTest () {
		
		super ();
	}
	
	
	@Autowired
	Single bean1 = null;
	
	@Autowired
	Single bean2 = null;

	
    @Test
    public void test_ml_always_return_true() {

    	System.out.println (bean1.getCode());
    	System.out.println (bean2.getCode ());
    	assertTrue (bean1.getCode ().equals (bean2.getCode ()));
    }
}