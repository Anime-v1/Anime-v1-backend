package com.example.animev1backend.repository;

import com.example.animev1backend.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVideoRepository extends JpaRepository<Video, Long> {
}
