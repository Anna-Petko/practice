package ru.bellintegrator.practice.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.bellintegrator.practice.organization.model.Organization;

@Repository

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

}
