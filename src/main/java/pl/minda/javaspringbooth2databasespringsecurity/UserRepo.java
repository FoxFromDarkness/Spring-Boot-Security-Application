package pl.minda.javaspringbooth2databasespringsecurity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {

    User findAllByUsername(String name);
}

