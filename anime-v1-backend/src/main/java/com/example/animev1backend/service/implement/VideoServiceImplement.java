package com.example.animev1backend.service.implement;

import com.example.animev1backend.model.Video;
import com.example.animev1backend.repository.IVideoRepository;
import com.example.animev1backend.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImplement implements IVideoService {

    @Autowired
    private IVideoRepository videoRepository;

    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    public List<Video>getAllVideos() {
        return videoRepository.findAll();
    }

    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }

    public Video updateVideo(Long id, Video updatedVideo) {
        return videoRepository.findById(id).map(video -> {
            video.setTitle(updatedVideo.getTitle());
            video.setDescription(updatedVideo.getDescription());
            video.setImage(updatedVideo.getImage());
            video.setCategories(updatedVideo.getCategories());
            return videoRepository.save(video);
        }).orElseThrow(() -> new RuntimeException("Video not found with id: " + id));
    }

    @Override
    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }

}
