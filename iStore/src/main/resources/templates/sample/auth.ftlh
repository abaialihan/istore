<#macro login path>

<form action="${path}" method="post">
    <div><label>Логин : <input type="text" name="username"/></label></div>
    <div><label>Пароль : <input type="password" name="password"/></label></div>
    <div><input type="submit" value="Зарегатся"/></div>
</form>

</#macro>

<#macro logout>

<form action="/logout" method="post">
    <input type="submit" value="Выйти"/>
</form>

</#macro>