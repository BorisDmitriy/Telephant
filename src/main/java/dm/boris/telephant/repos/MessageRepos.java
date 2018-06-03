package dm.boris.telephant.repos;

import dm.boris.telephant.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//find the entire list of messages or search by tag
public interface MessageRepos extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);

}