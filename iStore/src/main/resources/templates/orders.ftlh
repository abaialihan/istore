<#import "sample/common.ftlh" as c>
<@c.page>
    Заказы

    <table>
        <thead>
        <tr>
            <th>Имя</th>
            <th>Товар</th>
        </tr>
        </thead>
        <tbody>
        <#list orders as order>
            <tr>
                <td>${order.user.username}</td>
                <td>${order.product.title}</td>
            </tr>
        </#list>
        </tbody>
    </table>

</@c.page>