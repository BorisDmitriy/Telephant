<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="mb-2">
    <h4>Add new user</h4>

</div>
    ${message?ifExists}
    <@l.login "/registration" true/>
</@c.page>