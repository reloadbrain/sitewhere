/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.grpc.client.user;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sitewhere.grpc.client.cache.CacheProvider;
import com.sitewhere.spi.microservice.IMicroservice;
import com.sitewhere.spi.user.IGrantedAuthority;
import com.sitewhere.spi.user.IUser;

/**
 * Cache providers for user management entities.
 * 
 * @author Derek
 */
public class UserManagementCacheProviders {

    /** Cache id for user cache */
    public static final String ID_USER_CACHE = "user";

    /** Cache id for granted authorities cache */
    public static final String ID_GRANTED_AUTHORITIES_CACHE = "grau";

    /**
     * Cache for users.
     * 
     * @author Derek
     */
    public static class UserCache extends CacheProvider<String, IUser> {

	/** Static logger instance */
	private static Log LOGGER = LogFactory.getLog(UserCache.class);

	public UserCache(IMicroservice microservice, boolean createOnStartup) {
	    super(microservice, ID_USER_CACHE, createOnStartup);
	}

	/*
	 * @see com.sitewhere.spi.server.lifecycle.ILifecycleComponent#getLogger()
	 */
	@Override
	public Log getLogger() {
	    return LOGGER;
	}
    }

    /**
     * Cache for user granted authorities.
     * 
     * @author Derek
     */
    public static class GrantedAuthoritiesCache extends CacheProvider<String, List<IGrantedAuthority>> {

	/** Static logger instance */
	private static Log LOGGER = LogFactory.getLog(GrantedAuthoritiesCache.class);

	public GrantedAuthoritiesCache(IMicroservice microservice, boolean createOnStartup) {
	    super(microservice, ID_GRANTED_AUTHORITIES_CACHE, createOnStartup);
	}

	/*
	 * @see com.sitewhere.spi.server.lifecycle.ILifecycleComponent#getLogger()
	 */
	@Override
	public Log getLogger() {
	    return LOGGER;
	}
    }
}