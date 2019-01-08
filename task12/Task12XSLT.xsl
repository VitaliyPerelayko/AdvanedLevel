<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
    <xsl:template match="/pointList">
    <table border="1" align="center" cellpadding="10">
        <caption>Table of Points</caption>
        <tr>
            <th>x</th>
            <th>y</th>
            <th>unit</th>
        </tr>
        <xsl:apply-templates/>
    </table>
    </xsl:template>
    <xsl:template match="/pointList/point">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/pointList/point/x">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/pointList/point/y">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/pointList/point/unit">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
</xsl:stylesheet>