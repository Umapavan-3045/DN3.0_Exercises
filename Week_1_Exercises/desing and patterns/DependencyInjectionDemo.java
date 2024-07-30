interface UserRepository {
    String getUserById(String userId);
}

// Implement Concrete Repository
class UserRepositoryImpl implements UserRepository {
    public String getUserById(String userId) {
        // Mock implementation, in a real scenario, it would interact with a database
        if (userId.equals("1")) {
            return "Alice Johnson";
        } else {
            return "User not found";
        }
    }
}

// Define Service Class
class UserService {
    private UserRepository userRepository;

    // Implement Dependency Injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String fetchUserDetails(String userId) {
        return userRepository.getUserById(userId);
    }
}

// Test the Dependency Injection Implementation
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // Create a UserRepository instance
        UserRepository userRepository = new UserRepositoryImpl();

        // Inject the repository into the service
        UserService userService = new UserService(userRepository);

        // Use the service to find user details
        String userDetails = userService.fetchUserDetails("1");
        System.out.println("User Details: " + userDetails);
    }
}
