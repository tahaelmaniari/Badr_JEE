package ma.xproce.inventoryservice.Repo;

import ma.xproce.inventoryservice.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface CreatorRepo extends JpaRepository<Creator,Long> {
}
