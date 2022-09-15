package net.thumbtack.school.ttschool;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class School {
    // REVU все private
    String name;
    int year;
    Set<Group> Groups = new HashSet<>();
    public School(String name, int year) throws TrainingException{
        checkName(name);
        this.name = name;
        this.year = year;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) throws TrainingException{
        checkName(name);
        this.name = name;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public Set<Group> getGroups(){
        return Groups;
    }

    public void addGroup(Group group) throws TrainingException{
        // REVU Линейный проход для добавления - это плохо, медленно. Подумайте, как сделать, чтобы при формировании Set использовалось только name. Подсказка - кроме HashSet, есть и другой
        for(Group group1 : Groups){
            if (group1.getName().equals(group.getName())) throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
        }
        Groups.add(group);
    }
    public void  removeGroup(Group group) throws TrainingException{
        if(Groups.contains(group)) Groups.remove(group);
        else throw  new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
    }

    public void removeGroup(String name) throws TrainingException{
        boolean b = true;
        for(Group group : Groups) {
            if(group.getName().equals(name)) {
                Groups.remove(group);
                b = false;
            }
        }
        if(b) throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
    }

    public boolean containsGroup(Group group){
        return Groups.contains(group);
    }

    public static void checkName(String name) throws  TrainingException{
        if ((name == null | Objects.equals(name, ""))) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year && Objects.equals(name, school.name) && Objects.equals(Groups, school.Groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, Groups);
    }
}
