define("dataservice", ['jquery', 'request', 'dataview'], function ($, request, dataview) {

    return function loadAllService() {
        $('#service')
            .load($('#contextPathHolder').data("contextpath") + 'load/service', function () {
                /* Вывод информации об услугах в модальное окно + анимация затемнения */
                $('input[name=more]').on("click", function () {
                    const url = $(this).data("url");
                    request.getFetch(url, dataview.showOrder);
                });

                /* Отписка пользователя */
                $('input[name=subscribe]').on("click", function () {
                    const url = $(this).data("url");
                    request.postFetch(url, loadAllService);
                });
            });

    };

});