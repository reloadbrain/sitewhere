/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.device.command.CommandParameter;
import com.sitewhere.spi.device.command.ICommandParameter;
import com.sitewhere.spi.device.command.IDeviceCommand;
import com.sitewhere.spi.device.command.ParameterType;
import com.sitewhere.spi.device.request.IDeviceCommandCreateRequest;

/**
 * Arguments needed to create a new device command.
 * 
 * @author Derek
 */
@JsonInclude(Include.NON_NULL)
public class DeviceCommandCreateRequest implements IDeviceCommandCreateRequest, Serializable {

    /** Serialization version identifier */
    private static final long serialVersionUID = 7791276552702413783L;

    /** Unqiue token */
    private String token;

    /** Optional namespace */
    private String namespace;

    /** Command name */
    private String name;

    /** Command description */
    private String description;

    /** Command parameters */
    private List<CommandParameter> parameters = new ArrayList<CommandParameter>();

    /** Metadata values */
    private Map<String, String> metadata;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#getToken()
     */
    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#getNamespace
     * ()
     */
    @Override
    public String getNamespace() {
	return namespace;
    }

    public void setNamespace(String namespace) {
	this.namespace = namespace;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#
     * getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#
     * getParameters()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ICommandParameter> getParameters() {
	return (List<ICommandParameter>) (List<? extends ICommandParameter>) parameters;
    }

    public void setParameters(List<CommandParameter> parameters) {
	this.parameters = parameters;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#getMetadata(
     * )
     */
    public Map<String, String> getMetadata() {
	return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
	this.metadata = metadata;
    }

    public static class Builder {

	/** Request being built */
	private DeviceCommandCreateRequest request = new DeviceCommandCreateRequest();

	public Builder(IDeviceCommand api) {
	    request.setToken(api.getToken());
	    request.setName(api.getName());
	    request.setDescription(api.getDescription());
	    request.setNamespace(api.getNamespace());
	    request.getParameters().addAll(api.getParameters());
	    request.setMetadata(new HashMap<String, String>());
	    request.getMetadata().putAll(api.getMetadata());
	}

	public Builder(String token, String namespace, String name) {
	    request.setToken(token);
	    request.setNamespace(namespace);
	    request.setName(name);
	}

	public Builder withDescription(String description) {
	    request.setDescription(description);
	    return this;
	}

	public Builder withStringParameter(String name, boolean required) {
	    request.getParameters().add(new CommandParameter(name, ParameterType.String, required));
	    return this;
	}

	public Builder withIntParameter(String name, boolean required) {
	    request.getParameters().add(new CommandParameter(name, ParameterType.Int64, required));
	    return this;
	}

	public Builder withDoubleParameter(String name, boolean required) {
	    request.getParameters().add(new CommandParameter(name, ParameterType.Double, required));
	    return this;
	}

	public Builder withBooleanParameter(String name, boolean required) {
	    request.getParameters().add(new CommandParameter(name, ParameterType.Bool, required));
	    return this;
	}

	public Builder withParameter(String name, ParameterType type, boolean required) {
	    request.getParameters().add(new CommandParameter(name, type, required));
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public DeviceCommandCreateRequest build() {
	    return request;
	}
    }
}