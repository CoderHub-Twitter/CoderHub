package io.login;

import java.util.Date;

/**
 *
 * @author 
 */
public class Request {
    private String description;
    private String requestedBy;
    private String buildingName;
    private String roomName;
    private String section;
    private String repairType;
    private String status;
    private Date dateRequested;

    public Request(String description, String requestedBy, String buildingName, String roomName, String section, String repairType, String status, Date dateRequested) {
        this.description = description;
        this.requestedBy = requestedBy;
        this.buildingName = buildingName;
        this.roomName = roomName;
        this.section = section;
        this.repairType = repairType;
        this.status = status;
        this.dateRequested = dateRequested;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }
    
    
}