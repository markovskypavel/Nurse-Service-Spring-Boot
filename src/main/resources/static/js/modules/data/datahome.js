define("datahome", ['jquery', 'request', 'dataview'], function ($, request, dataview) {

    return function loadAllHome() {
        $('#home')
            .load($('#contextPathHolder').data("contextpath") + 'load/home', function () {
                /* Вывод информации о новостях в модальное окно + анимация затемнения */
                $('input[name=more]').on("click", function () {
                    const url = $(this).data("url");
                    request.getFetch(url, dataview.showNews)
                });
            });
    };

});

