package main.java.solution.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;

import org.json.JSONObject;
import org.kohsuke.github.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import main.java.solution.model.commitInfo;

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
    	String json = "";
    	List<commitInfo> cm=new ArrayList<commitInfo>();;
    	  try {
    			GitHub git=GitHub.connect(name, token);
    			GHRepository repo= git.getRepository(repo_name);
    			long dt=1461428699000L;
    			PagedIterable<GHCommit> commits=repo.queryCommits().since(new Date(dt)).list();
    			List<GHCommit> comms=commits.asList();
    			for(GHCommit commit:comms){
//    			System.out.println(commit.getCommitter() +" "+commit.getCommitShortInfo().getMessage()+ " " +commit.getAuthor().getName() +" " +commit.getSHA1());
    			commitInfo c=new commitInfo();
    			if(commit.getAuthor().getName()!=null)
    				c.setUser(commit.getAuthor().getName());
    			else
    				c.setUser(commit.getCommitter().getLogin());
    			if(commit.getCommitShortInfo().getMessage()!=null)
    				c.setMessage(commit.getCommitShortInfo().getMessage());
    			c.setCommit(commit.getSHA1());
    			cm.add(c);
    			}
    	  } catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}	
    	  Gson gson = new Gson();
    	  json = new Gson().toJson(cm);
    	  JSONObject jj =new JSONObject();
    	  jj.put("data", cm);
    	  jj.put("draw", 1);
    	  jj.put("recordsTotal", cm.size());
    	  jj.put("recordsFiltered", cm.size());
    	  return jj.toString();
    }
    
}
