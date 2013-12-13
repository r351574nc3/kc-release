<%--
 Copyright 2005-2013 The Kuali Foundation

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
 

<jsp:useBean id="paramMap" class="java.util.HashMap"/>
<c:set var="attributes" value="${DataDictionary.IacucProtocolAssignCmtBean.attributes}" />

<kra:permission value="${KualiForm.actionHelper.canAssignCmt}">


<kul:innerTab tabTitle="Assign to Committee" parentTab="" defaultOpen="false" tabErrorKey="actionHelper.protocolAssignCmtBean*">
    <div class="innerTab-container" align="left">
        <table class="tab" cellpadding="0" cellspacing="0" summary=""> 
            <tbody>
                <tr>
	                <th style="width: 150px"> 
	                    <div align="right">
	                        <kul:htmlAttributeLabel attributeEntry="${attributes.committeeId}" />
	                    </div>
	                </th>
	                <td style="width : 150px">
                        <c:set target="${paramMap}" property="currentCommitteeId" value="${KualiForm.actionHelper.protocolAssignCmtBean.committeeId}" />
                        <c:set target="${paramMap}" property="docRouteStatus" value="${KualiForm.document.documentHeader.workflowDocument.status.code}" />	                
                        <c:set target="${paramMap}" property="protocolLeadUnit" value="${KualiForm.document.protocol.leadUnitNumber}" />	                
	                    <c:set var="docNumber" value="${KualiForm.document.protocol.protocolNumber}" />
                        <html:select property="actionHelper.protocolAssignCmtBean.committeeId" >                               
                            <c:forEach items="${krafn:getOptionList('org.kuali.kra.iacuc.committee.lookup.keyvalue.IacucCommitteeIdByUnitValuesFinder', paramMap)}" var="option" >
                                <c:choose>                      
                                    <c:when test="${KualiForm.actionHelper.protocolAssignCmtBean.committeeId == option.key}">
                                        <option value="${option.key}" selected="selected">${option.value}</option>
                                    </c:when>
                                    <c:otherwise>                               
                                        <c:out value="${option.value}"/>
                                        <option value="${option.key}">${option.value}</option>
                                    </c:otherwise>
                                </c:choose>                                                
                            </c:forEach>
                        </html:select>
	                </td>
	            </tr>
                
                <tr>
					<td align="center" colspan="4">
						<div align="center">
							<html:image property="methodToCall.assignCommittee.anchor${tabKey}"
							            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-submit.gif' styleClass="tinybutton"/>
						</div>
	                </td>
                </tr>
            </tbody>
        </table>
    </div>
    
</kul:innerTab>
</kra:permission>