package org.epam.learn.java.exceptionscorrect.enums;

public enum GroupName {
    GROUP_ONE("Group-one"), GROUP_TWO("Group-two"), GROUP_THREE("Group-three");
    private final String groupName;
    GroupName(String name) {
        groupName = name;
    }

    @Override
    public String toString() {
        return groupName;
    }
}
