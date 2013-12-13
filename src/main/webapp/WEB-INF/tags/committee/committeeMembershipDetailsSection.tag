<%@ include file="/WEB-INF/jsp/committee/committeeMember.jsp"%>

<c:set var="action" value="committeeMembership" />

<table border="0" cellpadding="0" cellspacing="0" summary="">
    <tr>
        <td>
            <kul:innerTab tabTitle="Person Details" 
                          parentTab="${parentTabValue}" 
                          defaultOpen="false"
                          useCurrentTabIndexAsKey="true" 
                          tabErrorKey="document.committeeList[0].committeeMemberships[${memberIndex}].membershipTypeCode,document.committeeList[0].committeeMemberships[${memberIndex}].termStartDate,document.committeeList[0].committeeMemberships[${memberIndex}].termEndDate">
                <div class="innerTab-container" align="left">
                    <table border="0" class=tab cellpadding="0" cellspacing="0" summary=""> 
                        <tr>
                            <th>
                                <div align="right">
                                    <kul:htmlAttributeLabel attributeEntry="${committeeMembershipAttributes.personName}" />
                                </div>
                            </th>
                            <td align="left">
                                <kul:htmlControlAttribute property="${committeeMembership}.personName" 
                                                          attributeEntry="${committeeMembershipAttributes.personName}" 
                                                          readOnly="true" />
                            </td>
                            <th align="left">
                                <div align="right">
                                    <kul:htmlAttributeLabel attributeEntry="${committeeMembershipAttributes.termStartDate}" />
                                </div>
                            </th>
                            <td align="left">
                                <kul:htmlControlAttribute property="${committeeMembership}.termStartDate" 
                                                          attributeEntry="${committeeMembershipAttributes.termStartDate}" 
                                                          
                                                          readOnly="${readOnly}" />
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <div align="right">
                                    <kul:htmlAttributeLabel attributeEntry="${committeeMembershipAttributes.membershipTypeCode}" />
                                </div>
                            </th>
                            <td align="left">
                                <kul:htmlControlAttribute property="${committeeMembership}.membershipTypeCode" 
                                                          attributeEntry="${committeeMembershipAttributes.membershipTypeCode}"
                                                          readOnlyAlternateDisplay="${KualiForm.document.committeeList[0].committeeMemberships[memberIndex].membershipType.description}"
                                                          readOnly="${readOnly}" />
                                <br />
                                <kul:htmlControlAttribute property="${committeeMembership}.paidMember" 
                                                          attributeEntry="${committeeMembershipAttributes.paidMember}" 
                                                          readOnly="${readOnly}" />
                                (paid member)
                            </td>
                            <th>
                                <div align="right">
                                    <kul:htmlAttributeLabel attributeEntry="${committeeMembershipAttributes.termEndDate}" />
                                </div>
                            </th>
                            <td align="left">
                                <kul:htmlControlAttribute property="${committeeMembership}.termEndDate" 
                                                          attributeEntry="${committeeMembershipAttributes.termEndDate}"
                                                          
                                                          readOnly="${readOnly}" />
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <div align="right">
                                    <kul:htmlAttributeLabel attributeEntry="${committeeMembershipAttributes.contactNotes}" />
                                </div>
                            </th>
                            <td align="left">
                                <kul:htmlControlAttribute property="${committeeMembership}.contactNotes" 
                                                          attributeEntry="${committeeMembershipAttributes.contactNotes}" 
                                                          readOnly="${readOnly}" />
                            </td>
                            <th>
                                <div align="right">
                                    <kul:htmlAttributeLabel attributeEntry="${committeeMembershipAttributes.trainingNotes}" />
                                </div>
                            </th>
                            <td align="left">
                                <kul:htmlControlAttribute property="${committeeMembership}.trainingNotes" 
                                                          attributeEntry="${committeeMembershipAttributes.trainingNotes}"
                                                          readOnly="${readOnly}" />
                            </td>
                        </tr>
                    </table>
                </div>
            </kul:innerTab>
        </td>
    </tr>
</table>