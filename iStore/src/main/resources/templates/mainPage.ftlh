<#import "pattern/common.ftlh" as c>
<#import "pattern/auth.ftlh" as l>

<@c.page>


    <div>
    <@l.logout />
        <span><a href="/admin/users">Список пользователей</a></span>
    </div>

    <div>
        <form method="post">
            <input type="text" name="title" placeholder="Название продукта" />
            <input type="text" name="description" placeholder="Описание продукта" />
            <input type="text" name="price" placeholder="Цена" />
            <button type="submit">Добавить</button>
        </form>
    </div>

    <form method="get" action="/">
        <input type="text" name="titleFilter"/>
        <button type="submit">Найти</button>
    </form>

    <div>Список продуктов</div>
    <#list products as product>
        <div>
        <form method="post" action="/addtocart/${product.id}">
            <b>${product.id}</b>
            <span>${product.title}</span>
            <span>${product.description}</span>
            <span>${product.price}</span>
            <i>${product.userName}</i>
            <button type="submit">Заказать</button>
        </form>
    <#else>
        Нет продуктов
        </div>
    </#list>
    <div>
        <span><a href="/order">Заказы</a></span>
    </div>
</@c.page>
