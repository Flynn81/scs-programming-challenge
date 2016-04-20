package com.scs.example.services;

import com.scs.example.model.Commit;
import com.scs.example.service_interface.CommitServiceInterface;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 4/20/16.
 */
public class CommitsServices implements CommitServiceInterface {


    private final String TOKEN;
    private final int PAGE_SIZE = 25;

    private String REPO;

    public CommitsServices(String repo, String TOKEN) {
        this.TOKEN = TOKEN;
        this.REPO = repo;
    }

    public List<Commit> getCommits() {

        //GitHub gitHub = GitHub.connectUsingPassword("******", "**********");
        try {

            GitHub gitHub = GitHub.connectUsingOAuth(TOKEN);

            GHRepository repository = gitHub.getRepository(REPO);

            PagedIterator<GHCommit> commits = repository.listCommits().iterator();

            List<Commit> commitsList = new LinkedList<Commit>();


            int count = 0;

            while (commits.hasNext() && count < PAGE_SIZE) {
                GHCommit commit = commits.next();

                String name = commit.getAuthor().getName();
                String sha = commit.getSHA1();
                String message = commit.getCommitShortInfo().getMessage();


                commitsList.add(new Commit(name, sha, message));
                count++;
            }

            return commitsList;
        } catch (Exception e) {
            e.printStackTrace();

            //return empty list
            return new LinkedList<Commit>();
        }

    }


}