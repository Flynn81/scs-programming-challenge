package com.scs.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.github.*;

/**
 * Created by Steve on 4/8/2016.
 *
 */
public class GitCommits {
    /* Github Personal Access Token*/
    private final String TOKEN = "3e885f44aaf1d202b13ecf277d7fbfbc279d8980";
    private final int PAGE_SIZE = 25;

    private String repo;

    /**
     * Constructor
     * @param repo public repository
     */
    public GitCommits(String repo) {
        this.repo = repo;
    }

    /**
     * Get a list of commits
     * @return commits list {author, commit, commit_message}
     * @throws IOException
     */
    public List<Commit> getCommits() throws IOException {

        GitHub gitHub = GitHub.connectUsingOAuth(TOKEN);
        GHRepository repository = gitHub.getRepository(repo);

        PagedIterator<GHCommit> commits =
                repository.queryCommits().list()._iterator(PAGE_SIZE);

        List<Commit> commitsList = new ArrayList<>();

        String author, commit, msg;

        int count = 0;

        while (commits.hasNext() && count < PAGE_SIZE) {
            GHCommit c = commits.next();
            try {
                author = c.getAuthor().getName();
                commit = c.getSHA1();
                msg = c.getCommitShortInfo().getMessage();
            }
            catch (Exception e) {
                System.out.println("Error getting commit details!");
                continue;
            }

            commitsList.add(new Commit(author, commit, msg));
            count++;
        }

        return commitsList;
    }

    /**
     * Inner class to hold the details of a commit
     */
    private class Commit {

        public String user;
        public String commit;
        public String msg;

        public Commit(String user, String commit, String msg) {
            this.user = user;
            this.commit = commit;
            this.msg = msg;
        }
    }
}
