<%--
 Copyright 2005-2010 The Kuali Foundation
 
 Licensed under the Educational Community License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
 http://www.osedu.org/licenses/ECL-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="documentTypeName" required="true" %>
<%@ attribute name="name" required="true" %>

<div align="right"><kul:help documentTypeName="${documentTypeName}" pageName="Permissions" /></div>

<kra-permissions:assignedRoles name="${name}" /> 
<kra-permissions:users name="${name}" />
<kul:panelFooter />	
	
<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" />
<script language="javascript" src="dwr/interface/KraPersonService.js"></script>
<script>loadPersonName('permissionsHelper.newUser.userName', 'fullname');</script>
