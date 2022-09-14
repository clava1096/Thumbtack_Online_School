package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("TRAINING WRONG FIRST NAME"),
    TRAINEE_WRONG_LASTNAME("TRAINING WRONG LAST NAME"),
    TRAINEE_WRONG_RATING("TRAINING WRONG RATING"),
    GROUP_WRONG_NAME("TRAINEE WRONG NAME"),
    GROUP_WRONG_ROOM("GROUP WRONG ROOM"),
    TRAINEE_NOT_FOUND("TRAINEE NOT FOUND"),
    SCHOOL_WRONG_NAME("SCHOOL WRONG NAME"),
    DUPLICATE_GROUP_NAME("DUPLICATE GROUP NAME"),
    GROUP_NOT_FOUND("GROUP NOT FOUND"),
    DUPLICATE_TRAINEE("DUPLICATE TRAINEE"),
    EMPTY_TRAINEE_QUEUE("EMPTY TRAINEE QUEUE");
    String errorString;

    TrainingErrorCode(String error){
        this.errorString = error;
    }

    public String getErrorCode() {
        return errorString;
    }
}
