package org.epam.learn.java.classes;

public enum Group {
    GROUP_ONE("Group one"), GROUP_TWO("Group two"), GROUP_THREE("Group three");
        private final String group;
    Group(String name) {
        this.group = name;
    }

    public String getGroup() {
        return group;
    }
}
