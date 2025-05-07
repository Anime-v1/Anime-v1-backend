package com.example.animev1backend.service;

import com.example.animev1backend.model.Episode;

import java.util.List;

public interface IEpisodeService {
    List<Episode> findAll();
    Episode findById(Long id);
    List<Episode> findByVideoId(Long videoId);
    Episode createEpisode(Episode episode);
    Episode updateEpisode(Long id, Episode episode);
    void deleteEpisode(Long id);
}
