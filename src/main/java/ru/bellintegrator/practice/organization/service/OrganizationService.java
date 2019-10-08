package ru.bellintegrator.practice.organization.service;

import java.util.List;

import ru.bellintegrator.practice.view.OrganizationFilter;
import ru.bellintegrator.practice.view.OrganizationListView;
import ru.bellintegrator.practice.view.OrganizationSaveView;
import ru.bellintegrator.practice.view.OrganizationUpdateView;
import ru.bellintegrator.practice.view.OrganizationView;
import ru.bellintegrator.practice.view.SuccessView;

public interface OrganizationService {

    OrganizationView findById(Integer id);

    List<OrganizationListView> all(OrganizationFilter organizationFilter);

    SuccessView save(OrganizationSaveView orgView);

    SuccessView update(OrganizationUpdateView orgView);

}