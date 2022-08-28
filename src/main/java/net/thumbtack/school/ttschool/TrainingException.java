package net.thumbtack.school.ttschool;

public class TrainingException extends Exception {
    private TrainingErrorCode trainingErrorCode;
    public TrainingException(TrainingErrorCode trainingErrorCode) {
        super(trainingErrorCode.getErrorCode());
        this.trainingErrorCode = trainingErrorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return trainingErrorCode;
    }

}
