<#assign ctx=request.contextPath />

<#macro fpage page pagesize totalpages totalrecords url>
    <li class="page-item"><span class="page-link">共条${totalrecords}记录  第${page}页/共${totalpages}页</span></li>

    <#assign startpage = page,endpage=10,showfirstpage=false,showlastpage=false,showpre=false,shownext=false,prepage = 1,nextpage=11>
    <#if page gt 1>
        <#assign showfirstpage = true>
        <#assign startpage=(page-4)>
        <#if startpage lte 0>
            <#assign startpage = 1>
        </#if>
    </#if>
    <#if page gt 5>
        <#assign showpre = true,prepage=page-5>
    </#if>
    <#if page+pagesize-1 lt totalpages>
        <#assign endpage = page+pagesize-1>
        <#assign shownext = true>
        <#assign nextpage=page+pagesize>
        <#assign showlastpage = true>
    <#else>
        <#assign endpage = totalpages>
    </#if>
    <#if endpage lte 0>
        <#assign endpage = 1>
    </#if>

    <#if showfirstpage>
        <li class="page-item"><span><a class="page-link" href="${url}&page=1">首页</a></span></li>
    </#if>
    <#if showpre>
        <li class="page-item"><span><a class="page-link" href="${url}&page=${prepage}">...</a></span></li>
    </#if>
    <#list startpage..endpage as p>
        <li  class="page-item <#if p == page>active</#if>"><span><a class="page-link" href="${url}&page=${p}">${p}</a></span></li>
    </#list>
    <#if shownext>
        <li class="page-item"><span><a class="page-link" href="${url}&page=${nextpage}">...</a></span></li>
    </#if>
    <#if showlastpage>
        <li class="page-item"><span><a class="page-link" href="${url}&page=${totalpages}">末页</a></span></li>
    </#if>
</#macro>
