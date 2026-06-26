package mockitoPractice;
import org.springframework.data.jpa.repository.JpaRepository;
import mockitoPractice.User;
public interface UserRepository extends JpaRepository<User, Long> 
{
	
}
