package ma.xproce.inventoryservice.Repo;

import ma.xproce.inventoryservice.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video,Long> {
}
