package org.epam.learn.java.exceptionscorrect;

import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoGroupsException;
import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoStudentException;
import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoSubjectException;
import org.epam.learn.java.exceptionscorrect.enums.FacultyName;
import org.epam.learn.java.exceptionscorrect.enums.GroupName;
import org.epam.learn.java.exceptionscorrect.enums.Subject;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements AverageMarkBySubject {
    private final FacultyName facultyName;
    private List<Group> groupList;

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public Faculty(FacultyName facultyName, List<Group> groupList) {
        this.facultyName = facultyName;
        this.groupList = groupList;
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public List<Group> getGroups() throws NoGroupsException {
        if (groupList == null) {
            throw new NoGroupsException("No groups in faculty " + facultyName);
        }
        return groupList;
    }

    public Group getGroup(GroupName groupName) throws NoGroupsException {
        if (groupList == null) {
            throw new NoGroupsException("No groups in faculty " + facultyName);
        }
        for (Group group : groupList) {
            if (group.getGroupName() == groupName) {
                return group;
            }
        }
        throw new NoGroupsException("No group " + groupName + " in faculty " + facultyName);
    }

    public void addGroup(Group group) {
        if (groupList == null) {
            groupList = new ArrayList<>();
        }
        groupList.add(group);
    }

    @Override
    public double getAverageMarkBySubject(Subject subject) throws NoSubjectException, NoGroupsException {
        if (groupList == null) {
            throw new NoGroupsException("There is no groups in faculty " + facultyName);
        }

        int sum = 0;
        int count = 0;
        for (Group group : groupList) {
            try {
                sum += group.getAverageMarkBySubject(subject);
                count++;
            } catch (NoSubjectException | NoStudentException e) {
                e.printStackTrace();
            }
        }
        if (count == 0) {
            throw new NoSubjectException("No subject " + subject + " found at faculty " + facultyName);
        }
        return (double) sum / count;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName=" + facultyName +
                ", groupList=" + groupList +
                '}';
    }
}
