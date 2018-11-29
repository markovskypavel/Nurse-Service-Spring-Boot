define("dataview", ['jquery'], function ($) {

    function userInfoOrder(user) {
        var userInfo = '';
        if(!$.isEmptyObject(user)){
            userInfo += '<u>Имя заказчика</u></br>' + user.identity.name + '</br>';
            userInfo += '<u>Адрес эл.почты заказчика</u></br>' + user.email + '</br>';
        }
        return userInfo;
    }

    return {

        showNews: function (news) {
            return '<div id="win">' +
                        '<div class="overlay"></div>' +
                        '<div class="visible">' +
                            '<pre>' +
                                news.article +
                            '</pre>' +
                        '</div>' +
                    '</div>';
        },

        showOrder: function (order) {
            return '<div id="win">' +
                        '<div class="overlay"></div>' +
                        '<div class="visible">' +
                            '<pre>' +
                                '<u>Краткое описание</u></br>' + order.description + '</br>' +
                                '<u>Дата истечения</u></br>' + order.expireDate.substring(0, 10) + '</br>' +
                                '<u>Имя исполнителя</u></br>' + order.nurse.webIdentity.identity.name + '</br>' +
                                userInfoOrder(order.webIdentity) +
                                '<u>Опыт</u></br>' + order.nurse.experience + '</br>' +
                                /*'<u>Рейтинг</u></br>' + order.nurse.ratingType + '</br>' +*/
                                '<u>Статус</u></br>' + order.status +
                            '</pre>' +
                        '</div>' +
                    '</div>';
        },

    };

});