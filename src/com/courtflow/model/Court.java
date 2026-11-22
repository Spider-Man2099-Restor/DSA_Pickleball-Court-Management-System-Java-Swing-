
package com.courtflow.model;

public class Court {
    
    private String courtNumber;
    private String courtStatus;
    private String courtNote;
    
    public String getCourtNote() {
        return courtNote;
    }

    public void setCourtNote(String courtNote) {
        this.courtNote = courtNote;
    }

    public String isCourtStatus() {
        return courtStatus;
    }
    public void setCourtStatus(String courtStatus) {
        this.courtStatus = courtStatus;
    }
    
    public String getCourtNumber() {
        return courtNumber;
    }


    public void setCourtNumber(String courtNumber) {
        this.courtNumber = courtNumber;
    }

    public Court(String courtNumber, String courtStatus, String courtNote) {
        this.courtNumber = courtNumber;
        this.courtStatus = courtStatus;
        this.courtNote = courtNote;
    }

}
