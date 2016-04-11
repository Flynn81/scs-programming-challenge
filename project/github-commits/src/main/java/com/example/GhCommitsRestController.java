/**
 * 
 */
package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Commit;
import com.google.gson.Gson;

/**
 * @author Hemin
 *
 */
@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class GhCommitsRestController {
	
	static String BLANK_ = " ";
	static int SIZE_ = 29;
	static String REPO_NAME= "rails/rails";
	static String OWNER_NAME="hemindesai04";
	static String TOKEN="c6d0cfdd963272c0c6e223d04436ae36155352cc";
	
	@RequestMapping("/list")
	public String commitList(){
		
		
		
		List<Commit> commitList = new ArrayList<Commit>();
		
		try {
			GitHub gitHub = GitHub.connect(OWNER_NAME,TOKEN);
			GHRepository ghRepository= gitHub.getRepository(REPO_NAME);
			for(GHCommit commits : ghRepository.listCommits()){
				GHUser author = commits.getAuthor();
				String authorName = author.getName();
				String sha = commits.getSHA1();
				String message = commits.getCommitShortInfo().getMessage();
				Commit newCommit = new Commit();
				if (authorName != null && !authorName.equals("")) {
					newCommit.setPersonName(authorName);
					if (sha != null) {
						newCommit.setCommit(sha);
					} else {
						newCommit.setCommit(BLANK_);
					}
					if (message != null) {
						newCommit.setCommitMessage(message);
					} else {
						newCommit.setCommitMessage(BLANK_);
					}
					commitList.add(newCommit);
				}
				if(commitList.size() > SIZE_){
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String list = new Gson().toJson(commitList);
		
		return list;
	}

}
