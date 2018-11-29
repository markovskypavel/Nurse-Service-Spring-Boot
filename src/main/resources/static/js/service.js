require.config({
    baseUrl: "/js",
    paths: {
        "jquery": "libs/jquery",
        "navbar": "modules/navbar",
        "dataservice": "modules/data/dataservice",
        "dataview": "modules/data/dataview",
        "request": "modules/data/request"
    }
});

require(['dataservice', 'navbar'], function (reload) {
    reload();
});