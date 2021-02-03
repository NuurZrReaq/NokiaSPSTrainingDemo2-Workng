package project.nokiaspstraining.demo.rest.repositories;

import org.springframework.data.aerospike.repository.AerospikeRepository;
import project.nokiaspstraining.demo.wsdl.User;

public interface UserRepoAerospike extends AerospikeRepository<User,Integer> {
}
