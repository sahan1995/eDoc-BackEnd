package lk.eDoc.dto;

public class SymptomDTO {

    private
    String syID;
    private String name;

    public String getSyID() {
        return syID;
    }

    public void setSyID(String syID) {
        this.syID = syID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SymptomDTO(String syID, String name) {
        this.syID = syID;
        this.name = name;
    }

    public SymptomDTO() {
    }

    @Override
    public String toString() {
        return "SymptomDTO{" +
                "syID='" + syID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
