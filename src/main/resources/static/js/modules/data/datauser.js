define("datauser", ['jquery', 'request', 'dataview'], function ($, request, dataview) {

    return function loadAllUser() {
        $('#user')
            .load($('#contextPathHolder').data("contextpath") + 'load/user', function () {
                /* Вывод информации об услугах в модальное окно + анимация затемнения */
                $('input[name=more]').on("click", function () {
                    const url = $(this).data("url");
                    request.getFetch(url, dataview.showOrder);
                });

                /* Отписка пользователя */
                $('input[name=unsubscribe]').on("click", function () {
                    const url = $(this).data("url");
                    request.postFetch(url, loadAllUser);
                });
            });

    };

});