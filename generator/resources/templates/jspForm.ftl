<#assign class_name_cap = class.name?cap_first>
<#assign class_name = class.name?uncap_first>
<#assign class_name_id = "${" + class_name + ".id" + "}">
<#assign class_name_plural = class_name + "s">

<#assign opening_bracket = "${">
<#assign closing_bracket = "}">
<#macro print_complex_property prop>
	<#local property_name_url = prop.type.name?uncap_first />
	<#local property_name = prop.name />
    <#local property_name_plural = property_name + "s">
	<#local property_name_cap = property_name?cap_first />
	<#local property_id = "${" + class_name + "." + property_name + ".id" + "}" />
                        <td><a href="<c:url value="/${property_name_url}/${property_id}"/>">${property_name_cap} ${property_id}</a></td>
</#macro>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <body>
    <%@include file="navbar.jsp"%>
    <div class="container">
      <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 border p-4">
          <h5 class="text-center">${class.name?cap_first} form</h5>
        </div>
        <div class="col-md-3"></div>
        <div class="col-md-6 border p-4">
          <form:form class="p-2" action="${opening_bracket}action${closing_bracket}" method="post" modelAttribute="${class_name?uncap_first}">
                <#list properties as property>
                    <#assign label= "<form:label path=\"${property.name}\">${property.name?cap_first}</form:label>">
                    <#if enum_types?seq_contains(property.type)>
                    	${label}
                        <form:select path="${property.name}" cssClass="form-control">
                            <option value="">Select a ${property.name}</option>

                            <c:set var="enum_val"><#list enum_values[property.type] as val>${val}<#sep>,</#sep></#list></c:set>
                            <c:forEach items="${opening_bracket}enum_val${closing_bracket}" var="val">
        				        <option value="${opening_bracket}val${closing_bracket}" <c:if test="${opening_bracket} val == ${class_name}.${property.name} ${closing_bracket}">selected</c:if>  >${opening_bracket}val${closing_bracket}</option>
       				        </c:forEach>
                        </form:select>	
                    <#else>
                    <#if property.type == "Boolean" || property.type == "boolean">
                    <div class="form-group">
                        <form:checkbox path="${property.name}" />
                        ${label}
                    </div>
                    <#elseif property.type == "String" || property.type == "string" || property.type == "Long" || property.type == "long" || property.type == "date" || property.type == "Date">
                    <div class="form-group">
                        ${label}
                        <form:input cssClass="form-control" path="${property.name}" />
                    </div>
                    </#if>
                    </#if>
                </#list>

                <#list referencedProperties as property>
                    <#assign label= "<form:label path=\"${property.name}\">${property.name?cap_first}</form:label>">
                    <#if property.upper == 1 && property.oppositeEnd== -1>
                        <div class="form-group">
                            ${label}
                            <form:select path="${property.name}" cssClass="form-control">
                                <option value="-1">Select a ${property.name}</option>
                                <form:options items="${opening_bracket}${class_name?uncap_first}.${property.name?uncap_first}${closing_bracket}" itemValue="id"/>
                            </form:select>
                        </div>
                     <#elseif property.upper == -1>
                        <div class="form-group ">
                        ${label}
                        <form:checkboxes items="${opening_bracket}${class_name?uncap_first}.${property.name?uncap_first}${closing_bracket}" path="${property.name}" element="div class='checkbox border rounded p-2' " itemValue="id"/>
                        </div>
                    </#if>

                </#list>
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>