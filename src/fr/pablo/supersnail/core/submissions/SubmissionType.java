package fr.pablo.supersnail.core.submissions;

public enum SubmissionType {
    MAPPING("Mapping", "\uD83C\uDFDF️"),
    SCRIPT("Script", "⚒️"),
    CAR("Vehicle","\uD83D\uDE97"),
    CLOTH("Clothes","\uD83E\uDDBA"),
    OTHER("Other / Non-listed","\uD83E\uDDED");

    private String display;
    private String emoji;

    SubmissionType(String display, String emoji) {
        this.display = display;
        this.emoji = emoji;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
