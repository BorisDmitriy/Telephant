<#import "parts/common.ftl" as c>
<@c.page>

    <h4>Profile, ${username}</h4>
    <div>Change your data</div>

<form method="post">

    <div class="form-group row">
        <label  class="col-sm-2 col-form-label">Password: </label>
        <div class="col-sm-6 ">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Save</button>
</form>
</@c.page>