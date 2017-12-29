package com.genpact.generate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GenObjects {
	public static boolean gen(Map<String,Object> root){
		boolean flag = false;
		Configuration cfg = Configuration.getDefaultConfiguration();
		Writer out = null;
		try {
			
			cfg.setDirectoryForTemplateLoading(new File("D:/workspace/generate/src/main/resources/templates"));
			cfg.setObjectWrapper(new DefaultObjectWrapper());  
			
			Template temp = cfg.getTemplate("genmodel.ftl"); 
			
			 out = new OutputStreamWriter(new FileOutputStream(new File("D:/workspace/generate/output/FirstFreemark.java")));
			temp.process(root, out);
			out.flush();
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}  finally{
			if(null != out){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
		
	}
	
	
	
	
	
}
