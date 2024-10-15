package org.report.bean;

public class Customer {
    private String customerId;
    private String contractId;
    private String geozone;

    private String teamName;

    private String projectName;
    private int buildDuration;

    public Customer() {
    }


    public Customer(String customerId, String contractId, String geozone,String teamName,String projectName, int buildDuration) {
        this.customerId = customerId;
        this.contractId = contractId;
        this.geozone = geozone;
        this.buildDuration = buildDuration;
        this.teamName= teamName;
        this.projectName= projectName;
    }

    public Customer(String customerId, String contractId, String geozone, int buildDuration) {
        this.customerId = customerId;
        this.contractId = contractId;
        this.geozone = geozone;
        this.buildDuration = buildDuration;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getGeozone() {
        return geozone;
    }

    public void setGeozone(String geozone) {
        this.geozone = geozone;
    }

    public int getBuildDuration() {
        return buildDuration;
    }

    public void setBuildDuration(int buildDuration) {
        this.buildDuration = buildDuration;
    }




    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", contractId='" + contractId + '\'' +
                ", geozone='" + geozone + '\'' +
                ", teamName='" + teamName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", buildDuration=" + buildDuration +
                '}';
    }
}
