package com.genpact.generate.test;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.genpact.generate.GenObjects;

public class GenTest {
	@Test
	public void testPath(){
		URL url = Thread.currentThread().getContextClassLoader().getResource("");
		System.out.println(url);
	}
	@Test
	public void testGen(){
		// prep data
		Map<String, String> map = null;
		List<Object> list = new ArrayList<Object>();
		
		map = new HashMap<String, String>();  
		map.put("name", "currency");  
		map.put("type", "String");  
		list.add(map);
		
		map.clear();
		map.put("name", "amount");  
		map.put("type", "Double");  
		list.add(map);
      
        
        Map<String,Object> root = new HashMap<String, Object>();
        root.put("package", "com.genpact.gen");
        root.put("class", "FirstFreemark");
        root.put("properties", list);
		System.out.println(GenObjects.gen(root));
	}
	
	
	
	@Test
	public void test1(){
		String a = "ABC_BAC_AA";
		
		
		System.out.println(a.toLowerCase().replaceAll("_[a-z]", "$1".toUpperCase()));
	}
}
