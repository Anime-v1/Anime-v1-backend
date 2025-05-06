package com.example.animev1backend.service;

import com.example.animev1backend.model.Video;

import java.util.List;
import java.util.Optional;

public interface IVideoService {
    Video saveVideo(Video video);
    List<Video> getAllVideos();
    Optional<Video> getVideoById(Long id);
    Video updateVideo(Long id, Video updatedVideo);
    void deleteVideo(Long id);
}

