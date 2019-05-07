$(".menu-button-toggle").click(function(menuButton){
    $("body").toggleClass("sidebar-open");
    menuButton.preventDefault();
});