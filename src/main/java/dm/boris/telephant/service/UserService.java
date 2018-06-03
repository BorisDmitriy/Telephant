package dm.boris.telephant.service;

import dm.boris.telephant.domain.Role;
import dm.boris.telephant.domain.User;
import dm.boris.telephant.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

//change or add data about user in database
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepos userRepos;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepos.findByUsername(username);
        if (user==null){
            throw  new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public boolean addUser(User user) {
        User userFromDb = userRepos.findByUsername(user.getUsername());

        if(userFromDb!= null){
                return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        userRepos.save(user);

        return true;

    }

    public List<User> findAll(){
        return userRepos.findAll();
    }

    public void saveUser(User user, String username, Map<String,String> form){

        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepos.save(user);
    }

    public void updateProfile(User user, String password) {
        if(!org.springframework.util.StringUtils.isEmpty(password)) {
            user.setPassword(password);
        }
        userRepos.save(user);
    }
}