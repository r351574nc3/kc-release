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

<c:set var="attributes" value="${DataDictionary.ProtocolAssignCmtSchedBean.attributes}" />
<c:set var="action" value="protocolProtocolActions" />

<jsp:useBean id="paramMap" class="java.util.HashMap"/>

<kra:permission value="${KualiForm.actionHelper.canAssignCmtSched}">

<kul:innerTab tabTitle="Assign to Committee and Schedule" parentTab="" defaultOpen="false" tabErrorKey="actionHelper.assignCmtSchedBean*">
    <div class="innerTab-container" align="left">
        <table class="tab" cellpadding="0" cellspacing="0" summary=""> 
            <tbody>
                <tr>
	                <th style="width: 300px"> 
	                    <div align="right">
	                        <kul:htmlAttributeLabel attributeEntry="${attributes.committeeId}" />
	                    </div>
	                </th>
	                <td style="width : 150px">
                        <c:set target="${paramMap}" property="currentCommitteeId" value="${KualiForm.actionHelper.assignCmtSchedBean.committeeId}" />
                        <c:set target="${paramMap}" property="docRouteStatus" value="${KualiForm.document.documentHeader.workflowDocument.routeHeader.docRouteStatus}" />	                
	                    <c:set var="docNumber" value="${KualiForm.document.protocol.protocolNumber}" />
                        <html:select property="actionHelper.assignCmtSchedBean.committeeId" onchange="onlyLoadScheduleDates('actionHelper.assignCmtSchedBean.committeeId', '${docNumber}', 'actionHelper.assignCmtSchedBean.scheduleId');" >                               
                            <c:forEach items="${krafn:getOptionList('org.kuali.kra.committee.lookup.keyvalue.CommitteeIdByUnitValuesFinder', paramMap)}" var="option" >
                                <c:choose>                      
                                    <c:when test="${KualiForm.actionHelper.assignCmtSchedBean.committeeId == option.key}">
                                        <option value="${option.key}" selected="selected">${option.label}</option>
                                    </c:when>
                                    <c:otherwise>                               
                                        <c:out value="${option.label}"/>
                                        <option value="${option.key}">${option.label}</option>
                                    </c:otherwise>
                                </c:choose>                                                
                            </c:forEach>
                        </html:select>
	                </td>
	               
		            <th style="width: 150px"> 
		                <div align="right"><nobr>
		                    <kul:htmlAttributeLabel attributeEntry="${attributes.scheduleId}" /></nobr>
		                </div>
		            </th>
		            <td>
		               <nobr>
				           <kul:htmlControlAttribute property="actionHelper.assignCmtSchedBean.scheduleId" 
				                                         attributeEntry="${attributes.scheduleId}" />
				            <noscript>
                            <html:image property="methodToCall.refreshPage.anchor${tabKey}"
                                        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-refresh.gif' styleClass="tinybutton"/>
                            </noscript>
		               </nobr>
		            </td>
	            </tr>
                
                <tr>
					<td align="center" colspan="4">
						<div align="center">
							<html:image property="methodToCall.assignCommitteeSchedule.anchor${tabKey}"
							            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-submit.gif' styleClass="tinybutton"/>
						</div>
	                </td>
                </tr>
            </tbody>
        </table>
    </div>
    
</kul:innerTab>

</kra:permission>
