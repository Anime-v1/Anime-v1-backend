package com.example.animev1backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String image;

    @ManyToMany
    @JoinTable(name = "video_category",
    joinColumns = @JoinColumn(name = "video_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Categories> categories;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Episode> episodes;
}
