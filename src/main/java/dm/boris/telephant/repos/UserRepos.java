package dm.boris.telephant.repos;

import dm.boris.telephant.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

//find the entire user list or search by username
public interface UserRepos extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
