package fr.pablo.supersnail.core.submissions;

public class Submission {

    private String title;
    private String desc;
    private String dlLink;
    private Long authorID;
    private SubmissionType submissionType;
    private int id;

    public Submission(String title, String desc, String dlLink, Long authorID, SubmissionType submissionType, int id) {
        this.title = title;
        this.desc = desc;
        this.dlLink = dlLink;
        this.authorID = authorID;
        this.submissionType = submissionType;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDlLink() {
        return dlLink;
    }

    public void setDlLink(String dlLink) {
        this.dlLink = dlLink;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public SubmissionType getSubmissionType() {
        return submissionType;
    }

    public void setSubmissionType(SubmissionType submissionType) {
        this.submissionType = submissionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
