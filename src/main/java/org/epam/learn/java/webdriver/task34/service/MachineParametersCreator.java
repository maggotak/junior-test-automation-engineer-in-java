package org.epam.learn.java.webdriver.task34.service;

import org.epam.learn.java.webdriver.task34.model.MachineParameters;

public class MachineParametersCreator {
    public static final String NUMBER_OF_INSTANCES = "testdata.numberOfInstances";
    public static final String OPERATING_SYSTEM = "testdata.operatingSystem";
    public static final String MACHINE_CLASS = "testdata.machineClass";
    public static final String MACHINE_SERIES = "testdata.machineSeries";
    public static final String MACHINE_TYPE = "testdata.machineType";
    public static final String NUMBER_OF_GPU = "testdata.numberOfGPU";
    public static final String TYPE_OF_GPU = "testdata.typeOfGPU";
    public static final String LOCAL_SSD = "testdata.localSSD";
    public static final String DATACENTER_LOCATION = "testdata.datacenterLocation";
    public static final String COMMITTED_USAGE = "testdata.committedUsage";

    public static MachineParameters fromTestDataProperty(){
        return new MachineParameters(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(OPERATING_SYSTEM), TestDataReader.getTestData(MACHINE_CLASS),
                TestDataReader.getTestData(MACHINE_SERIES), TestDataReader.getTestData(MACHINE_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPU), TestDataReader.getTestData(TYPE_OF_GPU),
                TestDataReader.getTestData(LOCAL_SSD), TestDataReader.getTestData(DATACENTER_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE));
    }
}
