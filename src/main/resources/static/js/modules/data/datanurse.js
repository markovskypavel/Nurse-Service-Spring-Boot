define("datanurse", ['jquery', 'request', 'dataview'], function ($, request, dataview) {

    return function loadAllAdmin() {
        $('#nurse')
            .load($('#contextPathHolder').data("contextpath") + 'load/nurse', function () {
                /* Dropdown */
                $('input[name=dropbtnservice]').on("click", function () {
                    $(this).next().toggleClass("show");
                });

                /* Вывод информации об услугах в модальное окно + анимация затемнения */
                $('input[name=more]').on("click", function () {
                    const url = $(this).data("url");
                    request.getFetch(url, dataview.showOrder);
                });

                /* Переход на страницу редактирования */
                $('input[name=editService]').on("click", function () {
                    const url = $(this).data("url");
                    request.nextPage(url);
                });

                /* Удаление */
                $('input[name=deleteService]').on("click", function () {
                    const url = $(this).data("url");
                    request.postFetch(url, loadAllAdmin);
                });

            });

    };

});