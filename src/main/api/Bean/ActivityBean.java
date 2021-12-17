package main.api.Bean;


import javax.persistence.*;

@Entity
@Table(name = "GEM_activity")
public class ActivityBean {

    //BEAN

    private @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ActivityType_id", referencedColumnName = "id")
    private ActivityTypeBean date;

    @Column(name = "location")
    private String location;
}
