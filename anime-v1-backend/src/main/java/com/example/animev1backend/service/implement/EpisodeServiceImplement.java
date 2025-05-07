package com.example.animev1backend.service.implement;

import com.example.animev1backend.model.Episode;
import com.example.animev1backend.repository.IEpisodeRepository;
import com.example.animev1backend.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeServiceImplement implements IEpisodeService {

    @Autowired
    private IEpisodeRepository episodeRepository;

    public List<Episode>findAll(){
        return episodeRepository.findAll();
    }

    @Override
    public List<Episode> findByVideoId(Long videoId) {
        return episodeRepository.findByVideo_Id(videoId);
    }

    public Episode findById(Long id){
        Optional<Episode> episode = episodeRepository.findById((long) id);
        return episode.orElse(null);
    }

    public Episode createEpisode(Episode episode){
        return episodeRepository.save(episode);
    }

    @Override
    public Episode updateEpisode(Long id, Episode episode) {
        Optional<Episode> existing = episodeRepository.findById(id);
        if (existing.isPresent()) {
            Episode ep = existing.get();
            ep.setNumEpisode(episode.getNumEpisode());
            ep.setLinkEpisode(episode.getLinkEpisode());
            ep.setVideo(episode.getVideo());
            return episodeRepository.save(ep);
        }
        return null;
    }

    @Override
    public void deleteEpisode(Long id) {
        episodeRepository.deleteById(id);
    }
}
