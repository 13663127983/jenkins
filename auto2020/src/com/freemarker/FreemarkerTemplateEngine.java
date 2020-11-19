package com.freemarker;

import java.io.File;
import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreemarkerTemplateEngine {
    private static final String DEFAULT_TEMPLATE = "reportTemplate.html";   
    public String getTemplatePath() {   
        return "D:/java/workspace/auto2020/conf";   
    	
    }   
       
    public String run(Map<String,Object> context) throws Exception{   
    	return executeFreemarker(context); 
    }   
    
    private String executeFreemarker(Map<String,Object> context)throws Exception{   
    	//String content="";
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);   
        cfg.setDirectoryForTemplateLoading(new File(getTemplatePath()));   
        cfg.setEncoding(Locale.CHINA, "UTF-8");
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        //cfg.setObjectWrapper(new DefaultObjectWrapper());              
        cfg.setCacheStorage(new freemarker.cache.MruCacheStorage(20, 250));                      
        Template temp = cfg.getTemplate(getTemplate());    
       
        StringWriter out = new StringWriter();   
        temp.process(context, out);   
        System.out.print(out.toString());
        return out.toString();
    }   
  
    public String getTemplate() {   
        // TODO Auto-generated method stub   
        return DEFAULT_TEMPLATE;   
    }    
}