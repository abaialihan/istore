<#macro login path>

<form action="${path}" method="post">
    <div><label>Логин : <input type="text" name="username"/></label></div>
    <div><label>Пароль : <input type="password" name="password"/></label></div>
    <div><input type="submit" value="Войти"/></div>
</form>

</#macro>

<#macro reg path>

    <form action="${path}" method="post">
        <div><label>Имя : <input type="text" name="firstname"/></label></div>
        <div><label>Фамилия : <input type="text" name="lastname"/></label></div>
        <div><label>Логин : <input type="text" name="username"/></label></div>
        <div><label>Пароль : <input type="password" name="password"/></label></div>
        <div><input type="submit" value="Регистрация"/></div>
    </form>

</#macro>

<#macro logout>

<form action="/logout" method="post">
    <input type="submit" value="Выйти"/>
</form>

</#macro>