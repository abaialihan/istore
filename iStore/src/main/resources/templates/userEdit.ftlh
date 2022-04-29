<#import "sample/common.ftlh" as c>

<@c.page>
        Изменить пользователя

<form action="/admin/users" method="post">
    <input type="text" name="username" value="${user.username}"/>
    <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
        </div>
    </#list>
    <input type="hidden" value="${user.id}" name="userId"/>
    <button type="submit">Сохранить</button>
</form>

</@c.page>