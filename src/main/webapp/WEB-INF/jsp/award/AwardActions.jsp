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

<kul:documentPage
	showDocumentInfo="true"
	htmlFormAction="awardActions"
	documentTypeName="AwardDocument"
	renderMultipart="false"
	showTabButtons="true"
	auditCount="0"
  	headerDispatch="${KualiForm.headerDispatch}"
  	headerTabActive="awardActions"
  	extraTopButtons="${KualiForm.extraTopButtons}" >
  	
  	<div align="right">
  	    <kul:help parameterNamespace="KC-AWARD" parameterDetailType="Document" parameterName="awardActionsHelpUrl" altText="help"/>    
</div>
  	
  	
  	<c:set var="readOnly" value="${not KualiForm.editingMode['fullEntry']}" scope="request" />
  	<c:set var="extraButtons" value="${KualiForm.extraActionsButtons}" scope="request" />
  	<script>
	  $j = jQuery.noConflict();
	</script>
	<!-- KRACOEUS-5477 - the engine can only be included once or it causes errors to the user -->
	<!-- <script language="JavaScript" type="text/javascript" src="dwr/engine.js"></script> -->

	<script language="JavaScript" type="text/javascript" src="dwr/util.js"></script>
		
	<script language="JavaScript" type="text/javascript" src="dwr/interface/AwardHierarchyUIService.js"></script>	

	<link rel="stylesheet" href="css/jquery/new_kuali.css" type="text/css" />
	<link rel="stylesheet" href="css/jquery/kuali-stylesheet.css" type="text/css" />
	<link rel="stylesheet" href="css/jquery/jquery.treeview.css" type="text/css" />
	<script>
	  $j = jQuery.noConflict();
	</script>
    <script type="text/javascript" src="scripts/jquery/jquery.treeview.js"></script>   	
  	
  	  	
<kra-a:awardDataValidation /> 
<%-- <kra:dataValidation auditActivated="${KualiForm.auditActivated}" topTab="true"> --%>
<kra-a:awardHierarchy />
<kra-a:awardSync />
<kra-a:awardPrint />
<kul:adHocRecipients />
<kul:routeLog /> 
<kra:section permission="createAwardAccount">
<kra-a:awardCreateAccount />
</kra:section>
<kul:panelFooter />

<%--
<kul:documentControls transactionalDocument="true" suppressRoutingControls="true" />
--%>

<kul:documentControls transactionalDocument="true"
                      extraButtonSource="${extraButtonSource}"
                      extraButtonProperty="${extraButtonProperty}"
                      extraButtonAlt="${extraButtonAlt}" 
                      extraButtons="${extraButtons}" />

</kul:documentPage>
<script type="text/javascript" src="scripts/awardHierarchyShared.js"></script>
<script type="text/javascript" src="scripts/awardHierarchy.js"></script>		
