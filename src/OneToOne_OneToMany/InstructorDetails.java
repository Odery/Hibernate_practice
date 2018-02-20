package OneToOne_OneToMany;

import javax.persistence.*;
import java.io.Serializable;

@Entity @Table(name = "instructor_detail")
public class InstructorDetails implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    private String hobby;
    @OneToOne(mappedBy = "details",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetails() {
    }

    public InstructorDetails(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public InstructorDetails(String youtubeChannel, String hobby, Instructor instructor) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetails: " +
                "youtubeChannel= '" + youtubeChannel + '\'' +
                ", hobby= '" + hobby + '\'';
    }
}
