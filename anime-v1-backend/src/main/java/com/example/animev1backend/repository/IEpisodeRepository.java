package com.example.animev1backend.repository;


import com.example.animev1backend.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEpisodeRepository extends JpaRepository<Episode, Long> {
    List<Episode> findByVideo_Id(Long videoId);
}
