<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="mb-2">
    <h4>Login</h4>
</div>
    <@l.login "/login" false/>
</@c.page>