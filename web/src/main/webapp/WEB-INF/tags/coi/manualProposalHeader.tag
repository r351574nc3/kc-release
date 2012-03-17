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
<%@ attribute name="idx" required="true" description="Coi disl project list index" %>
<%@ attribute name="disclProject" required="true" type="org.kuali.kra.coi.CoiDisclProject" %>

<c:set var="coiDisclProjectAttributes" value="${DataDictionary.CoiDisclProject.attributes}" />
<c:set var="coiDiscDetailAttributes" value="${DataDictionary.CoiDiscDetail.attributes}" />
                <div>
                <h3>
    		        <span class="subhead-left">Proposal Number: ${KualiForm.document.coiDisclosureList[0].coiDisclProjects[idx].coiProjectId}</span>
    		        <span class="subhead-right"><kul:help businessObjectClassName="org.kuali.kra.coi.CoiDiscDetail" altText="help"/></span>
                </h3>
              
                    <table class=tab cellpadding="0" cellspacing="0" summary="">
                        <tbody>
                        <%-- Header --%>
                                 <tr>
                                    <th><div align="right">Proposal Name</div></th> 
                  <td align="left" valign="middle">
					<div align="left">
                		<kul:htmlControlAttribute property="document.coiDisclosureList[0].coiDisclProjects[${idx}].coiProjectTitle" readOnly="true" attributeEntry="${coiDisclProjectAttributes.coiProjectTitle}" /> 
					</div>
				  </td>
                                    <th><div align="right">Sponsor</div></th> 
                  <td align="left" valign="middle">
					<div align="left">
                		<kul:htmlControlAttribute property="document.coiDisclosureList[0].coiDisclProjects[${idx}].coiProjectSponsor" readOnly="true" attributeEntry="${coiDisclProjectAttributes.coiProjectSponsor}" /> 
					</div>
				  </td>
                                  </tr>
                                  <tr>
                                    <th><div align="right">start Date</div></th> 
                  <td align="left" valign="middle">
					<div align="left">
                		<kul:htmlControlAttribute property="document.coiDisclosureList[0].coiDisclProjects[${idx}].coiProjectStartDate" readOnly="true" attributeEntry="${coiDisclProjectAttributes.coiProjectStartDate}" /> 
					</div>
				  </td>
                                    <th><div align="right">End Date</div></th> 
                 <td align="left" valign="middle">
					<div align="left">
                		<kul:htmlControlAttribute property="document.coiDisclosureList[0].coiDisclProjects[${idx}].coiProjectEndDate" readOnly="true" attributeEntry="${coiDisclProjectAttributes.coiProjectEndDate}" /> 
					</div>
				  </td>
	            </tr>

               </table>
               </div>