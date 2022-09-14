package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeMap {
    Map<Trainee, String> Pairr;
    public TraineeMap(){
        Pairr = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException{
        if (Pairr.containsKey(trainee) & Pairr.containsValue(institute)) throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        Pairr.put(trainee,institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException{
        if (Pairr.containsKey(trainee)) Pairr.replace(trainee,institute);
        else throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void removeTraineeInfo(Trainee trainee)  throws TrainingException{
        if(!Pairr.containsKey(trainee)) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
            Pairr.remove(trainee);
    }

    public int getTraineesCount(){
        return Pairr.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException{
        if(!Pairr.containsKey(trainee)) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        return Pairr.get(trainee);
    }

    public Set<Trainee> getAllTrainees(){
        return new HashSet<>(Pairr.keySet());
    }

    public Set<String> getAllInstitutes(){
        return new HashSet<>(Pairr.values());
    }

    public boolean isAnyFromInstitute(String institute){

        return Pairr.containsValue(institute);
    }

}
