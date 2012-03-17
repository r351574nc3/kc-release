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

<%@ attribute name="proposalPerson" description="The ProposalPerson which this is for." required="true" %>
<%@ attribute name="index" description="Index of the property for a ProposalPerson" required="false" %>
<%@ attribute name="personIndex" description="Index of a ProposalPerson" required="true" %>

<c:set var="proposalPersonAttributes" value="${DataDictionary.ProposalPerson.attributes}" />
<c:set var="viewOnly" value="${KualiForm.editingMode['viewOnly']}" />
<c:set var="isParent" value="${KualiForm.document.developmentProposalList[0].parent}" /> 

