package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("TRAINING_WRONG_FIRST_NAME"),
    TRAINEE_WRONG_LASTNAME("TRAINING_WRONG_LAST_NAME"),
    TRAINEE_WRONG_RATING("TRAINING_WRONG_RATING");
    String errorString;

    TrainingErrorCode(String error){
        this.errorString = error;
    }

    public String getErrorCode() {
        return errorString;
    }
}
