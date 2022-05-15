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
            <tr>
                <td>${order.user.username}</td>
                <td>${order.product.title}</td>
                <td>${order.product.price}</td>
                <td>${order.product.quantity}</td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>