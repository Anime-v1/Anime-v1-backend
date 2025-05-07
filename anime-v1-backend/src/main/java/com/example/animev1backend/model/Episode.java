package com.example.animev1backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "episode")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long numEpisode;

    @Column(name = "link_episode",columnDefinition = "TEXT")
    private String linkEpisode;

    @ManyToOne
    @JoinColumn(name = "video_id")
    @JsonBackReference
    private Video video;

}
