package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    private String name, room;
     List<Trainee> trainees = new ArrayList<>();
    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
    }

    public void setName(String name) throws TrainingException{
        checkName(name);
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getRoom(){
        return room;
    }

    public void setRoom(String room) throws TrainingException{
        checkRoom(room);
        this.room = room;
    }

    public List<Trainee> getTrainees(){
        return trainees;
    }

    public void addTrainee(Trainee trainee){
        this.trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException{
        boolean c = this.trainees.remove(trainee);
        if (!c) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void removeTrainee(int index) throws TrainingException{
        try{
           trainees.remove(index);
        }catch (IndexOutOfBoundsException ex){
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

    }

    public Trainee  getTraineeByFullName(String fullName) throws TrainingException {
        for(Trainee trainee : trainees) {
            if (trainee.getFullName().equals(fullName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }
    public Trainee getTraineeByFirstName(String firstName) throws TrainingException{
        for(Trainee trainee : trainees) {
            if (trainee.getFirstName().equals(firstName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }
    public void  sortTraineeListByFirstNameAscendant(){
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void  sortTraineeListByRatingDescendant(){
        trainees.sort((o1, o2) -> Integer.compare(o2.getRating(), o1.getRating()));
    }

    public void  reverseTraineeList(){
        Collections.reverse(trainees);
    }

    public void  rotateTraineeList(int positions){
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException{
        List<Trainee> traineesWithMaxRating = new ArrayList<>();
        if (trainees.isEmpty()){
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        List<Trainee> copyOfTrainees = trainees;
        copyOfTrainees.sort((o1, o2) -> Integer.compare(o2.getRating(), o1.getRating()));

        int maxR=0;
        for (Trainee trainee : copyOfTrainees){
            if (trainee.getRating() >= maxR) {
                maxR=trainee.getRating();
                traineesWithMaxRating.add(trainee);
            }
        }
        return traineesWithMaxRating;
    }

    public boolean  hasDuplicates(){
        ArrayList<Trainee> TraineesWithoutDublicates = new ArrayList<>(new HashSet<>(trainees));
        return !(trainees.size() <= TraineesWithoutDublicates.size());
    }

    public static void checkName(String name) throws  TrainingException{
        if ((name == null | Objects.equals(name, ""))) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
    }
    public static void checkRoom(String room) throws  TrainingException{
        if (room == null | Objects.equals(room, "")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) && Objects.equals(room, group.room) && Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }

}