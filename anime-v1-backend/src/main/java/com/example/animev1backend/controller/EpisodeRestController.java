package com.example.animev1backend.controller;

import com.example.animev1backend.model.Episode;
import com.example.animev1backend.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodes")
@CrossOrigin(origins = "*")
public class EpisodeRestController {
    @Autowired
    private IEpisodeService episodeService;

    @GetMapping
    public ResponseEntity<List<Episode>> getAllEpisodes() {
        return ResponseEntity.ok(episodeService.findAll());
    }

    @GetMapping("/video/{videoId}")
    public ResponseEntity<List<Episode>> getEpisodesByVideoId(@PathVariable Long videoId) {
        List<Episode> episodes = episodeService.findByVideoId(videoId);
        return ResponseEntity.ok(episodes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Episode> getEpisodeById(@PathVariable Long id) {
        Episode episode = episodeService.findById(id);
        if (episode != null) {
            return ResponseEntity.ok(episode);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Episode> createEpisode(@RequestBody Episode episode) {
        return ResponseEntity.ok(episodeService.createEpisode(episode));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Episode> updateEpisode(@PathVariable Long id, @RequestBody Episode episode) {
        Episode updated = episodeService.updateEpisode(id, episode);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpisode(@PathVariable Long id) {
        episodeService.deleteEpisode(id);
        return ResponseEntity.noContent().build();
    }
}
