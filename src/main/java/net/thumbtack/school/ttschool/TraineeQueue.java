package net.thumbtack.school.ttschool;

import java.util.ArrayDeque;

public class TraineeQueue {
    ArrayDeque Pair1;

    public TraineeQueue(){
        Pair1 = new ArrayDeque();
    }

    public void addTrainee(Trainee trainee) {
        Pair1.add(trainee);
    }

    public Object removeTrainee() throws TrainingException{
        if (Pair1.isEmpty()) throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        return Pair1.remove();
    }

    public boolean isEmpty(){
        return Pair1.isEmpty();
    }

}
