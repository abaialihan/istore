<#import "sample/common.ftlh" as c>
<#import "sample/auth.ftlh" as l>

<@c.page>
        Авторизация
<@l.login "/auth" />

<a href="/registration">Регистряция</a>

</@c.page>
