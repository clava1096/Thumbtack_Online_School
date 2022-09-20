package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeMap {
    private Map<Trainee, String> traineeMap;
    public TraineeMap(){
        traineeMap = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException{
        String s = traineeMap.putIfAbsent(trainee, institute);
        if (s != null) throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException{
        String s = traineeMap.replace(trainee,institute);
        if (s == null) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void removeTraineeInfo(Trainee trainee)  throws TrainingException{
        String s = traineeMap.remove(trainee);
        if (s == null) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public int getTraineesCount(){
        return traineeMap.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException{
        if (traineeMap.get(trainee) == null) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        return traineeMap.get(trainee);
    }

    public Set<Trainee> getAllTrainees(){
        return new HashSet<>(traineeMap.keySet());
    }

    public Set<String> getAllInstitutes(){
        return new HashSet<>(traineeMap.values());
    }

    public boolean isAnyFromInstitute(String institute){

        return traineeMap.containsValue(institute);
    }

}
