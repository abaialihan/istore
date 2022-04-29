<#import "sample/common.ftlh" as c>
<#import "sample/auth.ftlh" as l>

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
                <b>${product.id}</b>
                <span>${product.title}</span>
                <span>${product.description}</span>
                <span>${product.price}</span>
                <i>${product.userName}</i>
                <#else>
                No message
            </div>
    </#list>
</@c.page>
