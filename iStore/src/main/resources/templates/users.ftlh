<#import "sample/common.ftlh" as c>

<@c.page>
        Пользователи

<table>
    <thead>
        <tr>
        <th>Имя</th>
        <th>Роль</th>
        <th></th>
        </tr>
    </thead>
    <tbody>
        <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/admin/users/${user.id}">Изменить</a></td>
        </tr>
        </#list>
    </tbody>
</table>

</@c.page>