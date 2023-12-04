package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.Repo.CreatorRepo;
import ma.xproce.inventoryservice.Repo.VideoRepo;
import ma.xproce.inventoryservice.entities.Creator;
import ma.xproce.inventoryservice.entities.Video;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
    public class VideoGraphQlController {
    private CreatorRepo cr;
    private VideoRepo vr;

    VideoGraphQlController(CreatorRepo creatorRepository, VideoRepo videoRepository) {
        this.cr = creatorRepository;
        this.vr = videoRepository;
    }

    @QueryMapping
    public List<Video> videoList() {
        return vr.findAll();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return cr.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Creator %s not found", id)));
    }

    @MutationMapping
    public Creator saveCreator(@Argument Creator creator) {
        return cr.save(creator);
    }
    @MutationMapping
    public Video saveVideo(@Argument Video video) {
        cr.save(video.getCreator());
        return vr.save(video);
    }
}

