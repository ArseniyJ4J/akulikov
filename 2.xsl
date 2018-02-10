<?xml version='1.0' encoding='utf-8'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
<xsl:text>&#10;</xsl:text>
<entries>
	<xsl:text>&#10;</xsl:text>
	<xsl:apply-templates/>
</entries>
</xsl:template>
<xsl:template match="field">
	<xsl:text disable-output-escaping="yes"><![CDATA[<entry field="]]></xsl:text>
	<xsl:value-of select="normalize-space(.)"/>
	<xsl:text disable-output-escaping="yes"><![CDATA["/>]]></xsl:text>
	<xsl:text>&#10;</xsl:text>
</xsl:template>
</xsl:stylesheet>