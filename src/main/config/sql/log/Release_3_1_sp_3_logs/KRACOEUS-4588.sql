delete from SPONSOR_FORM_TEMPLATES where SPONSOR_CODE = '000340' and PACKAGE_NUMBER=5 and PAGE_NUMBER='15';
set define off;
Insert into SPONSOR_FORM_TEMPLATES (OBJ_ID,VER_NBR,SPONSOR_CODE,PACKAGE_NUMBER,PAGE_NUMBER,PAGE_DESCRIPTION,UPDATE_TIMESTAMP,UPDATE_USER,FILE_NAME,CONTENT_TYPE,FORM_TEMPLATE) values (sys_guid(),1,'000340', 5,'15','BioSketch',sysdate,user,'BioSketch.xslt','text/xml',EMPTY_CLOB());
DECLARE    data CLOB; buffer VARCHAR2(30000);
BEGIN
SELECT FORM_TEMPLATE INTO data FROM SPONSOR_FORM_TEMPLATES
WHERE
SPONSOR_CODE = '000340' and PACKAGE_NUMBER=5 and PAGE_NUMBER='15'  FOR UPDATE;
buffer := '<?xml version="1.0" encoding="UTF-8"?>
<!--Designed and generated by Altova StyleVision Enterprise Edition 2008 rel. 2 - see http://www.altova.com/stylevision for more information.-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:output version="1.0" method="xml" encoding="UTF-8" indent="no"/>
	<xsl:param name="SV_OutputFormat" select="''PDF''"/>
	<xsl:variable name="XML" select="/"/>
	<xsl:variable name="fo:layout-master-set">
		<fo:layout-master-set>
			<fo:simple-page-master master-name="default-page" page-height="11in" page-width="8.5in" margin-left="0.79in" margin-right="0.79in">
				<fo:region-body margin-top="0.79in" margin-bottom="0.79in"/>
				<fo:region-before extent="0.79in"/>
				<fo:region-after extent="0.79in"/>
			</fo:simple-page-master>
		</fo:layout-master-set>
	</xsl:variable>
	<xsl:template match="/">
		<fo:root>
			<xsl:copy-of select="$fo:layout-master-set"/>
			<fo:page-sequence master-reference="default-page" initial-page-number="1" format="1">
				<xsl:call-template name="headerall"/>
				<xsl:call-template name="footerall"/>
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<xsl:for-each select="$XML">
							<fo:block/>
							<fo:inline font-family="Verdana" font-size="12pt" font-weight="bold" line-height="12pt">
								<xsl:text>BIOGRAPHICAL SKETCH</xsl:text>
							</fo:inline>
							<fo:block/>
							<fo:inline font-family="Verdana" font-size="10pt" line-height="12pt">
								<xsl:text>NIH provides a fillable PDF form for the Biographical Sketch.&#160; </xsl:text>
							</fo:inline>
							<fo:block/>
							<fo:inline font-family="Verdana" font-size="10pt" line-height="12pt">
								<xsl:text>Alternatively, you can create your own PDF file, using Adobe Acrobat.&#160; </xsl:text>
							</fo:inline>
							<fo:block/>
							<fo:inline font-family="Verdana" font-size="10pt" line-height="12pt">
								<xsl:text>There should be one biosketch for each key person, and all should be named &quot;biosketch.pdf&quot;.</xsl:text>
							</fo:inline>
							<fo:block/>
							<fo:inline font-family="Verdana" font-size="10pt" line-height="12pt">
								<xsl:text>After completion, the forms should be uploaded to Kuali Coeus as part of the Personnel Attachments panel in the Key Personnel tab.</xsl:text>
							</fo:inline>
							<fo:block/>
							<fo:inline font-family="Verdana" font-size="10pt" line-height="12pt">
								<xsl:text>To use the NIH fillable form, select the link below and save the file to your local machine, naming it biosketch.pdf.&#160;&#160;&#160; </xsl:text>
							</fo:inline>
							<fo:block/>
							<fo:inline font-family="Verdana" font-size="10pt" line-height="12pt">
								<xsl:text>The form is located at: </xsl:text>
							</fo:inline>
							<fo:basic-link line-height="12pt" text-decoration="underline" color="blue">
								<xsl:choose>
									<xsl:when test="substring(string(&apos;http://grants.nih.gov/grants/funding/phs398/phs398.html&apos;), 1, 1) = ''#''">
										<xsl:attribute name="internal-destination">
											<xsl:value-of select="substring(string(&apos;http://grants.nih.gov/grants/funding/phs398/phs398.html&apos;), 2)"/>
										</xsl:attribute>
									</xsl:when>
									<xsl:otherwise>
										<xsl:attribute name="external-destination">
											<xsl:text>url(</xsl:text>
											<xsl:call-template name="double-backslash">
												<xsl:with-param name="text">
													<xsl:value-of select="string(&apos;http://grants.nih.gov/grants/funding/phs398/phs398.html&apos;)"/>
												</xsl:with-param>
												<xsl:with-param name="text-length">
													<xsl:value-of select="string-length(string(&';
DBMS_LOB.writeappend(data,LENGTH(buffer),buffer);
END;
/
DECLARE    data CLOB; buffer VARCHAR2(30000);
BEGIN
SELECT FORM_TEMPLATE INTO data FROM SPONSOR_FORM_TEMPLATES
WHERE
SPONSOR_CODE = '000340' and PACKAGE_NUMBER=5 and PAGE_NUMBER='15'  FOR UPDATE;
buffer := 'apos;http://grants.nih.gov/grants/funding/phs398/phs398.html&apos;))"/>
												</xsl:with-param>
											</xsl:call-template>
											<xsl:text>)</xsl:text>
										</xsl:attribute>
									</xsl:otherwise>
								</xsl:choose>
								<fo:inline font-family="Verdana" font-size="10pt">
									<xsl:text>http://grants.nih.gov/grants/funding/phs398/phs398.html</xsl:text>
								</fo:inline>
							</fo:basic-link>
							<fo:inline font-family="Verdana" font-size="10pt" line-height="12pt">
								<xsl:text>.</xsl:text>
							</fo:inline>
						</xsl:for-each>
					</fo:block>
					<fo:block id="SV_RefID_PageTotal"/>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template name="headerall">
		<fo:static-content flow-name="xsl-region-before">
			<fo:block>
				<xsl:for-each select="$XML"/>
			</fo:block>
		</fo:static-content>
	</xsl:template>
	<xsl:template name="footerall">
		<fo:static-content flow-name="xsl-region-after">
			<fo:block>
				<xsl:for-each select="$XML"/>
			</fo:block>
		</fo:static-content>
	</xsl:template>
	<xsl:template name="double-backslash">
		<xsl:param name="text"/>
		<xsl:param name="text-length"/>
		<xsl:variable name="text-after-bs" select="substring-after($text, ''\'')"/>
		<xsl:variable name="text-after-bs-length" select="string-length($text-after-bs)"/>
		<xsl:choose>
			<xsl:when test="$text-after-bs-length = 0">
				<xsl:choose>
					<xsl:when test="substring($text, $text-length) = ''\''">
						<xsl:value-of select="concat(substring($text,1,$text-length - 1), ''\\'')"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="$text"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="concat(substring($text,1,$text-length - $text-after-bs-length - 1), ''\\'')"/>
				<xsl:call-template name="double-backslash">
					<xsl:with-param name="text" select="$text-after-bs"/>
					<xsl:with-param name="text-length" select="$text-after-bs-length"/>
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>';
DBMS_LOB.writeappend(data,LENGTH(buffer),buffer);
END;
/