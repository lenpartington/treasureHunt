package com.tresor.application.manager.mapping;

import java.util.List;

import com.tresor.application.manager.domain.DomainObjectManager;

public interface ObjectMapper {

	DomainObjectManager createDomain(List<String> data);

	List<String> domainToString(DomainObjectManager domainObjects);

	
	
	
	
}
