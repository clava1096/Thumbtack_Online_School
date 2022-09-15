package net.thumbtack.school.ttschool;

import java.util.ArrayDeque;

public class TraineeQueue {
    // REVU private
    // pair1 (почему, кстати, pair ?)
    // и не надо тут ArrayDeque, просто Queue

    ArrayDeque Pair1;

    public TraineeQueue(){
        Pair1 = new ArrayDeque();
    }

    public void addTrainee(Trainee trainee) {
        Pair1.add(trainee);
    }

    public Object removeTrainee() throws TrainingException{
        // REVU не надо isEmpty, poll сама скажет
        if (Pair1.isEmpty()) throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        return Pair1.remove();
    }

    public boolean isEmpty(){
        return Pair1.isEmpty();
    }

}
