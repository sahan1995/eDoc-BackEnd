package lk.eDoc.entity;

import javax.persistence.*;

@Entity
public class PatientChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "G1")
    @TableGenerator(name = "G1",table = "AutoIncermant",allocationSize = 1,valueColumnName = "nextID")
    private int chatroomID;

    private String chatRoomName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientID",referencedColumnName = "PID")
    private Patient patient;


    public int getChatroomID() {
        return chatroomID;
    }

    public void setChatroomID(int chatroomID) {
        this.chatroomID = chatroomID;
    }

    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientChatRoom(String chatRoomName, Patient patient) {
        this.chatRoomName = chatRoomName;
        this.patient = patient;
    }

    public PatientChatRoom() {
    }

    @Override
    public String toString() {
        return "PatientChatRoom{" +
                "chatroomID=" + chatroomID +
                ", chatRoomName='" + chatRoomName + '\'' +
                ", patient=" + patient +
                '}';
    }
}
