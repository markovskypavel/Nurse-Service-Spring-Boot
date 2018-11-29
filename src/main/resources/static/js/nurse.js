require.config({
    baseUrl: "/js",
    paths: {
        "jquery": "libs/jquery",
        "navbar": "modules/navbar",
        "dropdown": "modules/dropdown",
        "datanurse": "modules/data/datanurse",
        "dataview": "modules/data/dataview",
        "request": "modules/data/request"
    }
});

require(['datanurse', 'navbar', 'dropdown'], function (reload) {
    reload();
});