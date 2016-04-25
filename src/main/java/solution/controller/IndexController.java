package main.java.solution.controller;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.json.JSONObject;
import org.kohsuke.github.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import main.java.solution.model.CommitInfo;

import com.google.gson.Gson;

@Controller
public class IndexController {
	
	 @Value("${user}")
	    private String name;
	 
	 @Value("${token}")
	    private String token;
	 @Value("${repo}")
	    private String repo_name;

    @RequestMapping("/")
    public String index() {

		
        return "index";
    }

    @RequestMapping(value="/listAPI",produces = "application/json")
    public @ResponseBody String listAPI() {
    	List<CommitInfo> cm=new ArrayList<CommitInfo>();;
    	  try {
    			GitHub git=GitHub.connect(name, token);
    			GHRepository repo= git.getRepository(repo_name);
    			PagedIterator<GHCommit> commits =
    	        repo.queryCommits().list()._iterator(50);
    			int i=0;
    			 while (commits.hasNext() && i<50) {
    			GHCommit commit=commits.next();
    				 CommitInfo c=new CommitInfo();
    			if(commit.getAuthor().getName()!=null)
    				c.setUser(commit.getAuthor().getName());
    			else
    				c.setUser(commit.getCommitter().getLogin());
    			if(commit.getCommitShortInfo().getMessage()!=null)
    				c.setMessage(commit.getCommitShortInfo().getMessage());
    			c.setCommit(commit.getSHA1());
    			cm.add(c);
    			i++;
    			}
    	  } catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}	
    	  Gson gson = new Gson();
    	  JSONObject jj =new JSONObject();
    	  jj.put("data", cm);
    	  jj.put("draw", 1);
    	  jj.put("recordsTotal", cm.size());
    	  jj.put("recordsFiltered", cm.size());
    	  return jj.toString();
    }
    
}
