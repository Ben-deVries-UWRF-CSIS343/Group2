package org.springframework.projectname;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface AddressRepository extends JpaRepository<Address, Long> {
}