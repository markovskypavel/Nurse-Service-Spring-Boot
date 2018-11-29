define("dataadmin", ['jquery', 'request', 'dataview'], function ($, request, dataview) {

    return function loadAllAdmin() {
        $('#admin')
            .load($('#contextPathHolder').data("contextpath") + 'load/admin', function () {
                /* Dropdown */
                $('input[name=dropbtnnews], input[name=dropbtnservice]').on("click", function () {
                    $(this).next().toggleClass("show");
                });

                /* Вывод информации об услугах в модальное окно + анимация затемнения */
                $('input[name=more]').on("click", function () {
                    const url = $(this).data("url");
                    request.getFetch(url, dataview.showOrder);
                });

                /* Вывод информации о новостях в модальное окно + анимация затемнения */
                $('input[name=moreNews]').on("click", function () {
                    const url = $(this).data("url");
                    request.getFetch(url, dataview.showNews);
                });

                /* Переход на страницу редактирования */
                $('input[name=editNews], input[name=editService]').on("click", function () {
                    const url = $(this).data("url");
                    request.nextPage(url);
                });

                /* Удаление */
                $('input[name=deleteNews], input[name=deleteService]').on("click", function () {
                    const url = $(this).data("url");
                    request.postFetch(url, loadAllAdmin);
                });

            });
    };

});