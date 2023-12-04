package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.Repo.CreatorRepo;
import ma.xproce.inventoryservice.Repo.VideoRepo;
import ma.xproce.inventoryservice.entities.Creator;
import ma.xproce.inventoryservice.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {
	public List<Video> videos;
	@Autowired
	private CreatorRepo cr;
	@Autowired
	private VideoRepo vr;

	public static void main(String[] args) {



		SpringApplication.run(InventoryServiceApplication.class, args);


	}
	@Bean
	CommandLineRunner start()
	{
		return args -> {
			Creator creator = Creator.builder()
					.name("Taha EL MANIARI")
					.email("telmaniari@gmail.com")
					.build();
			Creator creator1 = Creator.builder()
					.name("Yassine EL MANIARI")
					.email("yassineelmaniari@gmail.com")
					.build();
			Creator creator2 = Creator.builder()
					.name("ibtissam jouiad")
					.email("ibtissamjouiad@gmail.com")
					.build();
			Creator creator3 = Creator.builder()
					.name("Soufiane EL MANIARI")
					.email("soufianeelmaniari@gmail.com")
					.build();
			Video v =  Video.builder()
					.name("TahaVideo")
					.url("http://tahavideo.com")
					.description("Il s'agit d'un video sur l'IA")
					.datePublication(new Date())
					.creator(creator)
					.build();
			Video v1= Video.builder()
					.name("YassineVideo")
					.url("http://yassinevideo.com")
					.description("Il s'agit d'un video sur l'IA")
					.datePublication(new Date())
					.creator(creator)
					.build();
			Video v2 =  Video.builder()
					.name("SalmaVideo")
					.url("http://salmavideo.com")
					.description("Il s'agit d'un video sur l'IA")
					.datePublication(new Date())
					.creator(creator3)
					.build();
			Video v3 = Video.builder()
					.name("HishamVideo")
					.url("http://hishamvideo.com")
					.description("Il s'agit d'un video sur l'IA")
					.datePublication(new Date())
					.creator(creator2)
					.build();
			Video v4 =  Video.builder()
					.name("WafaaVideo")
					.url("http://wafaavideo.com")
					.description("Il s'agit d'un video sur l'IA")
					.datePublication(new Date())
					.creator(creator1)
					.build();
			Video v5 = Video.builder()
					.name("ChaimaaVideo")
					.url("http://chaimaavideo.com")
					.description("Il s'agit d'un video sur l'IA")
					.datePublication(new Date())
					.creator(creator)
					.build();
			videos= new ArrayList<>();
			videos.add(v);
			videos.add(v1);
			videos.add(v2);
			videos.add(v3);
			videos.add(v4);
			videos.add(v5);
			creator.setVideos(videos);
			cr.save(creator);
			cr.save(creator1);
			cr.save(creator2);
			cr.save(creator3);
			vr.save(v);
			vr.save(v1);
			vr.save(v2);
			vr.save(v3);
			vr.save(v4);
			vr.save(v5);
		};
	}

}
