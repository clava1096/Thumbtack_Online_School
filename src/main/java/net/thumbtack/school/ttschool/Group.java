package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    // REVU private
    String name, room;
    // REVU trainees
    List<Trainee> Trainees = new ArrayList<>();
    public Group(String name, String room) throws TrainingException {
        // REVU вызовите сеттеры, не дублируйте код
        checkName(name);
        this.name = name;
        checkRoom(room);
        this.room = room;
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
        return Trainees;
    }

    public void addTrainee(Trainee trainee){
        this.Trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException{
        boolean c = this.Trainees.remove(trainee);
        if (!c) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void removeTrainee(int index) throws TrainingException{
        try{
           Trainees.remove(index);
        }catch (IndexOutOfBoundsException ex){
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

    }

    public Trainee  getTraineeByFullName(String fullName) throws TrainingException {
        for(Trainee trainee : Trainees) {
            if (trainee.getFullName().equals(fullName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }
    public Trainee getTraineeByFirstName(String firstName) throws TrainingException{
        for(Trainee trainee : Trainees) {
            if (trainee.getFirstName().equals(firstName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }
    public void  sortTraineeListByFirstNameAscendant(){
        Trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void  sortTraineeListByRatingDescendant(){
        Trainees.sort((o1, o2) -> Integer.compare(o2.getRating(), o1.getRating()));
    }

    public void  reverseTraineeList(){
        Collections.reverse(Trainees);
    }

    public void  rotateTraineeList(int positions){
        Collections.rotate(Trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException{
        // REVU traineesWithMaxRating
        List<Trainee> TraineesWithMaxRating = new ArrayList<>();
        if (Trainees.isEmpty()){
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        // REVU права изменять список Вам тут не дано
        Trainees.sort((o1, o2) -> Integer.compare(o2.getRating(), o1.getRating()));

        int maxr=0;
        for (Trainee trainee : Trainees){
            if (trainee.getRating() >= maxr) {
                maxr=trainee.getRating();
                TraineesWithMaxRating.add(trainee);
            }
        }
        return TraineesWithMaxRating;
    }

    public boolean  hasDuplicates(){
        ArrayList<Trainee> TraineesWithoutDublicates = new ArrayList<>(new HashSet<>(Trainees));
        return !(Trainees.size() <= TraineesWithoutDublicates.size());
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
        return Objects.equals(name, group.name) && Objects.equals(room, group.room) && Objects.equals(Trainees, group.Trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, Trainees);
    }

}