define("navbar", ['jquery'], function ($) {

    /* Hover для верхнего меню */
    $('ul.top-menu').find('li').on({
        mouseover: function () {
            $(this).css("background", "#684a3e");
            $(this).children(':first').css("color", "#ccbba8");
        },
        mouseout: function () {
            $(this).css("background", "");
            $(this).children(':first').css("color", "");
        }
    });

});