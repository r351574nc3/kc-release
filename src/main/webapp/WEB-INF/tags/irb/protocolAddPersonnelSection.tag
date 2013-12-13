<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="protocolPersonAttributes" value="${DataDictionary.ProtocolPerson.attributes}" />

	<kra:permission value="${KualiForm.personnelHelper.modifyPersonnel}">
    	<kra:uncollapsable tabTitle="Add Person:" tabErrorKey="newProtocolPerson.*" auditCluster="personnelAuditErrors" tabAuditKey="newProtocolPerson*">
          <div align="right">
			<kul:help parameterNamespace="KC-PROTOCOL" parameterDetailType="Document" parameterName="protocolAddPersonnelHelp" altText="help"/>
          </div>
          <div align="center">
            <table  cellpadding="0" cellspacing="0" class="grid" summary="">
              <tr>
                <th class="grid"><div align="right">*Person:</div></th>
                <td nowrap class="grid">
					<c:choose>                  
  						<c:when test="${empty KualiForm.personnelHelper.newProtocolPerson.personId && empty KualiForm.personnelHelper.newProtocolPerson.rolodexId}">
                			<label>Employee Search</label>
                  			<label>
                  				<kul:lookup boClassName="org.kuali.kra.bo.KcPerson" fieldConversions="personId:personnelHelper.newProtocolPerson.personId,fullName:personnelHelper.newProtocolPerson.personName" />
							</label>
							<br>
                  			<label>Non-employee Search</label> 
                  			<label>
                  				<kul:lookup boClassName="org.kuali.kra.bo.NonOrganizationalRolodex" fieldConversions="rolodexId:personnelHelper.newProtocolPerson.rolodexId,fullName:personnelHelper.newProtocolPerson.personName" />
							</label>
  						</c:when>
  						<c:otherwise>
                  			<label>
                  				<kul:htmlControlAttribute property="personnelHelper.newProtocolPerson.personName" attributeEntry="${protocolPersonAttributes.personName}" readOnly="true"/>
							</label>
							<br/>
  						</c:otherwise>
					</c:choose>
                </td>
                <th class="grid"><div align="right">*Protocol Role:</div></th>
                <td class="grid" >
				<c:set var="roleIdAttribute" value="${protocolPersonAttributes.protocolPersonRoleId}" />
                <kul:htmlControlAttribute property="personnelHelper.newProtocolPerson.protocolPersonRoleId" attributeEntry="${protocolPersonAttributes.protocolPersonRoleId}" />
                </td>
              </tr>
            </table>
            <br>
            <html:image property="methodToCall.clearProtocolPerson" src="${ConfigProperties.kr.externalizable.images.url}tinybutton-clear1.gif" title="Clear Fields" alt="Clear Fields" styleClass="tinybutton"/>
            <html:image property="methodToCall.addProtocolPerson" src="${ConfigProperties.kra.externalizable.images.url}tinybutton-addperson.gif" title="Add Protocol Person" alt="Add Protocol Person" styleClass="tinybutton"/>
          </div>
    	</kra:uncollapsable>
	</kra:permission>
    <br/>
