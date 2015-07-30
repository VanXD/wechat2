package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aliapp.wxxd.material.entity.db.Material;
import com.aliapp.wxxd.material.mapper.MaterialMapper;

public class MaterialMapperTest {
	ApplicationContext applicationContext;

	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
	}

	@Test
	public void testInsert() {
		MaterialMapper mapper = (MaterialMapper) applicationContext.getBean("materialMapper");
		System.out.println(mapper);
	}

}
