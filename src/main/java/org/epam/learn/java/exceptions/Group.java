package org.epam.learn.java.exceptions;

public enum Group {
    GROUP_ONE("Group one"), GROUP_TWO("Group two"), GROUP_THREE("Group three");
        private final String groupName;
    Group(String name) {
        groupName = name;
    }

    public String getGroup() {
        return groupName;
    }
}
