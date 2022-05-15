<#import "pattern/common.ftlh" as c>

<@c.page>
    Заказы

    <table>
        <thead>
        <tr>
            <th>Имя</th>
            <th>Товар</th>
            <th>Цена</th>
            <th>Колличество</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <div>
            <tr>
                <td>${order.user.username}</td>
                <td>${order.product.title}</td>
                <td>${order.product.price}</td>
                <td>${order.quantity}</td>
            </tr>
        <#else>
            Нет заказов
            </div>
        </#list>
        </tbody>
    </table>

</@c.page>