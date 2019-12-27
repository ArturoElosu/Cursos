
package com.educacionit.spring.beginning.class01.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import com.educacionit.spring.beginning.class01.service.AppConfig;
import com.educacionit.spring.beginning.class01.service.IInventoryService;


@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (classes = {AppConfig.class})
public class InventoryTest {
	
	
	public InventoryTest () {
		
		super ();
	}
	
	
	@Autowired
    IInventoryService service = null;

	
    @Test
    public void test_ml_always_return_true() {

        assertThat (service, instanceOf (IInventoryService.class));
    }
}