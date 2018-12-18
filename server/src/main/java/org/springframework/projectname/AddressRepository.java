package org.springframework.projectname;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// This class allows our application to map classes to tables in a database
@RepositoryRestResource
interface AddressRepository extends JpaRepository<Address, Long> {
}