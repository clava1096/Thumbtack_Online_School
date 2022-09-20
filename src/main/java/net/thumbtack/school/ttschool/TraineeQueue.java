package net.thumbtack.school.ttschool;

import java.util.ArrayDeque;
import java.util.Queue;

public class TraineeQueue {
    // REVU private
    // pair1 (почему, кстати, pair ?)
    // и не надо тут ArrayDeque, просто Queue

    Queue traineeQueue;

    public TraineeQueue(){
        traineeQueue = new ArrayDeque();
    }

    public void addTrainee(Trainee trainee) {
        traineeQueue.add(trainee);
    }

    public Object removeTrainee() throws TrainingException{
        Object s = traineeQueue.poll();
        if(s == null) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        return s;
    }

    public boolean isEmpty(){
        return traineeQueue.isEmpty();
    }

}
