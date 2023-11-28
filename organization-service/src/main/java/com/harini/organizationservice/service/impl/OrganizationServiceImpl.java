package com.harini.organizationservice.service.impl;

import lombok.AllArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harini.organizationservice.dto.OrganizationDto;
import com.harini.organizationservice.entity.Organization;
import com.harini.organizationservice.repository.OrganizationRepository;
import com.harini.organizationservice.service.OrganizationService;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
         Organization organization=new Organization(
        		 organizationDto.getId(),
        		 organizationDto.getOrganizationName(),
        		 organizationDto.getOrganizationDescription(),
        		 organizationDto.getOrganizationCode(),
        		 organizationDto.getCreatedDate()
        	);
         Organization savedOrganization=organizationRepository.save(organization);
        
         OrganizationDto savedOrganizationDto = new OrganizationDto(
        		savedOrganization.getId(),
        		savedOrganization.getOrganizationName(),
        		savedOrganization.getOrganizationDescription(),
        		savedOrganization.getOrganizationCode(),
        		savedOrganization.getCreatedDate()
        		 );

         return savedOrganizationDto;
     }
    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) { 
   
    	Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
    

    OrganizationDto organizationDto = new OrganizationDto(
    		organization.getId(),
    		organization.getOrganizationName(),
    		organization.getOrganizationDescription(),
    		organization.getOrganizationCode(),
    		organization.getCreatedDate()
    		
        
        );
        return organizationDto;
}
}
